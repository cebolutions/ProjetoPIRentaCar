package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

    

    public void cadastrarUsuario() {
        Scanner in = new Scanner(System.in);
        System.out.println("CADASTRAR NOVO CLIENTE");
        System.out.println("Nome: ");
        String nome = in.nextLine().toUpperCase();
        System.out.println("RG: ");
        String rg = in.next();
        System.out.println("CPF: ");
        String cpf = in.next();
        System.out.println("Login: ");
        String log = in.next();
        System.out.println("Senha: ");
        String pass = in.next();
        System.out.println("Cargo: ");
        int cargo = in.nextInt();
        System.out.println("Senha: ");
        int filial = in.nextInt();
        
        
        
        Usuario user = new Usuario(nome,rg,cpf,log,pass,cargo,filial);
        user.cadastrarUsuarioBD(user);
    }
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

    public void cadastrarVenda() {

    }

    public void receberPagamento() {

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
}
