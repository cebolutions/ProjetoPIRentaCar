package projetorentacar;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Contrato {

    private int contratoId;
    private int clienteId;
    private int usuarioId;
    private int veiculoId;
    private Date dataRetirada;
    private Date dataDevolucao;
    private int quantidadeDiarias;
    private double saldoReserva;
    private int formaPagamentoId;
    private int filialId;
    public Contrato(){
    
    }
    public Contrato(int contratoId, int clienteId, int usuarioId,
            int veiculoId, Date dataRetirada, Date dataDevolucao, int quantidadeDiarias, int saldoReserva,
            int formaPagamentoId, int filialId) {

    }

    

    public void validarPagamento() {

    }

    public void getRetirada() {

    }

    public void setRetirada() {

    }

    public void getEntrega() {

    }

    public void setEntrega() {

    }
}
