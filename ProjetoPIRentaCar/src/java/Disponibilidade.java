/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.joda.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Veiculos;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/Disponibilidade"})
public class Disponibilidade extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dtRetirada = request.getParameter("dtRetirada");
        String dtDevolucao = request.getParameter("dtDevolucao");
        String veicEscolhido = request.getParameter("filial");
        System.out.println(veicEscolhido);
        int filial = Integer.parseInt(veicEscolhido);
        Date ret = null;
        Date dev = null;
        try {
            SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
            ret = dfmt.parse(dtRetirada);
            dev = dfmt.parse(dtDevolucao);

        } catch (Exception e) {
            e.printStackTrace();
        }

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss Z");
        DateTime start = formatter.parseDateTime(dtRetirada);
        //http://johannburkard.de/blog/programming/java/date-time-parsing-formatting-joda-time.html
        DateTime end = formatter.parseDateTime(dtDevolucao);
        int dias = Days.daysBetween(start, end).getDays();
        Veiculos vdao = new Veiculos();
        List<Veiculos> listaVeic = vdao.verificarDisponibilidadeByFilial(filial);

        request.setAttribute("ret", ret);
        request.setAttribute("dev", dev);
        request.setAttribute("filialId", filial);
        request.setAttribute("diarias", dias);

        if (listaVeic.isEmpty()) {
            request.setAttribute("veicSemDisp", "Sem disponibilidade");
        } else {
            request.setAttribute("veic", listaVeic);
        }
        request.getRequestDispatcher("Contrato_2.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
