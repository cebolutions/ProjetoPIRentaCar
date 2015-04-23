package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private int usuarioId;
    private String nome;
    private String rg;
    private String cpf;
    private String login;
    private String senha;
    private int cargo;
    private int filial;
    private boolean ativo;

    public Usuario(String nome, String rg, String cpf, String login, String senha, int cargo, int filial) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
        this.filial = filial;
        this.ativo = true;

    }

    public Usuario() {

    }

    public void cadastrarCliente() {
        Scanner in = new Scanner(System.in);
        System.out.println("CADASTRAR NOVO CLIENTE");
        System.out.println("Nome: ");
        String nome = in.nextLine().toUpperCase();
        System.out.println("RG: ");
        String rg = in.next();
        System.out.println("CPF: ");
        String cpf = in.next();
        System.out.println("CNH: ");
        String cnh = in.next();
        System.out.println("Data de Nasc.: ");
        String dataNasc = in.next();
        Date dtNasc = null;
        Date dtCadastro = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dtNasc = dateFormat.parse(dataNasc);
            System.out.println(dateFormat.format(dtNasc));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Cliente cliente = new Cliente(nome, rg, cpf, cnh, dtNasc, dtCadastro);
        cliente.cadastrarNovoCliente(cliente);
    }

    public void cadastrarVenda() {
        Scanner sc = new Scanner(System.in);
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        Veiculos veiculo = new Veiculos();
        Contrato contrato = new Contrato();

        System.out.println("Aguarde...");
        veiculo.verificarDisponibilidade();

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

    public void receberRelatorioFilial() {
        //if(getCargo().equalsIgnoreCase("atendente")){
        System.out.println("Acesso Restrito");
        //}
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getCargo() {
        return cargo;
    }

    public int getFilial() {
        return filial;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.cadastrarVenda();
    }

}
