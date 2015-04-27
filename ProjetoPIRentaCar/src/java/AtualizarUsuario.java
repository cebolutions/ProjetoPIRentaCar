/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/AtualizarUsuario"})
public class AtualizarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String cpf = request.getParameter("cpf");
            UsuarioDAO u = new UsuarioDAO();
            Usuario user = u.buscarUsuarioByCpf(cpf);
            request.setAttribute("usuario", user);
            
            request.getRequestDispatcher("/atualizarUsuario.jsp").forward(request, response);
            
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("CPFUsuario") != null) {
            String cpf = request.getParameter("CPFUsuario");
            UsuarioDAO u = new UsuarioDAO();
            Usuario user = u.buscarUsuarioByCpf(cpf);
            
            
            if (user.getCpf() == null) {
                request.getRequestDispatcher("/atualizarUsuarioErro.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/atualizarUsuario.jsp").forward(request, response);
            }
        } else {
            String i = request.getParameter("id");
            int id = Integer.parseInt(i);
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String c = request.getParameter("cargo");
            int cargo = Integer.parseInt(c);
            String f = request.getParameter("filial");
            int filial = Integer.parseInt(f);
            boolean ativo = true;
            if (request.getParameter("ativo").equalsIgnoreCase("TRUE")) {
                ativo = true;
            } else if (request.getParameter("ativo").equalsIgnoreCase("FALSE")) {
                ativo = false;
            }
            Usuario user = new Usuario(id, nome, rg, cpf, login, senha, cargo, filial, ativo);
            UsuarioDAO u = new UsuarioDAO();
            u.updateUsuarioBD(user);
            Usuario userBD = u.buscarUsuarioByCpf(cpf);
            request.setAttribute("usuario", userBD);
            RequestDispatcher rd = request.getRequestDispatcher("atualizarUsuarioSucesso.jsp");
            rd.forward(request, response);
            
        }

    }


}
