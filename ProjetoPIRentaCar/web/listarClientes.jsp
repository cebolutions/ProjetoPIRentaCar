<%-- 
    Document   : listarClientes
    Created on : 05/04/2015, 19:20:52
    Author     : pc
--%>
<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" url="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
        <%
        Cliente c = new Cliente();
        List<Cliente> lista = c.buscarCliente();
        %>
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
            <jsp:useBean id="cliente" class="projetorentacar.Cliente.buscarCliente"/>
            <c:forEach items="$(cliente.lista)" var = "cliente" varStatus="stat">
                <tr>
                <td> <c: out value="$(cliente.clienteId)" /> </td>
                <td> <c: out value="$(cliente.nome)" /> </td>
                <td> <c: out value="$(cliente.rg)" /> </td>
                <td> <c: out value="$(cliente.cpf)" /> </td>
                <td> <c: out value="$(cliente.cnh)" /> </td>
                <td> <c: out value="$(cliente.dataNascimento)" /> </td>
                <td> <c: out value="$(cliente.dataCadastro)" /> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
