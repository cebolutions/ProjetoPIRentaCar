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
import projetorentacar.Usuario;
import projetorentacar.Veiculos;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/BuscarContratoPagamento"})
public class BuscarContratoPagamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        if (request.getParameter("contrato").equals("")) {
            request.setAttribute("erro", true);
            request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
        } else {
            ContratoDAO cdao = new ContratoDAO();
            Contrato contrato = cdao.buscarContrato(Integer.parseInt(request.getParameter("contrato")));
            if (contrato == null) {
                request.setAttribute("erro", true);
                request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
            } else {
                ClienteDAO cldao = new ClienteDAO();
                Cliente cliente = cldao.buscarClienteById(contrato.getClienteId());
                VeiculoDAO vdao = new VeiculoDAO();
                Veiculos veiculo = vdao.verificarDisponibilidadeById(contrato.getVeiculoId());
                PagamentoDAO pdao = new PagamentoDAO();
                double recebido = pdao.totalRecebidoByContrato(contrato.getContratoId());
                double saldoReserva = contrato.getSaldoReserva() - recebido;
                LogSistema log = new LogSistema();
                //LOG BUSCA CONTRATO
                log.cadastrarLog(12, user.getUsuarioId());

                if (saldoReserva <= 0 && contrato.isAberto()) {
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("contrato", contrato);
                    request.setAttribute("veiculo", veiculo);
                    request.setAttribute("pgtoRecebido", recebido);
                    request.setAttribute("saldo", saldoReserva);
                    request.getRequestDispatcher("FecharContrato.jsp").forward(request, response);
                } else if (saldoReserva > 0 && contrato.isAberto()) {
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("contrato", contrato);
                    request.setAttribute("veiculo", veiculo);
                    request.setAttribute("pgtoRecebido", recebido);
                    request.setAttribute("saldo", saldoReserva);
                    request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
                } else if (!contrato.isAberto()) {
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("contrato", contrato);
                    request.setAttribute("veiculo", veiculo);
                    request.setAttribute("pgtoRecebido", recebido);
                    request.setAttribute("saldo", saldoReserva);
                    request.getRequestDispatcher("ConsultaContrato.jsp").forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        ContratoDAO cdao = new ContratoDAO();
        Contrato contrato = cdao.buscarContrato(Integer.parseInt(request.getParameter("contrato")));

        ClienteDAO cldao = new ClienteDAO();
        Cliente cliente = cldao.buscarClienteById(contrato.getClienteId());
        VeiculoDAO vdao = new VeiculoDAO();
        Veiculos veiculo = vdao.verificarDisponibilidadeById(contrato.getVeiculoId());
        PagamentoDAO pdao = new PagamentoDAO();
        double recebido = pdao.totalRecebidoByContrato(contrato.getContratoId());
        double saldoReserva = contrato.getSaldoReserva() - recebido;
        LogSistema log = new LogSistema();
        //LOG BUSCA CONTRATO
        log.cadastrarLog(12, user.getUsuarioId());

        if (saldoReserva <= 0 && contrato.isAberto()) {
            request.setAttribute("cliente", cliente);
            request.setAttribute("contrato", contrato);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("pgtoRecebido", recebido);
            request.setAttribute("saldo", saldoReserva);
            request.getRequestDispatcher("FecharContrato.jsp").forward(request, response);
        } else if (saldoReserva > 0 && contrato.isAberto()) {
            request.setAttribute("cliente", cliente);
            request.setAttribute("contrato", contrato);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("pgtoRecebido", recebido);
            request.setAttribute("saldo", saldoReserva);
            request.getRequestDispatcher("Pagamento.jsp").forward(request, response);
        } else if (!contrato.isAberto()) {
            request.setAttribute("cliente", cliente);
            request.setAttribute("contrato", contrato);
            request.setAttribute("veiculo", veiculo);
            request.setAttribute("pgtoRecebido", recebido);
            request.setAttribute("saldo", saldoReserva);
            request.getRequestDispatcher("ConsultaContrato.jsp").forward(request, response);
        }
    }

}
