<%-- 
    Document   : AtualizarCliente
    Created on : 12/04/2015, 19:14:40
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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AtualizarCliente" method="post">
            <label>CPF Cliente </label><input type="text" maxlength="11" name="CPFClientePesquisa">
            <button type="submit" name="btPesquisa">Pesquisar</button><br>
            <br>
        </form>
        <fieldset>
            <legend>Atualizar Dados do Cliente</legend>
            <form id="atualizar" action="AtualizarCliente" method="POST">
                <table>
                    <tr><td>Id:</td><td><input disabled type="text" name="id" value="${cliente.clienteId}"></td></tr>
                    <tr><td>Nome:</td><td><input type="text" name="nome" value="${cliente.nome}"></td></tr>
                    <tr><td>RG:</td><td><input type="text" name="rg" value="${cliente.rg}"></td></tr>
                    <tr><td>CPF:</td><td><input type="text" name="cpf" value="${cliente.cpf}"></td></tr>
                    <tr><td>CNH:</td><td><input type="text" name="cnh" value="${cliente.cnh}"></td></tr>
                    <tr><td>Data Nasc.:</td><td><input type="text" name="dtNasc" value="<fmt:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy"/>"></td></tr>
                    <tr><td>Data Cadastro:</td><td><input disabled name="dtCadastro" value="<fmt:formatDate value="${cliente.dataCadastro}" pattern="dd/MM/yyyy"/>"></td></tr>
                </table>
                <button type="submit" value="Atualizar">Atualizar</button>
                <button type="reset" value="Limpar">Limpar</button>
            </form>
        </fieldset>
        <a href="clientes.jsp">Voltar</a>
    </body>
</html>
