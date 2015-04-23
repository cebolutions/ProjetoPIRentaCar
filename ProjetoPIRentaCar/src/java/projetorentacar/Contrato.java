package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Contrato {

    private int contratoId;
    private int clienteId;
    private int usuarioId;
    private int veiculoId;
    private Date dataRetirada;
    private Date dataDevolucao;
    private int quantidadeDiarias;
    private double saldoReserva;
    private int formaPagamentoId;
    private int filialId;

    public Contrato() {

    }

    public Contrato(int contratoId, int clienteId, int usuarioId,
            int veiculoId, Date dataRetirada, Date dataDevolucao, int quantidadeDiarias, int saldoReserva,
            int formaPagamentoId, int filialId) {

    }

    public void cadastrarContrato() {
        Scanner in = new Scanner(System.in);
        List<Veiculos> veiculos = new ArrayList<>();
        List fop = new ArrayList<>();
        Veiculos veic = new Veiculos();
        veiculos = veic.verificarDisponibilidade();
        System.out.println("VEICULOS");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(veiculos.get(i).getIdVeiculo() + " | "
                    + veiculos.get(i).getNomeVeiculo() + " | "
                    + veiculos.get(i).getCor() + " | "
                    + veiculos.get(i).getMarca());
        }

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

        System.out.println("s " + getSaldoReserva());
    }

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

    /*
    public void validarPagamento() {
        
    }

    public void getRetirada() {

    }

    public void setRetirada() {

    }

    public void getEntrega() {

    }

    public void setEntrega() {

    }
*/
    /**
     * @return the veiculoId
     */
    public int getVeiculoId() {
        return veiculoId;
    }

    /**
     * @return the dataRetirada
     */
    public Date getDataRetirada() {
        return dataRetirada;
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @return the quantidadeDiarias
     */
    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    /**
     * @return the saldoReserva
     */
    public double getSaldoReserva() {
        return saldoReserva;
    }

    /**
     * @return the formaPagamentoId
     */
    public int getFormaPagamentoId() {
        return formaPagamentoId;
    }

    /**
     * @return the filialId
     */
    public int getFilialId() {
        return filialId;
    }

    public static void main(String[] args) {
        Contrato c = new Contrato();
        c.cadastrarContrato();
    }
}
