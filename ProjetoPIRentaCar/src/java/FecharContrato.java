/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ContratoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Contrato;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/FecharContrato"})
public class FecharContrato extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContratoDAO cdao = new ContratoDAO();
        Contrato contrato = cdao.buscarContrato(Integer.parseInt(request.getParameter("contrato")));
        cdao.fecharContrato(contrato);
    }

}
