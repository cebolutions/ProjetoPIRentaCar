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

/**
 *
 * @author ygor.yppessoa
 */
public class AcessoUsuario {

    private String usuario;
    private String senha;
    private String cargo;
    
    //String usuario, String senha, String cargo
    public void validarUsuario() {
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = conexao.obterConexao();
            String comandoSQL = "SELECT LOGIN, SENHA, DESCRICAO_CARGO\n" +
                                "FROM USUARIOS \n" +
                                "JOIN CARGOS ON CARGO_ID = ID_CARGO";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet resp = pstmt.executeQuery();
            while(resp.next()){
            this.usuario = resp.getString(1);
            this.senha = resp.getString(2);
            this.cargo = resp.getString(3);
            }
        } catch (Exception e){
            
        }
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
