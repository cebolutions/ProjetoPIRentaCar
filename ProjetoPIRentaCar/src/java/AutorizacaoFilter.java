/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projetorentacar.Usuario;

/**
 *
 * @author pc
 */
@WebFilter(filterName = "AutorizacaoFilter", servletNames = {})
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        // 1) OBTEM AS INFORMACOES DO USUARIO DA SESSAO
        // A) CAST DOS PARÂMETROS RECEBIDOS
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // B) TENTA RECUPERAR A SESSÃO DO USUÁRIO
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("user");

        // 2) NA LÓGICA IMPLEMENTADA, SE EXISTIR OBJETO DO USUÁRIO SIGNIFICA
        //    QUE USUÁRIO ESTÁ LOGADO
        //    CASO CONTRÁRIO, REDIRECIONA PARA TELA DE LOGIN
        if (usuario == null) {
            httpResponse.sendRedirect("login.jsp");
            return;
        }
        chain.doFilter(request, response);
        /*
        try {
            // 3) VERIFICAR SE USUARIO PODE ACESSAR PAGINA
            if (verificarAcesso(usuario, httpRequest, httpResponse)) {
                // CHAMADA QUE ENVIA A REQUISIÇÃO PARA O PRÓXIMO FILTRO OU SERVLET
                chain.doFilter(request, response);
            } else {
                // SE NAO PODER ACESSAR, APRESENTA ERRO
                httpResponse.sendRedirect("erroNaoAutorizado.jsp");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
        

    private boolean verificarAcesso(Usuario usuario, HttpServletRequest req, HttpServletResponse resp) {
        String pagina = req.getRequestURI();
        if (pagina.endsWith("ListaServlet") && usuario.autorizado("BASICO")) {
            return true;
        } else if (pagina.endsWith("IncluirPessoaServlet") && usuario.autorizado("ADMIN")) {
            return true;
        }
        return false;
        */
    }

    /**
     * ROTINA PARA DESTRUIÇÃO DO FILTRO
     */
    @Override
    public void destroy() {
    }

    /**
     * ROTINA DE INICIALIZAÇÃO DO FILTRO
     */
    @Override
    public void init(FilterConfig filterConfig) {
    }
}
