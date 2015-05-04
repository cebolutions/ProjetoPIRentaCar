package projetorentacar;

import java.util.Date;

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
    private int filialId;
    private boolean aberto;
    
    public Contrato(){
    
    }
    public Contrato(int clienteId, int usuarioId, int veiculoId, Date dataRetirada, Date dataDevolucao, 
            int quantidadeDiarias, double saldoReserva, int filialId) {
        this.clienteId = clienteId;
        this.usuarioId = usuarioId;
        this.veiculoId = veiculoId;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.quantidadeDiarias = quantidadeDiarias;
        this.saldoReserva = saldoReserva;
        this.filialId = filialId;
        this.aberto = true;
        
    }

    
public Contrato(int id, int clienteId, int usuarioId, int veiculoId, Date dataRetirada, Date dataDevolucao, 
            int quantidadeDiarias, double saldoReserva, int filialId, boolean ativo) {
        this.contratoId = id;
        this.clienteId = clienteId;
        this.usuarioId = usuarioId;
        this.veiculoId = veiculoId;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
        this.quantidadeDiarias = quantidadeDiarias;
        this.saldoReserva = saldoReserva;
        this.filialId = filialId;
        this.aberto = ativo;
        
    }
    public int getContratoId() {
        return contratoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public double getSaldoReserva() {
        return saldoReserva;
    }

    public int getFilialId() {
        return filialId;
    }

    public boolean isAberto() {
        return aberto;
    }
}
