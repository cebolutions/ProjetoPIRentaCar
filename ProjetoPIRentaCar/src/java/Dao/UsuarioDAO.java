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
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
public class UsuarioDAO extends Usuario {
    
    public void cadastrarUsuarioBD(Usuario u) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "INSERT INTO TB_USUARIOS (NOME_USUARIO, RG, CPF, LOGIN, SENHA, ATIVO, CARGO_ID, FILIAL_ID) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, u.getNome());
            pstmt.setString(2, u.getRg());
            pstmt.setString(3, u.getCpf());
            pstmt.setString(4, u.getLogin());
            pstmt.setString(5, u.getSenha());
            pstmt.setBoolean(6, u.isAtivo());
            pstmt.setInt(7, u.getCargo());
            pstmt.setInt(8, u.getFilial());
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
    public void updateUsuarioBD(Usuario u) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "UPDATE TB_USUARIOS SET NOME_USUARIO=?, RG=?, CPF=?, LOGIN=?, SENHA=?, ATIVO=?, CARGO_ID=?, FILIAL_ID=? WHERE ID_USUARIO = ?";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, u.getNome());
            pstmt.setString(2, u.getRg());
            pstmt.setString(3, u.getCpf());
            pstmt.setString(4, u.getLogin());
            pstmt.setString(5, u.getSenha());
            pstmt.setBoolean(6, u.isAtivo());
            pstmt.setInt(7, u.getCargo());
            pstmt.setInt(8, u.getFilial());
            pstmt.setInt(9, u.getUsuarioId());
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
    public List buscarUsuarios() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Usuario> lUsers = new ArrayList<Usuario>();
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_USUARIOS";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet user = pstmt.executeQuery();
            while (user.next()) {
                Usuario u = new Usuario();
                u.setUsuarioId(user.getInt(1));
                u.setNome(user.getString(2));
                u.setRg(user.getString(3));
                u.setCpf(user.getString(4));
                u.setLogin(user.getString(5));
                u.setSenha(user.getString(6));
                u.setAtivo(user.getBoolean(7));
                u.setCargo(user.getInt(8));
                u.setFilial(user.getInt(9));
                lUsers.add(u);
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
        return lUsers;
    }

    public Usuario buscarUsuarioByCpf(String cpf) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_USUARIOS WHERE CPF = '" + cpf + "'";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet user = pstmt.executeQuery();
            while (user.next()) {
                Usuario u = new Usuario();
                u.setUsuarioId(user.getInt(1));
                u.setNome(user.getString(2));
                u.setRg(user.getString(3));
                u.setCpf(user.getString(4));
                u.setLogin(user.getString(5));
                u.setSenha(user.getString(6));
                u.setAtivo(user.getBoolean(7));
                u.setCargo(user.getInt(8));
                u.setFilial(user.getInt(9));
                return u;
            }
            Usuario u = new Usuario();
            return u;

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
    public Usuario buscarLogin(String login) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_USUARIOS WHERE LOGIN = '" + login + "'";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet user = pstmt.executeQuery();
            while (user.next()) {
                Usuario u = new Usuario();
                u.setUsuarioId(user.getInt(1));
                u.setNome(user.getString(2));
                u.setRg(user.getString(3));
                u.setCpf(user.getString(4));
                u.setLogin(user.getString(5));
                u.setSenha(user.getString(6));
                u.setAtivo(user.getBoolean(7));
                u.setCargo(user.getInt(8));
                u.setFilial(user.getInt(9));
                return u;
            }
            Usuario u = new Usuario();
            return u;

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
    public void deleteUsuarioBD(int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "DELETE FROM TB_USUARIOS WHERE ID_USUARIO = ?";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setInt(1, id);
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
}
