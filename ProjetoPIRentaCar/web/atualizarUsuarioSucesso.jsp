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

        <fieldset>
            <legend>Dados Atualizados</legend>
            <p>Dados atualizados com Sucesso!</p>
            <table>
                <tr><td>ID:</td><td><input readonly="readonly" type="text" name="id" value="${usuario.usuarioId}"/></td></tr>
                <tr><td>Nome:</td><td><input readonly="readonly" type="text" name="nome" value="${usuario.nome}"/></td></tr>
                <tr><td>RG:</td><td><input readonly="readonly" type="text" name="rg" value="${usuario.rg}"/></td></tr>
                <tr><td>CPF:</td><td><input readonly="readonly" type="text" name="cpf" value="${usuario.cpf}"/></td></tr>
                <tr><td>Login:</td><td><input readonly="readonly" type="text" name="login" value="${usuario.login}"/></td></tr>
                <tr><td>Senha:</td><td><input readonly="readonly" type="text" name="senha" value="${usuario.senha}"/></td></tr>
                <tr><td>Cargo: </td><td>
                        <c:choose>
                            <c:when test="${usuario.cargo == 0}"><input readonly="readonly" type="text" name="cargo" value="Atendente"/></c:when>
                            <c:when test="${usuario.cargo == 1}"><input readonly="readonly" type="text" name="cargo" value="Gerente"/></c:when>
                            <c:when test="${usuario.cargo == 2}"><input readonly="readonly" type="text" name="cargo" value="Diretor"/></c:when>
                        </c:choose></td>

                    <td> </td></tr>
                <tr><td>Filial: </td><td> 
                        <c:choose>
                            <c:when test="${usuario.filial == 0}"><input readonly="readonly" type="text" name="filial" value="São Paulo"/></c:when>
                            <c:when test="${usuario.filial == 1}"><input readonly="readonly" type="text" name="filial" value="Rio de Janeiro"/></c:when>
                            <c:when test="${usuario.filial == 2}"><input readonly="readonly" type="text" name="filial" value="Porto Alegre"/></c:when>
                            <c:when test="${usuario.filial == 3}"><input readonly="readonly" type="text" name="filial" value="Belo Horizonte"/></c:when>
                        </c:choose></td></tr>
                <tr><td>
                        <c:choose>
                            <c:when test="${usuario.ativo== true}"><input  type="radio" name="ativo" checked/>Ativo</c:when>
                            <c:when test="${usuario.ativo== false}"><input type="radio" name="ativo" checked/>Inativo</c:when>
                        </c:choose></td></tr>
            </table>
        </fieldset>
        <a href="usuarios.jsp">Voltar</a>
    </body>
</html>
