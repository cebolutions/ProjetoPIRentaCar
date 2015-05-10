/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ContratoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Contrato;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/FecharContrato"})
public class FecharContrato extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        ContratoDAO cdao = new ContratoDAO();
        Contrato contrato = cdao.buscarContrato(Integer.parseInt(request.getParameter("contrato")));
        cdao.fecharContrato(contrato);
        LogSistema log = new LogSistema();
//LOG fecha contrato
        log.cadastrarLog(11, user.getUsuarioId());
        request.getRequestDispatcher("ContratoFechado.jsp").forward(request, response);

    }

}
