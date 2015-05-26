package Servlets;

import Dao.ClienteDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Cliente;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

//SERVLET PARA INSERIR O CLIENTE NO BD
//RECEBE PARAM FROM CADASTRACLIENTE.JSP
@WebServlet(urlPatterns = {"/InserirCliente"})
public class InserirCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        // verificar se cliente já está no banco
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        if (cpf.contains(".")) {
            cpf = cpf.replace(".","");
        }
        if (cpf.contains("-")) { 
            cpf = cpf.replace("-", "");
        }
        String cnh = request.getParameter("cnh");
        String dtNasc = request.getParameter("dtNasc");
        Date date = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            String ds2 = sdf2.format(sdf1.parse(dtNasc));
            date = sdf2.parse(ds2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        ClienteDAO c = new ClienteDAO();
        List<Cliente> lista = c.buscarCliente();
        for (int i = 0; i < lista.size(); i++) {
            if (nome.equalsIgnoreCase(lista.get(i).getNome()) || cpf.equalsIgnoreCase(lista.get(i).getCpf())) {
                request.setAttribute("erro", true);
                request.getRequestDispatcher("cadastraCliente.jsp").forward(request, response);
            }
        }
        Cliente cliente = new Cliente(nome, rg, cpf, cnh, date);

        c.cadastrarClienteBD(cliente);
        cliente = c.buscarClienteByCpf(cpf);
        request.setAttribute("cliente", cliente);
        LogSistema log = new LogSistema();
        //LOG inserir cliente
        log.cadastrarLog(6, user.getUsuarioId());
        RequestDispatcher rd = request.getRequestDispatcher("cadastroSucesso.jsp");
        rd.forward(request, response);
    }

}
