/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetorentacar.Cliente;

/**
 *
 * @author pc
 */
public class ClienteDAO extends Cliente {

    public void cadastrarClienteBD(Cliente c) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "INSERT INTO TB_CADASTRO_CLIENTE (NOME_CLIENTE, RG, CPF, CNH, DATA_NASCIMENTO, DATA_CADASTRO) "
                + "VALUES (?,?,?,?,?,?)";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getRg());
            pstmt.setString(3, c.getCpf());
            pstmt.setString(4, c.getCnh());
            pstmt.setDate(5, new java.sql.Date(c.getDataNascimento().getTime()));
            pstmt.setDate(6, new java.sql.Date(c.getDataCadastro().getTime()));
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List buscarCliente() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Cliente> lClientes = new ArrayList<Cliente>();
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_CADASTRO_CLIENTE";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet cliente = pstmt.executeQuery();
            while (cliente.next()) {
                Cliente c = new Cliente();
                c.setClienteId(cliente.getInt(1));
                c.setNome(cliente.getString(2));
                c.setRg(cliente.getString(3));
                c.setCpf(cliente.getString(4));
                c.setCnh(cliente.getString(5));
                c.setDataNascimento(cliente.getDate(6));
                c.setDataCadastro(cliente.getDate(7));
                lClientes.add(c);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return lClientes;
    }

    public Cliente buscarClienteByCpf(String cpf) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Cliente> lClientes = new ArrayList<Cliente>();
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_CADASTRO_CLIENTE WHERE CPF = '" + cpf + "'";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet cliente = pstmt.executeQuery();
            while (cliente.next()) {
                Cliente c = new Cliente();
                c.setClienteId(cliente.getInt(1));
                c.setNome(cliente.getString(2));
                c.setRg(cliente.getString(3));
                c.setCpf(cliente.getString(4));
                c.setCnh(cliente.getString(5));
                c.setDataNascimento(cliente.getDate(6));
                c.setDataCadastro(cliente.getDate(7));
                return c;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    public void updateCliente(Cliente c) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("Rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String comandoSQL = "UPDATE TB_CADASTRO_CLIENTE SET NOME_CLIENTE=?, RG=?, CPF=?, CNH=?, DATA_NASCIMENTO=? WHERE ID_CLIENTE = ?";
        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(comandoSQL);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getRg());
            pstm.setString(3, c.getCpf());
            pstm.setString(4, c.getCnh());
            pstm.setDate(5, new java.sql.Date(c.getDataNascimento().getTime()));
            pstm.setInt(6, c.getClienteId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
