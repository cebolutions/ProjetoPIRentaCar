/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorentacar;

/**
 *
 * @author pc
 */
public class TestUsuario {
    private String nome;
    protected String sobrenome;
    protected String cpf;
    protected String endereco;
    
    public TestUsuario() {
        
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobreNome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobreNome the sobreNome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the CPF
     */
    public String getcpf() {
        return cpf;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }
}


