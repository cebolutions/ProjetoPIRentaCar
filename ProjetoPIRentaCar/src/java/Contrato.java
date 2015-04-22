/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Cliente;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/Contrato"})
public class Contrato extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("CPFClientePesquisa") != null && request.getParameter("veicEscolhido")==null) {
            String cpfCliente = request.getParameter("CPFClientePesquisa");
            ClienteDAO c = new ClienteDAO();
            Cliente cliente = c.buscarClienteByCpf(cpfCliente);
            
            request.setAttribute("cliente", cliente);
            
            //preencher lista de veiculos com select 
            request.getRequestDispatcher("Contrato.jsp").forward(request, response);

        } else if (request.getParameter("CPFClientePesquisa") != null && request.getParameter("veicEscolhido")!=null) {
            String cpfCliente = request.getParameter("CPFClientePesquisa");
            String veicEscolhido = request.getParameter("");
            
            Veiculos vdao = new Veiculos();
            List<Veiculos> listaVeic = vdao.verificarDisponibilidade();
            
            request.setAttribute("veic", listaVeic);
            
           // Contrato c = new Contrato();

            //request.setAttribute("contrato", contrato);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/contratoAberto.jsp");
            // * * * usar essa mesma ideia para cliente inserido

            //*** mostrar o cliente com os dados e a observação que foi inserido com sucesso e opção voltar.
        }
    }
}
