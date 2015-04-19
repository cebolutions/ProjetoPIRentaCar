

import Dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Cliente;


@WebServlet(urlPatterns = {"/BuscarClienteByCpf"})
public class BuscarClienteByCpf extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("CPFClientePesquisa");
        ClienteDAO c = new ClienteDAO();
        Cliente cliente = c.buscarClienteByCpf(cpf);
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/consultaCliente.jsp").forward(request, response);

    }


}
