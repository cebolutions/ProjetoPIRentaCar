<%-- 
    Document   : page1
    Created on : 20/03/2015, 22:47:10
    Author     : pc
--%>


<%@page import="org.jboss.weld.context.beanstore.BeanStore"%>
<%@page import="org.apache.taglibs.standard.lang.jstl.test.Bean1"%>
<%@page import="java.beans.Beans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem Vindo!</h1>
        <%
            String nome="", sobrenome="", cpf="", endereco="";
            if (request.getParameter("nome") != null) {
                nome = request.getParameter("nome");
            }
            if (request.getParameter("sobrenome") != null) {
                sobrenome = request.getParameter("sobrenome");
            }
            if (request.getParameter("cpf") != null) {
                cpf = request.getParameter("cpf");
            }
            if (request.getParameter("endereco") != null) {
                endereco = request.getParameter("endereco");
            }
        %>

        <jsp:useBean id="sessaoAtual" class="projetorentacar.TestUsuario" scope="session"/> 
            <jsp:setProperty name="sessaoAtual" property="nome" value="<%=nome%>" />
            <jsp:setProperty name="sessaoAtual" property="sobrenome" value="<%=sobrenome%>"  />
            <jsp:setProperty name="sessaoAtual" property="cpf" value="<%=cpf%>" />
            <jsp:setProperty name="sessaoAtual" property="endereco" value="<%=endereco%>" />
        <table>
            
            <tr><td>Nome:</td><td><jsp:getProperty name="sessaoAtual" property="nome"/></td></tr>
            
            <tr><td>Nome:</td><td><jsp:getProperty name="sessaoAtual" property="sobrenome"/></td></tr>
            
            <tr><td>Nome:</td><td><jsp:getProperty name="sessaoAtual" property="cpf"/></td></tr>
            
            <tr><td>Nome:</td><td><jsp:getProperty name="sessaoAtual" property="endereco"/></td></tr>
        </table>

    </body>
</html>

