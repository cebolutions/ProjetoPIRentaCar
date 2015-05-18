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
import java.util.List;
import projetorentacar.Relatorio;

/**
 *
 * @author pc
 */
public class RelatorioDAO {

    //SELECT PARA BUSCAR A QUANTIDADE DE VEICULOS , AGRUPADO POR VEICULO VENDIDOS POR USUÁRIO 
    public List<Relatorio> qtdVeiculosPorUsuario(int id) {
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

    //SELECT PARA SABER A QUANTIDADE DE VEICULOS ALOCADO POR USUARIO
    public List<Relatorio> veiculosPorUsuario(int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, COUNT(VEICULO_ID)\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO\n"
                    + "     .USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "     GROUP BY NOME_USUARIO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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
    public List<Relatorio> totalVendasDeUsuario(int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, COUNT(VEICULO_ID)\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO\n"
                    + "     .USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "     WHERE USUARIO_ID = 0\n"
                    + "     GROUP BY NOME_USUARIO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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

    //SELECT PARA SABER QUAL O VALOR TOTAL DE VENDAS POR USUARIO 
    public List<Relatorio> totalVendasPorUsuarios() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO , SUM(SALDO_DA_RESERVA), DATA_RETIRADA , DATA_DEVOLUCAO\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO\n"
                    + "     .USUARIO_ID  = TB_USUARIOS.ID_USUARIO\n"
                    + "     WHERE DATA_RETIRADA >= '2015-01-01' AND DATA_DEVOLUCAO <= '2015-06-01'\n"
                    + "     GROUP BY NOME_USUARIO , DATA_RETIRADA, DATA_DEVOLUCAO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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

    //RETORNA A SOMA TOTAL DE VENDAS FEITA POR USUARIO , NO 1 SEMESTRE(ISSO PODE SER MUDADO)
    public List<Relatorio> totalVendasPorUsuariosSem() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, SUM(SALDO_DA_RESERVA)\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID = TB_USUARIOS.ID_USUARIO\n"
                    + "     WHERE DATA_RETIRADA >= '2015-01-01' OR DATA_DEVOLUCAO <= '2015-01-01'\n"
                    + "     GROUP BY NOME_USUARIO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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

    //RETORNA A VENDA DE TODOS OS FUNCIONARIOS DA FILIAL CORRESPONDE, DE ACORDO COM A DATA SELECIONADA
    public List<Relatorio> vendasUsuariosPorFilial(int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, VEICULO_ID, NOME_VEICULO, COUNT(VEICULO_ID), DATA_RETIRADA, DATA_DEVOLUCAO\n"
                    + "     FROM TB_CONTRATO\n"
                    + "     JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID = TB_USUARIOS.ID_USUARIO\n"
                    + "     JOIN TB_VEICULOS ON TB_CONTRATO.VEICULO_ID = TB_VEICULOS.ID_VEICULO\n"
                    + "     WHERE DATA_RETIRADA >= '2015-01-01' AND DATA_DEVOLUCAO <= '2015-06-01'\n"
                    + "     GROUP BY NOME_USUARIO, VEICULO_ID, NOME_VEICULO, DATA_RETIRADA, DATA_DEVOLUCAO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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
    public List<Relatorio> vendasPorUsuario(int id) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT NOME_USUARIO, VEICULO_ID, NOME_VEICULO, COUNT(VEICULO_ID), DATA_RETIRADA, DATA_DEVOLUCAO\n"
                    + "FROM TB_CONTRATO\n"
                    + "JOIN TB_USUARIOS ON TB_CONTRATO.USUARIO_ID = TB_USUARIOS.ID_USUARIO\n"
                    + "JOIN TB_VEICULOS ON TB_CONTRATO.VEICULO_ID = TB_VEICULOS.ID_VEICULO\n"
                    + "WHERE (DATA_RETIRADA >= '2015-01-01' AND DATA_DEVOLUCAO <= '2015-06-01') AND USUARIO_ID = 0\n"
                    + "GROUP BY NOME_USUARIO, VEICULO_ID, NOME_VEICULO, DATA_RETIRADA, DATA_DEVOLUCAO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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

//QUANTIDADE DE VEICULOS VENDIDOS POR FILIAL
    public List<Relatorio> veiculosPorFilial() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT COUNT(VEICULO_ID), FILIAL_ID\n"
                    + "FROM TB_CONTRATO\n"
                    + "GROUP BY FILIAL_ID";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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

//RETORNA A QUANTIDADE DE VEZES Q FOI UTILIZADO CARTÃO E DINHEIRO, MAS UM CONTROLE PARA SABER O Q ESTÁ SENDO UTILIZADO MAIS PELOS OS 'CLIENTES'
    public List<Relatorio> formasPagamento() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT TIPO_PAGAMENTO, NOME_VEICULO, COUNT(VEICULO_ID)\n"
                    + "FROM TB_CONTRATO\n"
                    + "JOIN TB_FORMA_DE_PAGAMENTOS ON TB_CONTRATO.FORMA_PAGAMENTO_ID = TB_FORMA_DE_PAGAMENTOS.ID_FORMA_PAGAMENTO\n"
                    + "JOIN TB_VEICULOS ON TB_CONTRATO.VEICULO_ID = TB_VEICULOS.ID_VEICULO\n"
                    + "GROUP BY TIPO_PAGAMENTO, NOME_VEICULO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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
            String comandoSQL = "SELECT TIPO_PAGAMENTO, NOME_VEICULO, COUNT(VEICULO_ID)\n"
                    + "FROM TB_CONTRATO\n"
                    + "JOIN TB_FORMA_DE_PAGAMENTOS ON TB_CONTRATO.FORMA_PAGAMENTO_ID = TB_FORMA_DE_PAGAMENTOS.ID_FORMA_PAGAMENTO\n"
                    + "JOIN TB_VEICULOS ON TB_CONTRATO.VEICULO_ID = TB_VEICULOS.ID_VEICULO\n"
                    + "GROUP BY TIPO_PAGAMENTO, NOME_VEICULO";
            pstmt = conn.prepareStatement(comandoSQL);
            List<Relatorio> lista = new ArrayList<>();
            ResultSet relatorio = pstmt.executeQuery();
            while (relatorio.next()) {
                Relatorio r = new Relatorio();

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
