/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author pc
 */
public class LogSistema {
    private int usuarioId;
    
    public LogSistema(){
        
    }
    public void cadastrarLog (int i){
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        String cmdSQL = "INSERT INTO TB_HISTORICO_ACESSO (USUARIO_ID, TIPO_LOG_ID, DATA_SISTEMA, HORA SISTEMA)"
                + "VALUES (?,?,?,?);";
        Date data = new Date();
        Time hora = null;
        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQL);
            
            pstm.setInt(1, usuarioId);
            pstm.setInt(2, i);
            pstm.setDate(3, (java.sql.Date) data);
            pstm.setTime(4, hora);
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
