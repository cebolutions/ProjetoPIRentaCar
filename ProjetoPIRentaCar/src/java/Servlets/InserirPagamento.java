package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ClienteDAO;
import Dao.ContratoDAO;
import Dao.PagamentoDAO;
import Dao.VeiculoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Cliente;
import projetorentacar.Contrato;
import projetorentacar.LogSistema;
import projetorentacar.Pagamento;
import projetorentacar.Usuario;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/InserirPagamento"})
public class InserirPagamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        Double vlRecebido = Double.parseDouble(request.getParameter("vlPago"));
        ContratoDAO cdao = new ContratoDAO();
        Contrato contrato = cdao.buscarContrato(Integer.parseInt(request.getParameter("contrato")));
        Pagamento pgto = new Pagamento(Integer.parseInt(request.getParameter("contrato")), Integer.parseInt(request.getParameter("fop")), Double.parseDouble(request.getParameter("vlPago")));

        ClienteDAO cldao = new ClienteDAO();
        Cliente cliente = cldao.buscarClienteById(contrato.getClienteId());
        VeiculoDAO vdao = new VeiculoDAO();
        Veiculos veiculo = vdao.verificarDisponibilidadeById(contrato.getVeiculoId());
        PagamentoDAO pdao = new PagamentoDAO();
        double recebido = pdao.totalRecebidoByContrato(contrato.getContratoId());
        double saldoReserva = contrato.getSaldoReserva() - recebido;
        if (saldoReserva < vlRecebido) {
            request.setAttribute("cliente", cliente);
            request.setAttribute("contrato", contrato);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("pgtoRecebido", recebido);
            request.setAttribute("saldo", saldoReserva);
            request.setAttribute("erro", "*Valor informado maior que o saldo da reserva!");
            request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
        } else if (saldoReserva == 0 && contrato.isAberto()) {
            request.setAttribute("cliente", cliente);
            request.setAttribute("contrato", contrato);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("pgtoRecebido", recebido);
            request.setAttribute("saldo", saldoReserva);
            LogSistema log = new LogSistema();
            log.cadastrarLog(11, user.getUsuarioId());
            log.cadastrarLog(14, user.getUsuarioId());
            request.getRequestDispatcher("FecharContrato.jsp").forward(request, response);

        } else if (!contrato.isAberto()) {
            request.setAttribute("cliente", cliente);
            request.setAttribute("contrato", contrato);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("pgtoRecebido", recebido);
            request.setAttribute("saldo", saldoReserva);
            request.getRequestDispatcher("ContratoFechado.jsp").forward(request, response);
        } else {
            pdao.cadastrarPagamentoBD(pgto);
            LogSistema log = new LogSistema();

            recebido = pdao.totalRecebidoByContrato(contrato.getContratoId());
            saldoReserva = contrato.getSaldoReserva() - recebido;

            if (saldoReserva <= 0) {
                request.setAttribute("cliente", cliente);
                request.setAttribute("contrato", contrato);
                request.setAttribute("veiculo", veiculo);
                request.setAttribute("pgtoRecebido", recebido);
                request.setAttribute("saldo", saldoReserva);
                
                log.cadastrarLog(11, user.getUsuarioId());
                log.cadastrarLog(14, user.getUsuarioId());
                request.getRequestDispatcher("FecharContrato.jsp").forward(request, response);
            } else {
                request.setAttribute("cliente", cliente);
                request.setAttribute("contrato", contrato);
                request.setAttribute("veiculo", veiculo);
                request.setAttribute("pgtoRecebido", recebido);
                request.setAttribute("saldo", saldoReserva);
                request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
            }
        }
    }

}
