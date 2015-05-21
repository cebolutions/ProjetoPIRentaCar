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
import projetorentacar.Relatorio;

/**
 *
 * @author pc
 */
public class RelatorioDAO {

    //SELECT PARA BUSCAR A QUANTIDADE DE VEICULOS , AGRUPADO POR VEICULO VENDIDOS POR USUÁRIO 
    public List<Relatorio> qtdVeiculosPorUsuario() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO , COUNT(VEICULO_ID), NOME_VEICULO \n"
                    + "    FROM TB_CONTRATO \n"
                    + "    JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "    JOIN TB_VEICULOS ON TB_CONTRATO.VEICULO_ID  = TB_VEICULOS.ID_VEICULO\n"
                    + "    GROUP BY NOME_USUARIO , NOME_VEICULO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setNomeUsuario(relatorio.getString(1));
                r.setQtdVeiculo(relatorio.getInt(2));
                r.setNomeVeiculo(relatorio.getString(3));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    //SELECT PARA SABER A QUANTIDADE DE VEICULOS ALOCADO POR USUARIOS
    public List<Relatorio> veiculosPorUsuarios() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, COUNT(VEICULO_ID)\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "     GROUP BY NOME_USUARIO";

            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setNomeUsuario(relatorio.getString(1));
                r.setQtdVeiculo(relatorio.getInt(2));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    //SELECT PARA SABER O TOTAL DE VENDAS A PARTIR DE UM USUÁRIO
    public Relatorio totalVendasDeUsuarioPorFilial(int id, int filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, COUNT(VEICULO_ID)\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "     WHERE USUARIO_ID = " + id + " AND TB_CONTRATO.FILIAL_ID = " + filial + " GROUP BY NOME_USUARIO";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setNomeUsuario(relatorio.getString(1));
                r.setQtdVeiculo(relatorio.getInt(2));
                return r;
            }
            return null;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

//SELECT PARA SABER QUAL O VALOR TOTAL DE VENDAS POR USUARIO EM UM PERÍODO DEFINIDO
    public List<Relatorio> totalVendasPorUsuariosPorPeriodoEFilial(Date perInicial, Date perFinal, int filial) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO , SUM(TOTAL_RESERVA)\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "     WHERE DATA_ABERTURA >= '" + new java.sql.Date(perInicial.getTime()) + "' AND DATA_ABERTURA <= '" + new java.sql.Date(perFinal.getTime()) + "' AND TB_CONTRATO.FILIAL_ID = "+ filial +""
                    + "     GROUP BY NOME_USUARIO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setNomeUsuario(relatorio.getString(1));
                r.setTotalVendas(relatorio.getDouble(2));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

//TODAS AS ALOCAÇÕES FEITAS POR UM UNICO USUARIO, NA CLAUSULA WHERE, ONDE USUARIO_ID = VALOR PASSADO PELO JSP/SERVELET
//FILTRO POR DATA
    public List<Relatorio> vendasPorUsuarioPorPeriodo(Date perInicial, Date perFinal, int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, VEICULO_ID, NOME_VEICULO, COUNT(VEICULO_ID), DATA_RETIRADA, DATA_DEVOLUCAO\n"
                    + "FROM TB_CONTRATO\n"
                    + "JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID = TB_USUARIOS.ID_USUARIO\n"
                    + "JOIN TB_VEICULOS ON TB_CONTRATO.VEICULO_ID = TB_VEICULOS.ID_VEICULO\n"
                    + "WHERE DATA_ABERTURA >= '" + new java.sql.Date(perInicial.getTime()) + "' AND DATA_ABERTURA <= '" + new java.sql.Date(perFinal.getTime()) + "' AND USUARIO_ID = " + id + " "
                    + "GROUP BY NOME_USUARIO, VEICULO_ID, NOME_VEICULO, DATA_RETIRADA, DATA_DEVOLUCAO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setNomeUsuario(relatorio.getString(1));
                r.setVeiculoId(relatorio.getInt(2));
                r.setNomeVeiculo(relatorio.getString(3));
                r.setQtdVeiculo(relatorio.getInt(4));
                r.setDataRetirada(relatorio.getDate(5));
                r.setDataDevolucao(relatorio.getDate(6));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

//QUANTIDADE DE VEICULOS VENDIDOS POR FILIAL - GERENTE
    public List<Relatorio> veiculosPorFilial() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT COUNT(VEICULO_ID), NOME_LOJA\n"
                    + "FROM TB_CONTRATO\n"
                    + "JOIN TB_FILIAIS ON TB_FILIAIS.ID_FILIAL = TB_CONTRATO.FILIAL_ID\n"
                    + "GROUP BY NOME_LOJA";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setQtdVeiculo(relatorio.getInt(1));
                r.setNomeLoja(relatorio.getString(2));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    //relatorio Diretor
    public List<Relatorio> totalVendasFiliais() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT SUM(TOTAL_RESERVA), NOME_LOJA\n"
                    + "FROM TB_CONTRATO\n"
                    + "JOIN TB_FILIAIS ON TB_CONTRATO.FILIAL_ID = TB_FILIAIS.ID_FILIAL\n"
                    + "GROUP BY NOME_LOJA";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setTotalVendas(relatorio.getDouble(1));
                r.setNomeLoja(relatorio.getString(2));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

      public List<Relatorio> historicoLog() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, TIPO_LOG, DATA_SISTEMA, HORA_SISTEMA\n"
                    + "FROM TB_HISTORICO_ACESSO\n"
                    + "JOIN TB_USUARIOS ON TB_USUARIOS.ID_USUARIO = TB_HISTORICO_ACESSO.USUARIO_ID\n"
                    + "JOIN TB_TIPO_LOG ON TB_TIPO_LOG.ID_TIPO_LOG = TB_HISTORICO_ACESSO.TIPO_LOG_ID\n"
                    + "GROUP BY NOME_USUARIO, TIPO_LOG, DATA_SISTEMA, HORA_SISTEMA";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();
                r.setNomeUsuario(relatorio.getString(1));
                r.setTipoLog(relatorio.getString(2));
                r.setDataLog(relatorio.getDate(3));
                r.setHoraLog(relatorio.getTime(4));
                lista.add(r);
            }
            return lista;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return null;
    }

}
