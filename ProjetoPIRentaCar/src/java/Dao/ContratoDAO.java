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
        String cmdSQL = "INSERT INTO TB_CONTRATO (CLIENTE_ID, USUARIO_ID, VEICULO_ID, DATA_RETIRADA, DATA_DEVOLUCAO, QUANTIDADE_DIARIAS, SALDO_DA_RESERVA, FILIAL_ID, ABERTO) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

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
            pstm.setDouble(8, contrato.getFilialId());
            pstm.setBoolean(9, contrato.isAberto());

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

    public void fecharContrato(Contrato contrato) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("rentacar");
        Connection con = null;
        PreparedStatement pstm = null;
        String cmdSQL = "UPDATE TB_CONTRATO SET ABERTO='FALSE' "
                + "WHERE ID_CONTRATO = " + contrato.getContratoId();

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
    /*
     public void cadastrarContrato() {
     Scanner in = new Scanner(System.in);
     List<Veiculos> veiculos = new ArrayList<>();
     List fop = new ArrayList<>();
     VeiculoDAO v = new VeiculoDAO();
     Veiculos veic = new Veiculos();
     veiculos = v.verificarDisponibilidade();
     System.out.println("VEICULOS");
     for (int i = 0; i < veiculos.size(); i++) {
     System.out.println(veiculos.get(i).getIdVeiculo() + " | "
     + veiculos.get(i).getNomeVeiculo() + " | "
     + veiculos.get(i).getCor() + " | "
     + veiculos.get(i).getMarca());
     }
     //passar esses dados por parametro
     System.out.print("Escolha o veículo: ");
     this.veiculoId = in.nextInt();

     System.out.print("Informe a data de retirada: ");
     String dtRet = in.next();
     System.out.print("Informe a data de devolução: ");
     String dtDev = in.next();
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     try {
     this.dataRetirada = dateFormat.parse(dtRet);
     this.dataDevolucao = dateFormat.parse(dtDev);
     } catch (ParseException e) {
     e.printStackTrace();
     }

     System.out.println("Quantidade de diárias: ");
     this.quantidadeDiarias = in.nextInt();

     this.saldoReserva = veic.saldoReserva(this.getQuantidadeDiarias());

     System.out.println("FORMAS DE PAGAMENTOS");
     verificarFormaPagto();
     this.formaPagamentoId = in.nextInt();

     System.out.println("ESCOLHA A FILIAL");
     verificarFiliais();
     this.filialId = in.nextInt();

     //System.out.println("s " + getSaldoReserva());
     }
     */

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
                double saldo = r.getDouble(8);
                int filial = r.getInt(9);
                boolean ativo = r.getBoolean(10);
                Contrato contrato = new Contrato(id, cliente, user, veiculo, ret, dev, diarias, saldo, filial, ativo);
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
        String cmdSQL = "SELECT * FROM TB_CONTRATO";

        try {
            con = cnx.obterConexao();
            pstm = con.prepareStatement(cmdSQL);
            ResultSet r = pstm.executeQuery();
            while (r.next()) {
                int id = r.getInt(2);
                int cliente = r.getInt(2);
                int user = r.getInt(3);
                int veiculo = r.getInt(4);
                Date ret = r.getDate(5);
                Date dev = r.getDate(6);
                int diarias = r.getInt(7);
                double saldo = r.getDouble(8);
                int filial = r.getInt(9);
                boolean ativo = r.getBoolean(10);
                Contrato contrato = new Contrato(id, cliente, user, veiculo, ret, dev, diarias, saldo, filial, ativo);
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
    /*
     public void verificarFormaPagto() {
     ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
     Connection conn = null;
     PreparedStatement pstm = null;
     ResultSet res = null;
     String cmdSQLFop = "SELECT * FROM TB_FORMA_DE_PAGAMENTOS";
     try {
     conn = cnx.obterConexao();
     pstm = conn.prepareStatement(cmdSQLFop);
     res = pstm.executeQuery();
     int i = 0;
     while (res.next()) {
     String f = res.getString(2);
     System.out.println(i + " | " + f);
     i++;
     }
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
     */

    public void verificarFiliais() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet filiais = null;

        String comandoSQL = "SELECT * FROM TB_FILIAIS";
        String descricao_filiais;
        int id_formaPagamento;

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(comandoSQL);
            filiais = pstm.executeQuery();
            while (filiais.next()) {
                id_formaPagamento = filiais.getInt(1);
                descricao_filiais = filiais.getString(2);
                System.out.println(id_formaPagamento + " | " + descricao_filiais);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
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
