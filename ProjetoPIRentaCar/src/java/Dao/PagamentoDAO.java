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
import projetorentacar.Pagamento;

/**
 *
 * @author pc
 */
public class PagamentoDAO {

    public void cadastrarPagamentoBD(Pagamento pgto) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String cmdSQL = "INSERT INTO TB_PAGAMENTOS (CONTRATO_ID, FORMA_PAGAMENTO_ID, VALOR_PAGO) "
                + "VALUES (?,?,?)";

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);

            pstm.setInt(1, pgto.getContratoId());
            pstm.setInt(2, pgto.getFopId());
            pstm.setDouble(3, pgto.getValorPago());

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
    
     public double totalRecebidoByContrato(int contratoId) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
       double totalRecebido = 0;
        String cmdSQL = "SELECT * FROM TB_PAGAMENTOS WHERE CONTRATO_ID = "+contratoId;

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);
            ResultSet r = pstm.executeQuery();
            while (r.next()) {
                totalRecebido += r.getDouble("VALOR_PAGO");
                
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
        return totalRecebido;
    }
}
