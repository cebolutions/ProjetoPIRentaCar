/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.RelatorioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Relatorio;

/**
 *
 * @author pc
 */
@WebServlet(name = "BuscarRelatorio", urlPatterns = {"/BuscarRelatorio"})
public class BuscarRelatorio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RelatorioDAO r = new RelatorioDAO();
        List<Relatorio> lista;
        Relatorio relatorio;
        switch (Integer.parseInt(request.getParameter("relatorio"))) {
            case 1:
                lista = r.qtdVeiculosPorUsuario();
                request.setAttribute("listaQtdVeiculo", lista);
                
                break;
            case 2:
                lista = r.veiculosPorUsuarios();
                request.setAttribute("listaVeiculosPorUsuario", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 3:
                relatorio = r.totalVendasDeUsuario(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("listaVeiculosPorUsuario", relatorio);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
        }
    }

}
