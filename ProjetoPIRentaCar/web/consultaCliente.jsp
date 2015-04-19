<%-- 
    Document   : consultaCliente
    Created on : 18/04/2015, 23:27:22
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
        <title>JSP Page </title>
    </head>
    <body>
        <form action="BuscarClienteByCpf" method="post">
            <label>CPF Cliente </label><input type="text" maxlength="11" name="CPFClientePesquisa">
            <button type="submit" name="btPesquisa">Pesquisar</button><br>
            <br>
        </form>
        <fieldset>
            <legend>Cliente</legend>
                <table>
                    <tr><td>Id:</td><td><input disabled name="id" value="${cliente.clienteId}"></td></tr>
                    <tr><td>Nome:</td><td><input disabled name="nome" value="${cliente.nome}"></td></tr>
                    <tr><td>RG:</td><td><input disabled name="rg" value="${cliente.rg}"></td></tr>
                    <tr><td>CPF:</td><td><input disabled name="cpf" value="${cliente.cpf}"></td></tr>
                    <tr><td>CNH:</td><td><input disabled name="cnh" value="${cliente.cnh}"></td></tr>
                    <tr><td>Data Nasc.:</td><td><input disabled name="dtNasc" value="<fmt:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy"/>"></td></tr>
                </table>
        </fieldset>
        <a href="clientes.jsp">Voltar</a>
    </body>
</html>