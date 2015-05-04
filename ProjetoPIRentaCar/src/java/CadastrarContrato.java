/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDAO;
import Dao.ContratoDAO;
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
import projetorentacar.Contrato;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/CadastrarContrato"})
public class CadastrarContrato extends HttpServlet {


  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpfCliente = request.getParameter("cpf");
        ClienteDAO c = new ClienteDAO();
        Cliente cliente = c.buscarClienteByCpf(cpfCliente);
        String dtRetirada = request.getParameter("dtRetirada");
        String dtDevolucao = request.getParameter("dtDevolucao");
        String fil = request.getParameter("filial");
        String qtd = request.getParameter("diarias");
        String veic = request.getParameter("veiculo");
        String valor = request.getParameter("valor");
        int filial = Integer.parseInt(fil);
        int diarias = Integer.parseInt(qtd);
        int veiculoId = Integer.parseInt(veic);
        double valorReserva = Double.parseDouble(valor);
        
        VeiculoDAO v = new VeiculoDAO();

        Veiculos veiculo = v.verificarDisponibilidadeById(veiculoId);

        Date ret = null;
        Date dev = null;
        int usuarioId = 0;
        // precisa receber info do usuario logado
        try {
            SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
            ret = dfmt.parse(dtRetirada);
            dev = dfmt.parse(dtDevolucao);
        } catch (Exception e) {
            e.printStackTrace();
        }
            Contrato contrato = new Contrato(c.getClienteId(), usuarioId, veiculo.getIdVeiculo(), ret, dev, diarias, valorReserva, filial);
            ContratoDAO cdao = new ContratoDAO();
            cdao.cadastrarContratoBD(contrato);
            //executar cadastrar contrato

            request.setAttribute("contrato", contrato);
            request.setAttribute("cliente", cliente);
            request.setAttribute("veic", veiculo);
            request.getRequestDispatcher("ContratoAberto.jsp").forward(request, response);

    }
}
