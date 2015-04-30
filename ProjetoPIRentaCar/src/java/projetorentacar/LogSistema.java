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
import java.util.Date;

/**
 *
 * @author pc
 */

//transformar em interface
public class LogSistema {
    
    public LogSistema(){
        
    }
    public void cadastrarLog (int log, int id){
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        String cmdSQL = "INSERT INTO TB_HISTORICO_ACESSO (USUARIO_ID, TIPO_LOG_ID, DATA_SISTEMA, HORA_SISTEMA)"
                + " VALUES (?,?,?,?)";
        Date dataUtil = new Date();
        java.sql.Date data = new java.sql.Date(dataUtil.getTime());
        java.sql.Time hora = new java.sql.Time(dataUtil.getTime());
        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQL);
            
            pstm.setInt(1, id);
            pstm.setInt(2, log);
            pstm.setDate(3, data);
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

}
