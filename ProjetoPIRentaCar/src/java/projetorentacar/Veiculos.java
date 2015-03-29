package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class Veiculos {

    private int idVeiculo;
    private String cor;
    private String marca;
    private String categoria;
    private String nomeVeiculo;
    private String renavam;
    private String placa;
    private int quantidade;

    public Veiculos() {

    }

    public Veiculos(int idVeiculo, String nomeVeiculo, String placa,
            String cor, String marca, String categoria, int quantidade) {
        this.idVeiculo = idVeiculo;
        this.nomeVeiculo = nomeVeiculo;
        this.placa = placa;
        this.cor = cor;
        this.marca = marca;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public List verificarDisponibilidade() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        List<Veiculos> veiculos = new ArrayList<>();
        String cmdSQL = "SELECT ID_VEICULO, NOME_VEICULO, PLACA_VEICULO, DESCRICAO_COR, DESCRICAO_MARCA, DESCRICAO_CATEGORIA, QUANTIDADE "
                + "FROM TB_VEICULOS "
                + "INNER JOIN TB_CORES ON ID_COR = COR_ID "
                + "INNER JOIN TB_ESTOQUE ON ID_VEICULO = VEICULO_ID "
                + "INNER JOIN TB_MARCAS_VEICULOS ON ID_MARCA = MARCA_ID "
                + "INNER JOIN TB_CATEGORIA_VEICULOS ON ID_CATEGORIA = CATEGORIA_ID";

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQL);
            ResultSet disp = pstm.executeQuery();
            while (disp.next()) {

                this.idVeiculo = disp.getInt("ID_VEICULO");
                this.nomeVeiculo = disp.getString("NOME_VEICULO");
                this.placa = disp.getString("PLACA_VEICULO");
                this.cor = disp.getString("DESCRICAO_COR");
                this.marca = disp.getString("DESCRICAO_MARCA");
                this.categoria = disp.getString("DESCRICAO_CATEGORIA");
                this.quantidade = disp.getInt("QUANTIDADE");
                Veiculos v = new Veiculos(this.getIdVeiculo(), this.getNomeVeiculo(), this.getPlaca(), this.getCor(), this.getMarca(), this.getCategoria(), this.getQuantidade());
                veiculos.add(v);
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
        return veiculos;
    }

    public double saldoReserva(int quantidadeDiarias) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        double saldoReserva = 0;
        String cmdSQLSaldo = "SELECT ID_VEICULO, VALOR_CATEGORIA "
                + "FROM TB_VEICULOS JOIN TB_CATEGORIA_VEICULOS "
                + "ON CATEGORIA_ID = ID_CATEGORIA";
        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQLSaldo);
            res = pstm.executeQuery();
            double saldo = res.getBigDecimal("VALOR_CATEGORIA").doubleValue();
            System.out.println("Saldo: "+saldo);
            saldoReserva = saldo * quantidadeDiarias;
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
        return saldoReserva;
    }

    public void adicionarVeiculo() {

    }

    public void retirarVeiculo() {

    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public String getRenavam() {
        return renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
