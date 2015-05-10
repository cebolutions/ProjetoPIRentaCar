
import Dao.ClienteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Cliente;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

@WebServlet(urlPatterns = {"/BuscarClientes"})
public class BuscarClientes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        ClienteDAO c = new ClienteDAO();
        List<Cliente> lista = c.buscarCliente();
        request.setAttribute("lista", lista);

        LogSistema log = new LogSistema();
//LOG VIEW LISTA CLIENTES
        log.cadastrarLog(9, user.getUsuarioId());

        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        ClienteDAO c = new ClienteDAO();
        List<Cliente> lista = c.buscarCliente();
        request.setAttribute("lista", lista);

        LogSistema log = new LogSistema();
//LOG VIEW LISTA CLIENTES
        log.cadastrarLog(9, user.getUsuarioId());

        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }

}
