package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDAO;
import Dao.ContratoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Cliente;
import projetorentacar.Contrato;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/BuscarContratos"})
public class BuscarContratos extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        ContratoDAO c = new ContratoDAO();
        List<Contrato> lista = c.listarContratos();
        request.setAttribute("lista", lista);

        //LogSistema log = new LogSistema();
//LOG VIEW LISTA CLIENTES
       // log.cadastrarLog(9, user.getUsuarioId());

        request.getRequestDispatcher("listarContratos.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        ContratoDAO c = new ContratoDAO();
        List<Contrato> lista = c.listarContratos();
        request.setAttribute("lista", lista);

        //LogSistema log = new LogSistema();
//LOG VIEW LISTA CLIENTES
        //log.cadastrarLog(9, user.getUsuarioId());

        request.getRequestDispatcher("listarContratos.jsp").forward(request, response);
    }

}
