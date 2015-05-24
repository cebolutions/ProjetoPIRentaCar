package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Dao.VeiculoDAO;
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
import javax.servlet.http.HttpSession;
import projetorentacar.Veiculos;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/Disponibilidade"})
public class Disponibilidade extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        
        String dtRetirada = request.getParameter("dtRetirada");
        String dtDevolucao = request.getParameter("dtDevolucao");
        String veicEscolhido = request.getParameter("filial");
        System.out.println(veicEscolhido);
        int filial = Integer.parseInt(veicEscolhido);
        Date ret = null;
        Date dev = null;
        String dtR = null;
        String dtD = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
            dtR = dfmt.format(sdf1.parse(dtRetirada));
            dtD = dfmt.format(sdf1.parse(dtDevolucao));
            ret = dfmt.parse(dtR);
            dev = dfmt.parse(dtD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime start = formatter.parseDateTime(dtR);
        //http://johannburkard.de/blog/programming/java/date-time-parsing-formatting-joda-time.html
        DateTime end = formatter.parseDateTime(dtD);
        int dias = Days.daysBetween(start, end).getDays();
        VeiculoDAO vdao = new VeiculoDAO();
        List<Veiculos> listaVeic = vdao.verificarDisponibilidadeByFilial(filial);
        if(ret.after(dev)){
            request.setAttribute("erroDt", true);
            request.getRequestDispatcher("Contrato_1.jsp").forward(request, response);
        }

        request.setAttribute("ret", ret);
        request.setAttribute("dev", dev);
        request.setAttribute("filial", filial);
        request.setAttribute("diarias", dias);

        if (listaVeic.isEmpty()) {
            request.setAttribute("erro", true);
            request.getRequestDispatcher("Contrato_1.jsp").forward(request, response);
        } else {
            request.setAttribute("veic", listaVeic);
        }
        request.getRequestDispatcher("Contrato_2.jsp").forward(request, response);
    }

}
