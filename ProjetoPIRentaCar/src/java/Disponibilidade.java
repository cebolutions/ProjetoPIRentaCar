/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/Disponibilidade"})
public class Disponibilidade extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            Veiculos vdao = new Veiculos();
            List<Veiculos> listaVeic = vdao.verificarDisponibilidade();
            
            request.setAttribute("ret", ret);
            request.setAttribute("dev", dev);
            request.setAttribute("filial", filial);
            request.setAttribute("veic", listaVeic);
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
