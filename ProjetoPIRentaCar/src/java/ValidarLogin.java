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
import javax.servlet.http.HttpSession;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

/**
 * SERVLET PARA VALIDAR USUARIO SE ESTA CADASTRADO E ATIVO NO BD E ENVIAR PARA HOME.JSP
 * 
 */
@WebServlet(urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String pass = request.getParameter("senha");

        UsuarioDAO u = new UsuarioDAO();
        Usuario user = u.buscarLogin(login);
        System.out.println(user.getLogin());
        if (user.getLogin() != null) {
            if (user.isAtivo()) {
                if (user.validarLogin(login, pass, user)) {
                    LogSistema log = new LogSistema();
                    log.cadastrarLog(0, user.getUsuarioId());
                    session.setAttribute("user", user);
                    RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("erro", "Login e/ou Senha esta(ão) incorreto(s). Tente novamente!");
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            } else {
                request.setAttribute("erro", "Usuário Inativo!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

        } else {
            request.setAttribute("erro", "Usuário Inexistente!");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}
