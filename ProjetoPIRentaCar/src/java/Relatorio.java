/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/Relatorio"})
public class Relatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        LogSistema log = new LogSistema();
        //LOG visualizar relatorio
        log.cadastrarLog(15, user.getUsuarioId());
        RequestDispatcher rd;
        if (user.getCargo() == 1) {

            rd = request.getRequestDispatcher("relatorioGerente.jsp");
            rd.forward(request, response);
        } else if (user.getCargo() == 2) {
            rd = request.getRequestDispatcher("relatorioDiretor.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("relatorioErro.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        LogSistema log = new LogSistema();
        //LOG visualizar relatorio
        log.cadastrarLog(15, user.getUsuarioId());
        RequestDispatcher rd;
        if (user.getCargo() == 1) {
            rd = request.getRequestDispatcher("relatorioGerente.jsp");
            rd.forward(request, response);
        } else if (user.getCargo() == 2) {
            rd = request.getRequestDispatcher("relatorioDiretor.jsp");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("relatorioErro.jsp");
            rd.forward(request, response);
        }

    }
}
