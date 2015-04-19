<%-- 
    Document   : listarClientes
    Created on : 05/04/2015, 19:20:52
    Author     : pc
--%>

<%@page import="java.util.List"%>
<%@page import="projetorentacar.Cliente"%>
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
            <% for(Cliente cl:lista){%>
                <tr>
                <td> <%= cl.getClienteId() %> </td>
                <td> <%= cl.getNome() %> </td>
                <td> <%= cl.getRg() %> </td>
                <td> <%= cl.getCpf() %> </td>
                <td> <%= cl.getCnh() %> </td>
                <td> <%= cl.getDataNascimento() %> </td>
                <td> <%= cl.getDataCadastro() %> </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
