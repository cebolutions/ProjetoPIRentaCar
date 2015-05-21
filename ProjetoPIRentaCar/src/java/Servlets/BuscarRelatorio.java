/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.RelatorioDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.LogSistema;
import projetorentacar.Relatorio;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(name = "BuscarRelatorio", urlPatterns = {"/BuscarRelatorio"})
public class BuscarRelatorio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        RelatorioDAO r = new RelatorioDAO();
        List<Relatorio> lista;
        Relatorio relatorio;
        String dtInicial;
        String dtFinal;
        Date inicio = null;
        Date fim = null;
        LogSistema log = new LogSistema();
//LOG VIEW relatorio
        log.cadastrarLog(15, user.getUsuarioId());
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
                int id = Integer.parseInt(request.getParameter("usuarioId"));
                relatorio = r.totalVendasDeUsuarioPorFilial(id, user.getFilial());
                request.setAttribute("rel", 3);
                request.setAttribute("relatorio", relatorio);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 4:
                dtInicial = request.getParameter("perInicial");
                dtFinal = request.getParameter("perFinal");

                try {
                    SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
                    inicio = dfmt.parse(dtInicial);
                    fim = dfmt.parse(dtFinal);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                lista = r.totalVendasPorUsuariosPorPeriodoEFilial(inicio, fim, user.getFilial());
                request.setAttribute("rel", 4);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 5:
                dtInicial = request.getParameter("perInicial2");
                dtFinal = request.getParameter("perFinal2");

                try {
                    SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
                    inicio = dfmt.parse(dtInicial);
                    fim = dfmt.parse(dtFinal);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                lista = r.vendasPorUsuarioPorPeriodo(inicio, fim, Integer.parseInt(request.getParameter("usuarioId2")));
                request.setAttribute("rel", 5);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);
                break;
            case 6:
                lista = r.veiculosPorFilial();
                request.setAttribute("rel", 6);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosDiretor.jsp").forward(request, response);
                break;
            case 7:
                lista = r.totalVendasFiliais();
                request.setAttribute("rel", 7);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosDiretor.jsp").forward(request, response);
                break;
            case 8:
                lista = r.historicoLog();
                request.setAttribute("rel", 8);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosDiretor.jsp").forward(request, response);
                break;
            case 9:
                lista = r.historicoLog();
                request.setAttribute("rel", 9);
                request.setAttribute("relatorio", lista);
                request.getRequestDispatcher("visaoRelatoriosGerente.jsp").forward(request, response);

                break;
            case 10:

                break;
        }
    }

}
