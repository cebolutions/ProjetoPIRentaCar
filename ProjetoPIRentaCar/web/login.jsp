
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@page import="java.util.*" %> 
<%@page import="java.sql.*" %> 
<%@page import="projetorentacar.*" %>
<%@page import="projetorentacar.AcessoUsuario" %>
<%@page import="projetorentacar.LogSistema" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login </title>
    </head>
    <body>
        <%
            AcessoUsuario ac = new AcessoUsuario();
            LogSistema logSis = new LogSistema();

            String log = request.getParameter("login");
            String pass = request.getParameter("senha");
            boolean val = ac.validarUsuario(log, pass);
            if (val) {
                logSis.setUsuarioId(ac.getUsuarioId());
                logSis.cadastrarLog(0);
                out.println(ac.getLogin());
                out.println(ac.getSenha());
                out.println(ac.getCargo());
            }
        %>
        <form action="a.jsp" name="fLogin">
            <table border="0">
                <thead>
                    <tr>
                        <th>Login</th>
                        <th><input type="text" name="login" value="" /></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Senha</td>
                        <td><input type="password" name="senha" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Entrar" name="submit" />


            <input type="hidden" value="hidden" name="hidden" />

        </form>
        <script>
            function result() {
                if (document.fLogin.hidden.value == 1) {
                    alert = "Login Efetuado!";
                }
            }
        </script>
    </body>
</html>
