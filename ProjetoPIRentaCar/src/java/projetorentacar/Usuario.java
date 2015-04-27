package projetorentacar;

import Dao.UsuarioDAO;
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

    public Usuario(){
        
    }
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
    public Usuario(int id, String nome, String rg, String cpf, String login, String senha, int cargo, int filial, boolean ativo) {
        this.usuarioId = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
        this.filial = filial;
        this.ativo = ativo;

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
        UsuarioDAO udao = new UsuarioDAO();
        udao.cadastrarUsuarioBD(user);
    }
     

    public boolean validarLogin(String login, String pass, Usuario u) {
        if (u.getLogin().equalsIgnoreCase(login) && u.getSenha().equalsIgnoreCase(pass)) {
            return true;
        } else {
            return false;
        }
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
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
