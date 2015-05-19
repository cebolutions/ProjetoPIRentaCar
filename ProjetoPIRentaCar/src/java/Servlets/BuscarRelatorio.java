/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.RelatorioDAO;
import Dao.VeiculoDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Relatorio;
import projetorentacar.Veiculos;

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
                request.setAttribute("rel", 1);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 2:
                lista = r.veiculosPorUsuarios();
                request.setAttribute("rel", 2);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 3:
                int id = Integer.parseInt(request.getParameter("id"));
                relatorio = r.totalVendasDeUsuario(id);
                request.setAttribute("rel", 3);
                request.setAttribute("relatorio", relatorio);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 4:
                String dtInicial = request.getParameter("perInicial");
                String dtFinal = request.getParameter("perFinal");
                Date inicio = null;
                Date fim = null;
                try {
                    SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
                    inicio = dfmt.parse(dtInicial);
                    fim = dfmt.parse(dtFinal);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                lista = r.totalVendasPorUsuariosPorPeriodo(inicio, fim);
                request.setAttribute("rel", 4);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
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
