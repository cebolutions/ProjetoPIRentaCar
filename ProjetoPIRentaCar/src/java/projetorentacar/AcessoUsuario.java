/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ygor.yppessoa
 */
public class AcessoUsuario {

    private String usuario;
    private String senha;
    private String cargo;

    public void validarUsuario(String usuario, String senha, String cargo) {
        ConexaoBDJavaDB conexao = new ConexaoBDJavaDB("RENTACAR");
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = conexao.obterConexao();
            String comandoSQL = "SELECT LOGIN, SENHA, DESCRICAO_CARGO\n" +
                                "FROM USUARIOS \n" +
                                "JOIN CARGOS ON CARGO_ID = ID_CARGO";
            pstmt = conn.prepareStatement(comandoSQL);
            
            pstmt.getResultSet();
                    
        } catch (Exception e){
            
        }
    }
}
