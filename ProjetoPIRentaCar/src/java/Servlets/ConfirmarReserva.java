package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDAO;
import Dao.VeiculoDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Cliente;
import projetorentacar.Veiculos;

/**
 *RECEBE CPF E BUSCA CLIENTE PARA MANDAR PARA CONTRATO_4.JSP
 */
@WebServlet(urlPatterns = {"/ConfirmarReserva"})
public class ConfirmarReserva extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String cpfCliente = request.getParameter("CPFClientePesquisa");
            ClienteDAO c = new ClienteDAO();
            Cliente cliente = c.buscarClienteByCpf(cpfCliente);
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
    
            
        if (cliente.getCpf() != null) {
            
            
            request.setAttribute("cliente", cliente);
            request.setAttribute("ret", ret);
            request.setAttribute("dev", dev);
            request.setAttribute("filial", filial);
            request.setAttribute("diarias", diarias);
            request.setAttribute("veic", veiculo);
            request.setAttribute("valor", valorTotal);
            request.getRequestDispatcher("Contrato_4.jsp").forward(request, response);

        } else {
            request.setAttribute("erro", true);
            request.setAttribute("ret", ret);
            request.setAttribute("dev", dev);
            request.setAttribute("filial", filial);
            request.setAttribute("diarias", diarias);
            request.setAttribute("veic", veiculo);
            request.setAttribute("valor", valorTotal);
            request.getRequestDispatcher("Contrato_3.jsp").forward(request, response);
        }
    }
}
