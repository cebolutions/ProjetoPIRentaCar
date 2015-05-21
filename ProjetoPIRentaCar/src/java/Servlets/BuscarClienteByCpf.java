package Servlets;


import Dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Cliente;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

@WebServlet(urlPatterns = {"/BuscarClienteByCpf"})
public class BuscarClienteByCpf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        String cpf = request.getParameter("CPFClientePesquisa");
        ClienteDAO c = new ClienteDAO();
        Cliente cliente = c.buscarClienteByCpf(cpf);
        LogSistema log = new LogSistema();
//LOG BUSCA DE CLIENTE
        log.cadastrarLog(8, user.getUsuarioId());
        request.setAttribute("cliente", cliente);
        if (cliente.getCpf() == null) {
            request.setAttribute("erro", "*Cliente não encontrado");
            request.getRequestDispatcher("/consultaClienteErro.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/consultaCliente.jsp").forward(request, response);
        }

    }

}
