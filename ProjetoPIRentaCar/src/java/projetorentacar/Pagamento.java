package projetorentacar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc
 */
public class Pagamento {

    private int pagamentoId;
    private int contratoId;
    private int fopId;
    private double valorPago;

    public Pagamento(int contratoId, int fopId, double valorPago) {
        this.contratoId = contratoId;
        this.fopId = fopId;
        this.valorPago = valorPago;
    }

    public Pagamento() {

    }

    public int getPagamentoId() {
        return pagamentoId;
    }

    public int getContratoId() {
        return contratoId;
    }

    public int getFopId() {
        return fopId;
    }

    public double getValorPago() {
        return valorPago;
    }
}
