package Servlets;

import Dao.ClienteDAO;
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
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

@WebServlet(urlPatterns = {"/AtualizarCliente"})
public class AtualizarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        if (request.getParameter("CPFClientePesquisa") != null) {

            String cpfBusca = request.getParameter("CPFClientePesquisa");
            ClienteDAO c = new ClienteDAO();
            Cliente cliente = c.buscarClienteByCpf(cpfBusca);
            LogSistema log = new LogSistema();
//LOG BUSCA DE CLIENTE
            log.cadastrarLog(8, user.getUsuarioId());

            if (cliente.getCpf() == null) {
                request.getRequestDispatcher("/atualizarClienteErro.jsp").forward(request, response);

            } else {
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("/atualizarCliente.jsp").forward(request, response);
            }
        } else {

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            String cnh = request.getParameter("cnh");
            String dtNasc = request.getParameter("dtNasc");
            String dtCadastro = request.getParameter("dtCadastro");
            Date date = null;
            Date dateCad = null;

            try {
                SimpleDateFormat dfmt = new SimpleDateFormat("dd/mm/yyyy");
                date = dfmt.parse(dtNasc);
                dateCad = dfmt.parse(dtCadastro);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ClienteDAO cl = new ClienteDAO();
            Cliente novoCliente = new Cliente(id, nome, rg, cpf, cnh, date, dateCad);
            cl.updateCliente(novoCliente);
            LogSistema log = new LogSistema();
//LOG ALTERAÇÃO DE CLIENTE
            log.cadastrarLog(7, user.getUsuarioId());
            Cliente clienteAtualizado = cl.buscarClienteByCpf(cpf);
            request.setAttribute("cliente", clienteAtualizado);
            request.getRequestDispatcher("/consultaCliente.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        String cpfBusca = request.getParameter("cpf");
        ClienteDAO c = new ClienteDAO();
        Cliente cliente = c.buscarClienteByCpf(cpfBusca);
        LogSistema log = new LogSistema();
//LOG BUSCA DE CLIENTE
        log.cadastrarLog(8, user.getUsuarioId());

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/atualizarCliente.jsp").forward(request, response);

    }
}
