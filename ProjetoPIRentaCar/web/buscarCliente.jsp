<%-- 
    Document   : updateCliente
    Created on : 11/04/2015, 12:07:49
    Author     : pc
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="projetorentacar.Cliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Clientes</title>
    </head>
    <body>
        <form action="AtualizarCliente" method="post">
            <label>CPF Cliente </label><input type="text" maxlength="11" name="CPFClientePesquisa">
            <button type="submit" name="btPesquisa">Pesquisar</button><br>
            <br>
        </form>
    </body>
</html>
