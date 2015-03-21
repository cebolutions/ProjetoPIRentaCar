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
public class Testes {
    public static void main(String[] args) {
        AcessoUsuario ac = new AcessoUsuario();
        ac.validarUsuario();
        System.out.println(ac.getUsuario());
        System.out.println(ac.getSenha());
        System.out.println(ac.getCargo());
    }
}
