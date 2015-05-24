package Servlets;

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
import javax.servlet.http.HttpSession;
import projetorentacar.Cliente;
import projetorentacar.Contrato;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;
import projetorentacar.Veiculos;

/**
 * RECEBE OS DADOS PARA CADASTRAR CONTRATO NO BD E ENVIA PARA CONTRATOABERTO.JSP
 */
@WebServlet(urlPatterns = {"/CadastrarContrato"})
public class CadastrarContrato extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpfCliente = request.getParameter("cpf");
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

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
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy");
            String dtR = dfmt.format(sdf1.parse(dtRetirada)); 
            String dtD = dfmt.format(sdf1.parse(dtDevolucao)); 
            ret = dfmt.parse(dtR);
            dev = dfmt.parse(dtD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Contrato contrato = new Contrato(c.getClienteId(), user.getUsuarioId(), veiculo.getIdVeiculo(), ret, dev, diarias, valorReserva, valorReserva, filial);
        ContratoDAO cdao = new ContratoDAO();
        cdao.cadastrarContratoBD(contrato);
        
        Contrato contratoGerado = cdao.buscarUltimoContratoByUser(user.getUsuarioId());
        v.retirarVeiculo(contratoGerado.getVeiculoId(), contratoGerado.getFilialId());
        LogSistema log = new LogSistema();
        //LOG cadastra contrato
        log.cadastrarLog(10, user.getUsuarioId());

        request.setAttribute("contrato", contratoGerado);
        request.setAttribute("cliente", cliente);
        request.setAttribute("veiculo", veiculo);
        request.getRequestDispatcher("ContratoAberto.jsp").forward(request, response);

    }
}
