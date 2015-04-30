/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.ConexaoBDJavaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import projetorentacar.Contrato;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
public class ContratoDAO {
    public void cadastrarContrato() {
        Scanner in = new Scanner(System.in);
        List<Veiculos> veiculos = new ArrayList<>();
        List fop = new ArrayList<>();
        VeiculoDAO v = new VeiculoDAO();
        Veiculos veic = new Veiculos();
        veiculos = v.verificarDisponibilidade();
        System.out.println("VEICULOS");
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(veiculos.get(i).getIdVeiculo() + " | "
                    + veiculos.get(i).getNomeVeiculo() + " | "
                    + veiculos.get(i).getCor() + " | "
                    + veiculos.get(i).getMarca());
        }
        //passar esses dados por parametro
        System.out.print("Escolha o veículo: ");
        this.veiculoId = in.nextInt();

        System.out.print("Informe a data de retirada: ");
        String dtRet = in.next();
        System.out.print("Informe a data de devolução: ");
        String dtDev = in.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataRetirada = dateFormat.parse(dtRet);
            this.dataDevolucao = dateFormat.parse(dtDev);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Quantidade de diárias: ");
        this.quantidadeDiarias = in.nextInt();

        this.saldoReserva = veic.saldoReserva(this.getQuantidadeDiarias());

        System.out.println("FORMAS DE PAGAMENTOS");
        verificarFormaPagto();
        this.formaPagamentoId = in.nextInt();

        System.out.println("ESCOLHA A FILIAL");
        verificarFiliais();
        this.filialId = in.nextInt();

        System.out.println("s " + getSaldoReserva());
    }
    
    
    public void verificarFormaPagto() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        String cmdSQLFop = "SELECT * FROM TB_FORMA_DE_PAGAMENTOS";
        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(cmdSQLFop);
            res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String f = res.getString(2);
                System.out.println(i + " | " + f);
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void verificarFiliais() {
        ConexaoBDJavaDB cnx = new ConexaoBDJavaDB(("RentaCar"));
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet filiais = null;

        String comandoSQL = "SELECT * FROM TB_FILIAIS";
        String descricao_filiais;
        int id_formaPagamento;

        try {
            conn = cnx.obterConexao();
            pstm = conn.prepareStatement(comandoSQL);
            filiais = pstm.executeQuery();
            while (filiais.next()) {
                id_formaPagamento = filiais.getInt(1);
                descricao_filiais = filiais.getString(2);
                System.out.println(id_formaPagamento + " | " + descricao_filiais);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                pstm.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public List<Contrato> buscarContratos(){
        
        return;
    }
}
