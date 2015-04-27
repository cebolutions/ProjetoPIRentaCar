/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/InserirUsuario"})
public class InserirUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String c = request.getParameter("cargo");
        int cargo = Integer.parseInt(c);
        String f = request.getParameter("filial");
        int filial = Integer.parseInt(f);
        
        
        Usuario User = new Usuario(nome, rg, cpf, login, senha, cargo, filial);
        UsuarioDAO u = new UsuarioDAO();
        u.cadastrarUsuarioBD(User);
        RequestDispatcher rd = request.getRequestDispatcher("cadastroSucesso.jsp");
        rd.forward(request, response);
    }

}
