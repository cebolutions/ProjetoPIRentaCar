package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Cliente(String nome, String rg, String cpf, String cnh, Date dataNascimento, Date dataCadastro) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }
    
    public void cadastrarNovoCliente(Cliente c) {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstmt = null;
        String cmdSQL = "INSERT INTO TB_CADASTRO_CLIENTE (NOME_CLIENTE, RG, CPF, CNH, DATA_NASCIMENTO, DATA_CADASTRO "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            conn = cnx.obterConexao();
            pstmt = conn.prepareStatement(cmdSQL);
            pstmt.setString(1, c.getNome());
            pstmt.setString(2, c.getRg());
            pstmt.setString(3, c.getCpf());
            pstmt.setString(4, c.getCnh());
            pstmt.setDate(5, (java.sql.Date) c.getDataNascimento());
            pstmt.setDate(6, (java.sql.Date) c.getDataCadastro());
            pstmt.executeQuery();
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
            String comandoSQL = "SELECT FROM TB_CADASTRO_CLIENTE";
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
                Cliente c = new Cliente(this.nome, this.rg, this.cpf, this.cnh, this.dataNascimento, this.dataCadastro);
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
