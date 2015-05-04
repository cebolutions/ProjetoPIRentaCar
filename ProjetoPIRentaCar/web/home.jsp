<%-- 
    Document   : home
    Created on : 18/04/2015, 22:24:55
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <label>${user.nome}</label><input type="hidden" name="userLogado" value="${user.usuarioId}"/>
        <h1>Home </h1>
        <a href="clientes.jsp">Clientes</a><br>
        <a href="usuarios.jsp">Usuários</a><br>
        <a href="Contrato_1.jsp">Contrato</a><br>
        <a href="Pagamento.jsp">Pagamentos</a><br>
        <a href="Relatorios.jsp">Relatorios</a><br><br>
        
       
        
        
        <a href="login.jsp">Logout</a><br>
        
    </body>
</html>
