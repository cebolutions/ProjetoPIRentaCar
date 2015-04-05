/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetorentacar;

import java.util.Scanner;

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
        */
        Cliente c = new Cliente();
        c.cadastrarCliente();
    }
}
