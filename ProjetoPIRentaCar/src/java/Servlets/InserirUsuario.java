package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.LogSistema;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/InserirUsuario"})
public class InserirUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        

        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf = request.getParameter("cpf");
        if (cpf.contains(".")) {
            cpf = cpf.replace(".","");
        }
        if (cpf.contains("-")) { 
            cpf = cpf.replace("-", "");
        }
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String c = request.getParameter("cargo");
        int cargo = Integer.parseInt(c);
        String f = request.getParameter("filial");
        int filial = Integer.parseInt(f);

        Usuario usuario = new Usuario(nome, rg, cpf, login, senha, cargo, filial);
        UsuarioDAO u = new UsuarioDAO();
        List<Usuario> lista = u.buscarUsuarios();
        for (Usuario us: lista){
            if (us.getLogin().equals(login)) {
                request.setAttribute("erroLogin", true);
                request.getRequestDispatcher("cadastraUsuario.jsp").forward(request, response);
            }
            if (us.getCpf().equalsIgnoreCase(cpf)) {
                request.setAttribute("erroCpf", true);
                request.getRequestDispatcher("cadastraUsuario.jsp").forward(request, response);
            }
            
        }
        u.cadastrarUsuarioBD(usuario);
        
        usuario = u.buscarUsuarioByCpf(cpf);
        request.setAttribute("usuario", usuario);
        LogSistema log = new LogSistema();
        //LOG inserir usuario
        log.cadastrarLog(2, user.getUsuarioId());
        RequestDispatcher rd = request.getRequestDispatcher("cadastroUsuarioSucesso.jsp");
        rd.forward(request, response);
    }

}
