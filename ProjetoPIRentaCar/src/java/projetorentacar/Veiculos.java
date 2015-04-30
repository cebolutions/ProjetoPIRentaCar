package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class Veiculos {

    private int idVeiculo;
    private String cor;
    private String marca;
    private String categoria;
    private String nomeVeiculo;
    private String renavam;
    private String placa;
    private int quantidade;
    private double valorCategoria;
    
    public Veiculos() {

    }

    public Veiculos(int idVeiculo, String nomeVeiculo, String placa,
            String cor, String marca, String categoria, int quantidade) {
        this.idVeiculo = idVeiculo;
        this.nomeVeiculo = nomeVeiculo;
        this.placa = placa;
        this.cor = cor;
        this.marca = marca;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public Veiculos(int idVeiculo, String nomeVeiculo, String marca, String categoria, int quantidade) {
        this.idVeiculo = idVeiculo;
        this.nomeVeiculo = nomeVeiculo;
        this.marca = marca;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public String getRenavam() {
        return renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(double valorCategoria) {
        this.valorCategoria = valorCategoria;
    }
}
