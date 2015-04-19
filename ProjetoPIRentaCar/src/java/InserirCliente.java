
import Dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Cliente;

@WebServlet(urlPatterns = {"/InserirCliente"})
public class InserirCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        String cnh = request.getParameter("cnh");
        String dtNasc = request.getParameter("dtNasc");
        Date date = null;

        try {
            date = new SimpleDateFormat("dd/mm/yyyy").parse(dtNasc);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        Cliente cliente = new Cliente(nome, rg, cpf, cnh, date);
        ClienteDAO c = new ClienteDAO();
        c.cadastrarClienteBD(cliente);
        RequestDispatcher rd = request.getRequestDispatcher("cadastroSucesso.jsp");
        rd.forward(request, response);
        
    }

}
