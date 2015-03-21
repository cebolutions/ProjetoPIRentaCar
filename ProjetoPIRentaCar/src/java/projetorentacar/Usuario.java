
package projetorentacar;

/**
 *
 * @author pc
 */
public class Usuario {
    private String nome;
    private String rg;
    private String cpf;
    private String login;
    private String senha;
    private String cargo;
    private String filial;
    
    public Usuario (String nome, String rg, String cpf, String login, String senha, String cargo, String filial){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
        this.filial = filial;
    }
    public void cadastrarCliente(){
        
    }
    public void cadastrarVenda(){
        
    }
    public void receberPagamento(){
        
    }
    public void receberRelatorioFilial(){
        if(cargo.equalsIgnoreCase("atendente")){
            System.out.println("Acesso Restrito");
        }
    }
}
