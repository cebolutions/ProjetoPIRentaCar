/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/BuscarUsuarios"})
public class BuscarUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        UsuarioDAO u = new UsuarioDAO();
        List<Usuario> lUsers = u.buscarUsuarios();
        request.setAttribute("lista", lUsers);
        LogSistema log = new LogSistema();
//LOG VIEW LISTA USUARIO
        log.cadastrarLog(5, user.getUsuarioId());
        RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        UsuarioDAO u = new UsuarioDAO();
        List<Usuario> lUsers = u.buscarUsuarios();
        request.setAttribute("lista", lUsers);
        LogSistema log = new LogSistema();
//LOG VIEW LISTA USUARIO
        log.cadastrarLog(5, user.getUsuarioId());
        RequestDispatcher rd = request.getRequestDispatcher("listarUsuarios.jsp");
        rd.forward(request, response);
    }

}
