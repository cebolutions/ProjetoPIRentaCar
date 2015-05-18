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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
public class VeiculoDAO {
    public List<Veiculos> verificarDisponibilidade() {
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

                int idVeiculo = disp.getInt("ID_VEICULO");
                String nomeVeiculo = disp.getString("NOME_VEICULO");
                String placa = disp.getString("PLACA_VEICULO");
                String cor = disp.getString("DESCRICAO_COR");
                String marca = disp.getString("DESCRICAO_MARCA");
                String categoria = disp.getString("DESCRICAO_CATEGORIA");
                int quantidade = disp.getInt("QUANTIDADE");
                Veiculos v = new Veiculos(idVeiculo, nomeVeiculo, placa, cor, marca, categoria, quantidade);
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

     public Veiculos verificarDisponibilidadeById(int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        Veiculos v = new Veiculos();
        String cmdSQL = "SELECT ID_VEICULO, NOME_VEICULO, PLACA_VEICULO, DESCRICAO_COR, DESCRICAO_MARCA, DESCRICAO_CATEGORIA, QUANTIDADE, VALOR_CATEGORIA "
                + "FROM TB_VEICULOS "
                + "INNER JOIN TB_CORES ON ID_COR = COR_ID "
                + "INNER JOIN TB_ESTOQUE ON ID_VEICULO = VEICULO_ID "
                + "INNER JOIN TB_MARCAS_VEICULOS ON ID_MARCA = MARCA_ID "
                + "INNER JOIN TB_CATEGORIA_VEICULOS ON ID_CATEGORIA = CATEGORIA_ID "
                + "WHERE ID_VEICULO = "+id;

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQL);
            ResultSet disp = pstm.executeQuery();
            while (disp.next()) {
                v.setIdVeiculo(disp.getInt("ID_VEICULO"));
                v.setNomeVeiculo(disp.getString("NOME_VEICULO"));
                v.setMarca(disp.getString("DESCRICAO_MARCA"));
                v.setCategoria(disp.getString("DESCRICAO_CATEGORIA"));
                v.setQuantidade(disp.getInt("QUANTIDADE"));
                v.setValorCategoria(disp.getDouble("VALOR_CATEGORIA"));
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
        return v;
    }

     
     public List<Veiculos> verificarDisponibilidadeByFilial(int filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        List<Veiculos> veiculos = new ArrayList<>();
        String cmdSQL = "SELECT ID_VEICULO, NOME_VEICULO, DESCRICAO_MARCA, DESCRICAO_CATEGORIA, QUANTIDADE, tb_estoque.filial_id, VALOR_CATEGORIA "
                + "FROM TB_VEICULOS "
                + "INNER JOIN TB_ESTOQUE ON ID_VEICULO = VEICULO_ID "
                + "INNER JOIN TB_MARCAS_VEICULOS ON ID_MARCA = MARCA_ID "
                + "INNER JOIN TB_CATEGORIA_VEICULOS ON ID_CATEGORIA = CATEGORIA_ID "
                + "WHERE tb_estoque.filial_id = "+filial+" AND TB_ESTOQUE.QUANTIDADE > 0";

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQL);
            ResultSet disp = pstm.executeQuery();
            while (disp.next()) {
                Veiculos v = new Veiculos();
                v.setIdVeiculo(disp.getInt("ID_VEICULO"));
                v.setNomeVeiculo(disp.getString("NOME_VEICULO"));
                v.setMarca(disp.getString("DESCRICAO_MARCA"));
                v.setCategoria(disp.getString("DESCRICAO_CATEGORIA"));
                v.setQuantidade(disp.getInt("QUANTIDADE"));
                v.setValorCategoria(disp.getDouble("VALOR_CATEGORIA"));
                
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

    public double saldoReserva(int quantidadeDiarias, double valorCategoria) {
        double saldoReserva = valorCategoria;
        saldoReserva *= quantidadeDiarias;
        //System.out.println("Saldo: " + saldoReserva);
        return saldoReserva;
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
    
    public void adicionarVeiculo(int id_veiculo, int id_filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstm = null;

        String cmdSQL = "UPDATE TB_ESTOQUE"
                + " SET QUANTIDADE = QUANTIDADE + 1"
                + " WHERE TB_ESTOQUE.VEICULO_ID = ? AND TB_ESTOQUE.FILIAL_ID = ?";
        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQL);
            pstm.setInt(1, id_veiculo);
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

    public void retirarVeiculo(int id_veiculo_alocado, int id_filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        String comandoSQL = "UPDATE TB_ESTOQUE"
                + " SET QUANTIDADE = QUANTIDADE - 1"
                + " WHERE TB_ESTOQUE.VEICULO_ID = ? AND TB_ESTOQUE.FILIAL_ID = ?";

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
}
