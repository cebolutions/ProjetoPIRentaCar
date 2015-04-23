package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                + "INNER JOIN TB_CORES ON TB_CORES.ID_COR = TB_VEICULOS.COR_ID "
                + "INNER JOIN TB_ESTOQUE ON TB_ESTOQUE.VEICULO_ID = TB_ESTOQUE.VEICULO_ID "
                + "INNER JOIN TB_MARCAS_VEICULOS ON TB_MARCAS_VEICULOS.ID_MARCA = TB_VEICULOS.MARCA_ID "
                + "INNER JOIN TB_CATEGORIA_VEICULOS ON TB_CATEGORIA_VEICULOS.ID_CATEGORIA = TB_VEICULOS.CATEGORIA_ID ";

        String comandoSQL = "SELECT ENDERECO_FILIAL FROM TB_FILIAIS "
                + "JOIN TB_ESTOQUE ON TB_ESTOQUE.FILIAL_ID = TB_FILIAIS.ID_FILIAL";

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

    public double valorCategoria() {
        Scanner sc = new Scanner(System.in);
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        String cmdSQLSaldo = "SELECT ID_VEICULO, VALOR_CATEGORIA, DESCRICAO_CATEGORIA "
                + "FROM TB_VEICULOS JOIN TB_CATEGORIA_VEICULOS "
                + "ON TB_VEICULOS.CATEGORIA_ID = TB_CATEGORIA_VEICULOS.ID_CATEGORIA";
        //Irá servir de 'id' dentro do laço
        int i = 0;
        double valCategoria = 0;
        int categoria = 0, controla_id_categoria = -1;
        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQLSaldo);
            res = pstm.executeQuery();
            while (res.next()) {
                controla_id_categoria++;
                valCategoria = res.getInt(2);
                String descCategoria = res.getString(3);
                System.out.println("ID: " + i + " | Categoria: " + descCategoria + " | Valor Categoria: " + valCategoria);
                i++;
            }

            i = 0;

            System.out.println("Informe a categoria que deseja:");
            categoria = sc.nextInt();

            if (categoria > controla_id_categoria) {
                System.out.println("Opção Inválida");
                valCategoria = 0;
            } else if (categoria <= controla_id_categoria) {
                res = pstm.executeQuery();
                while (res.next()) {
                    if (categoria == i) {
                        valCategoria = res.getInt(2);
                        System.out.println(valCategoria);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return valCategoria;
    }

    public double saldoReserva(int quantidadeDiarias) {
        double saldoReserva = valorCategoria();
        saldoReserva *= quantidadeDiarias;
        System.out.println("Saldo: " + saldoReserva);
        return saldoReserva;
    }

    
    /*
        Comparar o valor de valor de contrato com valor da quantidade de diárias
    */
    public void adicionarVeiculo(/*int id_veiculo_alocado, int id_filial, Date dataEntrega*/) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet addVeiculo = null;

        String cmdSQL = "UPDATE TB_ESTOQUE"
                + " SET QUANTIDADE = QUANTIDADE + 1"
                + " WHERE TB_ESTOQUE.VEICULO_ID = ? AND TB_ESTOQUE.FILIAL_ID = ?";

        //1,2,3 testando...
        String data = "2015/04/15";
        Date teste = null;

        SimpleDateFormat formatData = new SimpleDateFormat("yyyy/MM/dd");

        try {
            teste = formatData.parse(data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String r = String.valueOf(teste);

        if (teste.equals(r)) {
            System.out.println("Data formatada e são iguais ");
        } else {
            System.out.println("////");
        }
    }

    public void retirarVeiculo(int id_veiculo_alocado, int id_filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        String comandoSQL = "UPDATE TB_ESTOQUE"
                + " SET QUANTIDADE = QUANTIDADE - 1"
                + " WHERE TB_ESTOQUE.VEICULO_ID = ? AND TB_ESTOQUE.FILIAL_ID = ? ";

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(comandoSQL);
            pstm.setInt(1, id_veiculo_alocado);
            pstm.setInt(2, id_filial);
            pstm.executeUpdate();
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
            }
        }
    }

    //criado em 13/04 para verificação da quantidade de veículos
    public int verificaQuantidadeVeiculo(int id_veiculo, int id_filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        int quantidadeVeic = 0;

        String comandoSQL = "SELECT QUANTIDADE"
                + " FROM TB_ESTOQUE"
                + " WHERE VEICULO_ID = " + id_veiculo + " AND FILIAL_ID = " + id_filial;

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(comandoSQL);
            res = pstm.executeQuery();

            while (res.next()) {
                quantidadeVeic = res.getInt(1);
                System.out.println(quantidadeVeic);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return quantidadeVeic;
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

    public static void main(String[] args) {
        Veiculos v = new Veiculos();
//        List<Veiculos> lstVeiculo = new ArrayList<Veiculos>();
//        v.retirarVeiculo(1, 0);
//
//        lstVeiculo = v.verificarDisponibilidade();
//
//        for (int i = 0; i < lstVeiculo.size(); i++) {
//            System.out.println(lstVeiculo.get(i).getQuantidade());
//        }


        //v.verificaQuantidadeVeiculo(1, 0);
        
        v.adicionarVeiculo();
    }
}
