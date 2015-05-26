package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

@WebServlet(urlPatterns = {"/AcessoRelatorios"})
public class AcessoRelatorios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("relatorioGerente.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        LogSistema log = new LogSistema();
        //LOG visualizar relatorio
        log.cadastrarLog(17, user.getUsuarioId());
        RequestDispatcher rd;
        if (user.getCargo() == 1) {

            rd = request.getRequestDispatcher("relatoriosGerente.jsp");
            rd.forward(request, response);
        } else if (user.getCargo() == 2) {
            rd = request.getRequestDispatcher("relatoriosDiretor.jsp");
            rd.forward(request, response);
        }
    }
}
