package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import Dao.ClienteDAO;
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
        ClienteDAO c = new ClienteDAO();
        c.cadastrarClienteBD(cliente);
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

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
