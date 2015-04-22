<%-- 
    Document   : listarClientes
    Created on : 05/04/2015, 19:20:52
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes </title>
    </head>
    <body>
        <table border="1" cellpadding="10">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>RG</th>
                <th>CPF</th>
                <th>CNH</th>
                <th>Data Nascimento</th>
                <th>Data Cadastro</th>
            </tr>
            <c:forEach items="${lista}" var="cliente" varStatus="stat">
                <tr>
                <td> <c:out value="${cliente.clienteId}" /></td>
                <td> <c:out value="${cliente.nome}" /> </td>
                <td> <c:out value="${cliente.rg}" /> </td>
                <td> <c:out value="${cliente.cpf}" /> </td>
                <td> <c:out value="${cliente.cnh}" /> </td>
                <td> <fmt:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy"/> </td>
                <td> <fmt:formatDate value="${cliente.dataCadastro}" pattern="dd/MM/yyyy"/> </td>
                </tr>
            </c:forEach>
        </table>
        <a href="clientes.jsp">Voltar</a>
    </body>
</html>
