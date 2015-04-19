
import Dao.ClienteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Cliente;

@WebServlet(urlPatterns = {"/BuscarClientes"})
public class BuscarClientes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO c = new ClienteDAO();
        List<Cliente> lista = c.buscarCliente();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO c = new ClienteDAO();
        List<Cliente> lista = c.buscarCliente();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }

}
