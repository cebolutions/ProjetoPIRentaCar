package projetorentacar;

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
        try{
        dtNasc = dateFormat.parse(dataNasc);
        System.out.println(dateFormat.format(dtNasc));
        } catch (ParseException e) {
            e.printStackTrace();
        }        
        
        Cliente cliente = new Cliente(nome,rg,cpf,cnh,dtNasc,dtCadastro);
        cliente.cadastrarNovoCliente(cliente);
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
