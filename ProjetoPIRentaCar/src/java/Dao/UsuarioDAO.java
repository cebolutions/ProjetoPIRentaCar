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
import java.util.Scanner;
import projetorentacar.Usuario;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
public class UsuarioDAO extends Usuario {
    
    public void cadastrarUsuarioBD(Usuario u) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "INSERT INTO TB_USUARIOS (NOME_USUARIO, RG, CPF, LOGIN, SENHA, ATIVO, CARGO_ID, FILIAL_ID) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, u.getNome());
            pstmt.setString(2, u.getRg());
            pstmt.setString(3, u.getCpf());
            pstmt.setString(4, u.getLogin());
            pstmt.setString(5, u.getSenha());
            pstmt.setBoolean(6, u.isAtivo());
            pstmt.setInt(7, u.getCargo());
            pstmt.setInt(8, u.getFilial());
            pstmt.execute();
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
    }
    public void updateUsuarioBD(Usuario u) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "UPDATE TB_USUARIOS SET NOME_USUARIO=?, RG=?, CPF=?, LOGIN=?, SENHA=?, ATIVO=?, CARGO_ID=?, FILIAL_ID=? WHERE ID_USUARIO = ?";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, u.getNome());
            pstmt.setString(2, u.getRg());
            pstmt.setString(3, u.getCpf());
            pstmt.setString(4, u.getLogin());
            pstmt.setString(5, u.getSenha());
            pstmt.setBoolean(6, u.isAtivo());
            pstmt.setInt(7, u.getCargo());
            pstmt.setInt(8, u.getFilial());
            pstmt.setInt(9, u.getUsuarioId());
            pstmt.execute();
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
    }
    public List buscarUsuarios() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Usuario> lUsers = new ArrayList<Usuario>();
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_USUARIOS";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet user = pstmt.executeQuery();
            while (user.next()) {
                Usuario u = new Usuario();
                u.setUsuarioId(user.getInt(1));
                u.setNome(user.getString(2));
                u.setRg(user.getString(3));
                u.setCpf(user.getString(4));
                u.setLogin(user.getString(5));
                u.setSenha(user.getString(6));
                u.setAtivo(user.getBoolean(7));
                u.setCargo(user.getInt(8));
                u.setFilial(user.getInt(9));
                lUsers.add(u);
            }

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
        return lUsers;
    }

    public Usuario buscarUsuarioByCpf(String cpf) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_USUARIOS WHERE CPF = '" + cpf + "'";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet user = pstmt.executeQuery();
            while (user.next()) {
                Usuario u = new Usuario();
                u.setUsuarioId(user.getInt(1));
                u.setNome(user.getString(2));
                u.setRg(user.getString(3));
                u.setCpf(user.getString(4));
                u.setLogin(user.getString(5));
                u.setSenha(user.getString(6));
                u.setAtivo(user.getBoolean(7));
                u.setCargo(user.getInt(8));
                u.setFilial(user.getInt(9));
                return u;
            }
            Usuario u = new Usuario();
            return u;

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
    public Usuario buscarLogin(String login) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_USUARIOS WHERE LOGIN = '" + login + "'";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet user = pstmt.executeQuery();
            while (user.next()) {
                Usuario u = new Usuario();
                u.setUsuarioId(user.getInt(1));
                u.setNome(user.getString(2));
                u.setRg(user.getString(3));
                u.setCpf(user.getString(4));
                u.setLogin(user.getString(5));
                u.setSenha(user.getString(6));
                u.setAtivo(user.getBoolean(7));
                u.setCargo(user.getInt(8));
                u.setFilial(user.getInt(9));
                return u;
            }
            Usuario u = new Usuario();
            return u;

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
    public void cadastrarVenda() {
        Scanner sc = new Scanner(System.in);
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        VeiculoDAO v = new VeiculoDAO();
        Veiculos veiculo = new Veiculos();
        ContratoDAO contrato = new ContratoDAO();

        System.out.println("Aguarde...");
        v.verificarDisponibilidade();

        System.out.println("Id do veículo: " + veiculo.getIdVeiculo());
        System.out.println("Quantidade: " + veiculo.getQuantidade());

        int id_cliente = 0;
        int id_func = 0;
        int cargo_id = 0;
        String nomeFuncionario = "";
        String cpfFuncionario = "";
        String nomeCliente = "";
        String cpfCliente = "";
        String cpfClienteBD = "";
        String cpfFuncBD = "";

        if (veiculo.getQuantidade() <= 0) {
            System.out.println("Não há veículos disponíveis!");
        } else {
            System.out.println("Informe o cpf do cliente que deseja encontrar");
            cpfCliente = sc.next();

            System.out.println("Usuário, digite seu cpf:");
            cpfFuncionario = sc.next();

            try {
                conn = cnx.obterConexao();
                String comandoSQL = "SELECT ID_CLIENTE, NOME_CLIENTE, CPF "
                        + " FROM TB_CADASTRO_CLIENTE "
                        + " WHERE CPF = '" + cpfCliente + "'";
                pstmt = conn.prepareStatement(comandoSQL);
                ResultSet cliente = pstmt.executeQuery();
                while (cliente.next()) {
                    id_cliente = cliente.getInt(1);
                    nomeCliente = cliente.getString(2);
                    cpfClienteBD = cliente.getString(3);
                }

                String cmdSQL = "SELECT ID_USUARIO, NOME_USUARIO, CPF, CARGO_ID "
                        + " FROM TB_USUARIOS "
                        + " WHERE CPF = '" + cpfFuncionario + "'";
                pstmt = conn.prepareStatement(cmdSQL);
                ResultSet usuario = pstmt.executeQuery();
                while (usuario.next()) {
                    id_func = usuario.getInt(1);
                    nomeFuncionario = usuario.getString(2);
                    cpfFuncBD = usuario.getString(3);
                    cargo_id = usuario.getInt(4);
                }

                contrato.cadastrarContrato();

                //FAZER UM JOIN PARA TRAZER A DESCRICAO DO CARGO??
                if (cpfClienteBD.equals(cpfCliente) && cpfFuncBD.equals(cpfFuncionario) && (cargo_id >= 0 || cargo_id <= 1)) {
                    System.out.println("O Cliente " + nomeCliente + " já é cadastrado na base de dados!");
                    System.out.println("O usuário " + nomeFuncionario + " pode realizar a venda!");

                    System.out.println("Verifiando a disponibilidade dos veículos...");

                    //contrato.cadastrarContrato();
                    String comandoInsertTabContratoSQL
                            = "INSERT INTO TB_CONTRATO (CLIENTE_ID, USUARIO_ID, VEICULO_ID, DATA_RETIRADA, DATA_DEVOLUCAO, "
                            + " QUANTIDADE_DIARIAS, SALDO_DA_RESERVA, FORMA_PAGAMENTO_ID, FILIAL_ID) "
                            + " VALUES (?,?,?,?,?,?,?,?,?)";

                    pstmt = conn.prepareStatement(comandoInsertTabContratoSQL);
                    pstmt.setInt(1, id_cliente);
                    pstmt.setInt(2, id_func);
                    pstmt.setInt(3, contrato.getVeiculoId());
                    pstmt.setDate(4, new java.sql.Date(contrato.getDataRetirada().getTime()));
                    pstmt.setDate(5, new java.sql.Date(contrato.getDataDevolucao().getTime()));
                    pstmt.setInt(6, contrato.getQuantidadeDiarias());
                    pstmt.setDouble(7, contrato.getSaldoReserva());
                    pstmt.setInt(8, contrato.getFormaPagamentoId());
                    pstmt.setInt(9, contrato.getFilialId());
                    pstmt.execute();

                    //Retira 1 veículo do estoque quando a venda é cadastrada
                    veiculo.retirarVeiculo(contrato.getVeiculoId(), contrato.getFilialId());

                } else {
                    System.out.println("O cliente não está cadastrado na nossa base de dados!");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    conn.close();
                    pstmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
     public void receberPagamento() {
        //Precisa terminar
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;

        //VARIÁVEIS TESTE
        int id_contrato;
        Date data_retirada;
        double saldo_reserva;

        String comandoSQL = "SELECT ID_CONTRATO, DATA_RETIRADA, SALDO_DA_RESERVA "
                + " FROM TB_CONTRATO";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet recebePagamento = pstmt.executeQuery();
            while (recebePagamento.next()) {
                id_contrato = recebePagamento.getInt(1);
                data_retirada = recebePagamento.getDate(2);
                saldo_reserva = recebePagamento.getInt(3);
            }

            //Verificando, se a data de retirada está preenchida e se o saldo for == 0, blz
            //senão, se a data de retirada estiver preenchida o cliente tem que fazer o depósito do saldo,
            //não necessáriamente é preciso fazer o depósito na retirada.
            /*
             if() {
                
             } else {
             }
             */
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }
}
