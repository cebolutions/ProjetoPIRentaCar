
import Dao.ClienteDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import projetorentacar.Cliente;

@WebServlet(urlPatterns = {"/AtualizarCliente"})
public class AtualizarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("CPFClientePesquisa") == null) {
            // disabled esta dando conflito
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
            ClienteDAO c = new ClienteDAO();
            Cliente cliente = new Cliente(id,nome,rg,cpf,cnh,date,dateCad);
            c.updateCliente(cliente);
            
            request.getRequestDispatcher("/cadastroSucesso.jsp").forward(request, response);
            
        } else {
            String cpfBusca = request.getParameter("CPFClientePesquisa");
            ClienteDAO c = new ClienteDAO();
            Cliente cliente = c.buscarClienteByCpf(cpfBusca);
            request.setAttribute("cliente", cliente);

            request.getRequestDispatcher("/atualizarCliente.jsp").forward(request, response);
        }
    }

}
