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
import java.util.Date;
import java.util.List;
import projetorentacar.Contrato;

/**
 *
 * @author pc
 */
public class ContratoDAO {

    public ContratoDAO() {

    }

    public void cadastrarContratoBD(Contrato contrato) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String cmdSQL = "INSERT INTO TB_CONTRATO (CLIENTE_ID, USUARIO_ID, VEICULO_ID, DATA_RETIRADA, DATA_DEVOLUCAO, QUANTIDADE_DIARIAS, TOTAL_RESERVA, SALDO_DA_RESERVA, FILIAL_ID, DATA_ABERTURA, DATA_FECHAMENTO, ABERTO) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);

            pstm.setInt(1, contrato.getClienteId());
            pstm.setInt(2, contrato.getUsuarioId());
            pstm.setInt(3, contrato.getVeiculoId());
            pstm.setDate(4, new java.sql.Date(contrato.getDataRetirada().getTime()));
            pstm.setDate(5, new java.sql.Date(contrato.getDataDevolucao().getTime()));
            pstm.setInt(6, contrato.getQuantidadeDiarias());
            pstm.setDouble(7, contrato.getSaldoReserva());
            pstm.setDouble(8, contrato.getSaldoReserva());
            pstm.setDouble(9, contrato.getFilialId());
            pstm.setDate(10, new java.sql.Date (contrato.getDataAbertura().getTime()));  
            pstm.setDate(11, null);  
            pstm.setBoolean(12, contrato.isAberto());
            

            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void fecharContrato(Contrato contrato, Date date) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String cmdSQL = "UPDATE TB_CONTRATO SET ABERTO='FALSE', DATA_FECHAMENTO='"+ new java.sql.Date(date.getTime()) +"' WHERE ID_CONTRATO = " + contrato.getContratoId();

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);
            pstm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public Contrato buscarContrato(int contratoId) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String cmdSQL = "SELECT * FROM TB_CONTRATO WHERE ID_CONTRATO = " + contratoId;

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);
            ResultSet r = pstm.executeQuery();
            while (r.next()) {
                int id = r.getInt(1);
                int cliente = r.getInt(2);
                int user = r.getInt(3);
                int veiculo = r.getInt(4);
                Date ret = r.getDate(5);
                Date dev = r.getDate(6);
                int diarias = r.getInt(7);
                double total = r.getDouble(8);
                double saldo = r.getDouble(9);
                int filial = r.getInt(10);
                Date abertura = r.getDate(11);
                Date fechamento = r.getDate(12);
                boolean ativo = r.getBoolean(13);
                Contrato contrato = new Contrato(id, cliente, user, veiculo, ret, dev, diarias, total, saldo, filial, abertura, fechamento, ativo);
                return contrato;
            }
            Contrato contrato = new Contrato();
            return contrato;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //RECUPERAR ULTIMO CONTRATO CADASTRADO PELO usuarioId
    public Contrato buscarUltimoContratoByUser(int usuarioId) {
        
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String cmdSQL = "SELECT * FROM TB_CONTRATO WHERE USUARIO_ID = "+usuarioId+" ORDER BY ID_CONTRATO DESC FETCH FIRST 1 ROWS ONLY";

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);
            ResultSet r = pstm.executeQuery();
            while (r.next()) {
                int id = r.getInt(1);
                int cliente = r.getInt(2);
                int user = r.getInt(3);
                int veiculo = r.getInt(4);
                Date ret = r.getDate(5);
                Date dev = r.getDate(6);
                int diarias = r.getInt(7);
                double total = r.getDouble(8);
                double saldo = r.getDouble(9);
                int filial = r.getInt(10);
                Date abertura = r.getDate(11);
                Date fechamento = r.getDate(12);
                boolean ativo = r.getBoolean(13);
                Contrato contrato = new Contrato(id, cliente, user, veiculo, ret, dev, diarias, total, saldo, filial, abertura, fechamento, ativo);
                return contrato;
            }
            return null;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public List<Contrato> listarContratos() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        List<Contrato> contratos = new ArrayList<>();
        String cmdSQL = "SELECT id_contrato, cl.nome_Cliente, data_Retirada, data_Devolucao, \n" +
        "       quantidade_Diarias, c.DESCRICAO_CATEGORIA, total_Reserva, data_Abertura, data_fechamento, f.nome_loja, aberto\n" +
        "from tb_contrato\n" +
        "inner join tb_cadastro_cliente as cl on cl.id_cliente = cliente_id\n" +
        "inner join tb_filiais as f on f.id_filial = filial_id\n" +
        "inner join tb_veiculos as v on v.id_veiculo = VEICULO_ID\n" +
        "inner join tb_categoria_veiculos as c on c.ID_CATEGORIA = v.CATEGORIA_ID";

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);
            ResultSet r = pstm.executeQuery();
            while (r.next()) {
                int id = r.getInt(1);
                String cliente = r.getString(2);
                Date ret = r.getDate(3);
                Date dev = r.getDate(4);
                int diarias = r.getInt(5);
                String categoria = r.getString(6);
                double total = r.getDouble(7);
                Date abertura = r.getDate(8);
                Date fechamento = r.getDate(9);
                String loja = r.getString(10);
                boolean ativo = r.getBoolean(11);
                Contrato contrato = new Contrato(id, cliente, ret, dev, diarias, categoria, total, abertura, fechamento, loja, ativo);
                contratos.add(contrato);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contratos;
    }
    
}