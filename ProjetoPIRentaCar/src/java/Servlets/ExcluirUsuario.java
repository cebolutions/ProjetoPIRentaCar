/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.UsuarioDAO;
import java.io.IOException;
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
@WebServlet(name = "ExcluirUsuario", urlPatterns = {"/ExcluirUsuario"})
public class ExcluirUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));

        if (request.getParameter("CPFUsuario") != null) {
            String cpf = request.getParameter("CPFUsuario");
            if (cpf.contains(".")) {
            cpf = cpf.replace(".","");
        }
        if (cpf.contains("-")) { 
            cpf = cpf.replace("-", "");
        }
            UsuarioDAO u = new UsuarioDAO();
            Usuario usuario = u.buscarUsuarioByCpf(cpf);

            LogSistema log = new LogSistema();
            //LOG BUSCA DE USUARIO
            log.cadastrarLog(4, user.getUsuarioId());

            if (usuario.getCpf() == null) {
                request.setAttribute("erro", "Usuário não encontrado!");

                RequestDispatcher rd = request.getRequestDispatcher("excluirUsuario.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/excluirUsuario.jsp").forward(request, response);
            }
        } else {
            UsuarioDAO u = new UsuarioDAO();
            u.deleteUsuarioBD(Integer.parseInt(request.getParameter("id")));

            request.setAttribute("sucesso", "Usuário excluído com sucesso!");
            LogSistema log = new LogSistema();
        //LOG EXCLUIR usuario
            log.cadastrarLog(16, user.getUsuarioId());
            RequestDispatcher rd = request.getRequestDispatcher("excluirUsuario.jsp");
            rd.forward(request, response);
        }

    }

}
