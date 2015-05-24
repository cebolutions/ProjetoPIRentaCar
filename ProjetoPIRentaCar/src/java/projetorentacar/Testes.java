/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorentacar;

import Dao.ContratoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pc
 */
public class Testes {
    public static void main(String[] args) {
        //Usuario u = new Usuario("yypp", "123", "123", "yy", "yy", 0, 0);
        //u.cadastrarUsuarioBD(u);
        /*
        AcessoUsuario ac = new AcessoUsuario();
        LogSistema logSis = new LogSistema();
        
        Scanner in = new Scanner(System.in);
        System.out.print("Login: ");
        String log = in.next().toUpperCase();
        System.out.print("Senha: ");
        String pass = in.next().toUpperCase();
        boolean val = ac.validarUsuario(log, pass);
        if(val){
        logSis.setUsuarioId(ac.getUsuarioId());
        logSis.cadastrarLog(0);
        System.out.println(ac.getLogin());
        System.out.println(ac.getSenha());
        System.out.println(ac.getCargo());
        }
        
        ClienteDAO c = new ClienteDAO();
        //c.cadastrarCliente();
        String dtNasc = "01/01/1980";
        String dtCadastro = "19/04/2015";
        String idC = "0";
            int id = Integer.parseInt(idC);
        Date date = null;
        Date datec = null;
        try {
                SimpleDateFormat dfmt = new SimpleDateFormat("dd/mm/yyyy");
                date = dfmt.parse(dtNasc);
                datec = dfmt.parse(dtCadastro);
            } catch (Exception e) {
                e.printStackTrace();
            }
        Cliente cli = new Cliente(id,"a","11","33","11",date, datec);
        c.updateCliente(cli);
        
        List<Cliente> lista = c.buscarCliente();
        for(Cliente cl:lista){
            System.out.print(cl.getClienteId());
            System.out.print("");
            System.out.print(cl.getNome());
            System.out.print("");
            System.out.println(cl.getDataCadastro());
        }
        */
        /*
        Veiculos vdao = new Veiculos();
        int i = 0;
            List<Veiculos> lista = vdao.verificarDisponibilidadeByFilial(i);
        for(Veiculos cl:lista){
            System.out.print(cl.getNomeVeiculo());
            System.out.print(" ");
            System.out.print(cl.getMarca());
            System.out.print(" ");
            System.out.println(cl.getCategoria());
        }
                */
        
        
        //Contrato contrato = new Contrato(0, 0, 0, new Date(), new Date(), 1, 150.00, 0);
        ContratoDAO cdao = new ContratoDAO();
        //cdao.cadastrarContratoBD(contrato);
        
        String dtNasc = "2015-05-23";
        Date date = null;
        Date date2 = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            String ds2 = sdf2.format(sdf1.parse(dtNasc)); 
            System.out.println(ds2);
            date = new SimpleDateFormat("dd/MM/yyyy").parse(ds2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(date));
    }
                
}
