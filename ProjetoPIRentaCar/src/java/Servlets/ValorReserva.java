package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.VeiculoDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/ValorReserva"})
public class ValorReserva extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String dtRetirada = request.getParameter("dtRetirada");
            String dtDevolucao = request.getParameter("dtDevolucao");
            String fil = request.getParameter("filial");
            String qtd = request.getParameter("diarias");
            String veic = request.getParameter("veiculo");
            int filial = Integer.parseInt(fil);
            int diarias = Integer.parseInt(qtd);
            int veiculoId = Integer.parseInt(veic);
            
            VeiculoDAO v = new VeiculoDAO();
            
            Veiculos veiculo = v.verificarDisponibilidadeById(veiculoId);
            double valorTotal = v.saldoReserva(diarias, veiculo.getValorCategoria());
                    
            Date ret = null;
            Date dev = null;
            
            
            
            try {
                SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
                ret = dfmt.parse(dtRetirada);
                dev = dfmt.parse(dtDevolucao);
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            request.setAttribute("ret", ret);
            request.setAttribute("dev", dev);
            request.setAttribute("filial", filial);
            request.setAttribute("diarias", diarias);
            request.setAttribute("veic", veiculo);
            request.setAttribute("valor", valorTotal);
            request.getRequestDispatcher("Contrato_3.jsp").forward(request, response);
    }

}
