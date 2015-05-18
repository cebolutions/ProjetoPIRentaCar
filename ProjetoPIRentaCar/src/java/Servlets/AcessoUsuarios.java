/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(name = "AcessoUsuarios", urlPatterns = {"/AcessoUsuarios"})
public class AcessoUsuarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        System.out.println(user.getCargo());
        LogSistema log = new LogSistema();
        //LOG visualizar relatorio
        log.cadastrarLog(15, user.getUsuarioId());
        RequestDispatcher rd;
        if (user.getCargo() == 0) {
            request.setAttribute("erro", "Você não possui acesso a esta funcionalidade");
            rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("usuarios.jsp");
            rd.forward(request, response);
        }
    }
}
