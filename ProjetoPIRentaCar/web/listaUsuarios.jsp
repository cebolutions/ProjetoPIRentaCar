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
        <title>Lista de Usuarios </title>
    </head>
    <body>
        <table border="1" cellpadding="10">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>RG</th>
                <th>CPF</th>
                <th>login</th>
                <th>Cargo</th>
                <th>Filial</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${lista}" var="user" varStatus="stat">
                <tr>
                    <td><c:out value="${user.usuarioId}" /></td>
                    <td> <c:out value="${user.nome}" /> </td>
                    <td> <c:out value="${user.rg}" /> </td>
                    <td> 
                        <a title="Clique para alterar" href="http://localhost:8080/ProjetoPIRentaCar/AtualizarUsuario?cpf=${user.cpf}">
                            <c:out value="${user.cpf}"/>
                        </a>
                    </td>
                    <td> <c:out value="${user.login}" /> </td>
                    <td> <c:choose>
                            <c:when test="${user.cargo == 0}">Atendente</c:when>
                            <c:when test="${user.cargo == 1}">Gerente</c:when>
                            <c:when test="${user.cargo == 2}">Diretor</c:when>
                        </c:choose></td>
                    <td> <c:choose>
                            <c:when test="${user.filial == 0}">São Paulo</c:when>
                            <c:when test="${user.filial == 1}">Rio de Janeiro</c:when>
                            <c:when test="${user.filial == 2}">Porto Alegre</c:when>
                            <c:when test="${user.filial == 3}">Belo Horizonte</c:when>
                        </c:choose></td>
                    <td> <c:choose>
                            <c:when test="${user.ativo== true}">Ativo</c:when>
                            <c:when test="${user.ativo== false}">Inativo</c:when>
                        </c:choose></td>
                </tr>
            </c:forEach>
        </table>
        <a href="usuarios.jsp">Voltar</a>
    </body>
</html>
