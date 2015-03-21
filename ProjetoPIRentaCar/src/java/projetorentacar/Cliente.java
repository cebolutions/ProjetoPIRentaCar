
package projetorentacar;

import java.util.Date;

/**
 *
 * @author pc
 */
public class Cliente {
    private String nome;
    private String rg;
    private String cpf;
    private String cnh;
    private Date dataNascimento;
    private Date dataCadastro;
    
    public void cadastrarNovoCliente(String nome, String rg, String cpf, String cnh, Date dataNascimento, Date dataCadastro){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cnh = cnh;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
    }
    public void buscarCliente(){
        
    }
}
