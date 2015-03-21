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
        AcessoUsuario ac = new AcessoUsuario();
        Scanner in = new Scanner(System.in);
        System.out.print("Login: ");
        String log = in.next().toUpperCase();
        System.out.print("Senha: ");
        String pass = in.next().toUpperCase();
        boolean val = ac.validarUsuario(log, pass);
        if(val){
        System.out.println(ac.getUsuario());
        System.out.println(ac.getSenha());
        System.out.println(ac.getCargo());
        }
    }
}
