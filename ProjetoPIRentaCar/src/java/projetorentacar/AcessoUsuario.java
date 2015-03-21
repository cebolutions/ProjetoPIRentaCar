/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ygor.yppessoa
 */
public class AcessoUsuario {

    private String usuario = null;
    private String senha;
    private String cargo;
    
    //String usuario, String senha, String cargo
    public boolean validarUsuario(String log, String pass) {
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("usu");
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = conexao.obterConexao();
            String comandoSQL = ("SELECT LOGIN, SENHA, DESCRICAO_CARGO FROM USUARIOS "
                   + "JOIN CARGOS ON CARGO_ID = ID_CARGO WHERE LOGIN = '"+ log+"'");
            System.out.println(comandoSQL);
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet resp = pstmt.executeQuery();
            while(resp.next()){
            this.usuario = resp.getString(1);
            this.senha = resp.getString(2);
            this.cargo = resp.getString(3);
            }
            pstmt.close();
            if(this.usuario == null){
                System.out.println("Não existe usuario no sistema");
                return false;
            }
         
        } catch (SQLException ex){
            ex.printStackTrace();
            } catch (Exception e){
           e.printStackTrace();
            
        }
        return validar(log, pass);
    }
    
    public boolean validar(String log, String pass){
        if(this.usuario.equalsIgnoreCase(log) && this.senha.equalsIgnoreCase(pass)){
            System.out.println("Credencias OK!");
            return true;
        }
        System.out.println("Credenciais erradas.");
        return false;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }
    
    
}
