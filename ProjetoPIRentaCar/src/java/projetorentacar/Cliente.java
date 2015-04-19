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

/**
 *
 * @author pc
 */
public class Cliente {

    private int clienteId;
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private Date dataNascimento;
    private Date dataCadastro;
    
    public Cliente() {
        
    }
    public Cliente(String nome, String rg, String cpf, String cnh, Date dataNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = new Date();
    }
    public Cliente(int clienteId, String nome, String rg, String cpf, String cnh, Date dataNascimento, Date dtCadastro) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dtCadastro;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dtNasc = dateFormat.parse(dataNasc);
            System.out.println(dateFormat.format(dtNasc));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Cliente cliente = new Cliente(nome, rg, cpf, cnh, dtNasc);
        cliente.cadastrarClienteBD(cliente);
    }

    public void cadastrarClienteBD(Cliente c) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "INSERT INTO TB_CADASTRO_CLIENTE (NOME_CLIENTE, RG, CPF, CNH, DATA_NASCIMENTO, DATA_CADASTRO) "
                + "VALUES (?,?,?,?,?,?)";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getRg());
            pstmt.setString(3, c.getCpf());
            pstmt.setString(4, c.getCnh());
            pstmt.setDate(5, new java.sql.Date(c.getDataNascimento().getTime()));
            pstmt.setDate(6, new java.sql.Date(c.getDataCadastro().getTime()));
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

    public List buscarCliente() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB("RentaCar");
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Cliente> lClientes = new ArrayList<Cliente>();
        try {
            conn = cnx.obterConexao();
            String comandoSQL = "SELECT * FROM TB_CADASTRO_CLIENTE";
            pstmt = conn.prepareStatement(comandoSQL);
            ResultSet cliente = pstmt.executeQuery();
            while (cliente.next()) {
                this.clienteId = cliente.getInt(1);
                this.nome = cliente.getString(2);
                this.rg = cliente.getString(3);
                this.cpf = cliente.getString(4);
                this.cnh = cliente.getString(5);
                this.dataNascimento = cliente.getDate(6);
                this.dataCadastro = cliente.getDate(7);
                Cliente c = new Cliente(this.clienteId, this.nome, this.rg, this.cpf, this.cnh, this.dataNascimento, this.dataCadastro);
                lClientes.add(c);
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
        return lClientes;
    }

    public int getClienteId() {
        return clienteId;
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

    public String getCnh() {
        return cnh;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
}
