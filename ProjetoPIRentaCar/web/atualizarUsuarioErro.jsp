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
            <legend>Atualizar Dados do Usuario</legend>
            <form action="AtualizarUsuario" method="post">
                <label>CPF Usuario </label><input type="text" maxlength="11" name="CPFUsuario">
                <button type="submit" name="btPesquisa">Pesquisar </button><br>
                <br>
            </form>
            <p>CPF inválido!</p>
            <form id="atualizar" action="AtualizarUsuario" method="POST">
                <table>
                    <tr><td>ID:</td><td><input type="text" name="id" value="${usuario.usuarioId}"/></td></tr>
                    <tr><td>Nome:</td><td><input type="text" name="nome" value="${usuario.nome}"/></td></tr>
                    <tr><td>RG:</td><td><input type="text" name="rg" value="${usuario.rg}"/></td></tr>
                    <tr><td>CPF:</td><td><input type="text" name="cpf" value="${usuario.cpf}"/></td></tr>
                    <tr><td>Login:</td><td><input type="text" name="login" value="${usuario.login}"/></td></tr>
                    <tr><td>Senha:</td><td><input type="text" name="senha" value="${usuario.senha}"/></td></tr>
                    <tr><td>Cargo: </td><td><select name="cargo">
                                <c:choose>
                                    <c:when test="${usuario.cargo == 0}">
                                        <option selected value="0">Atendente</option>
                                        <option value="1">Gerente</option>
                                        <option value="2">Diretor</option>
                                    </c:when>
                                    <c:when test="${usuario.cargo == 1}">
                                        <option value="0">Atendente</option>
                                        <option selected value="1">Gerente</option>
                                        <option value="2">Diretor</option>
                                    </c:when>
                                    <c:when test="${usuario.cargo == 2}">
                                        <option value="0">Atendente</option>
                                        <option value="1">Gerente</option>
                                        <option selected value="2">Diretor</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>Cargo</option>
                                    </c:otherwise>
                                </c:choose>

                            </select></td></tr>
                    <tr><td>Filial: </td><td><select name="filial">
                                <c:choose>
                                    <c:when test="${usuario.filial == 0}">
                                        <option selected value="0">São Paulo</option>
                                        <option value="1">Rio de Janeiro</option>
                                        <option value="2">Porto Alegre</option>
                                        <option value="3">Belo Horizonte</option>
                                    </c:when>
                                    <c:when test="${usuario.filial == 1}">
                                        <option value="0">São Paulo</option>
                                        <option selected value="1">Rio de Janeiro</option>
                                        <option value="2">Porto Alegre</option>
                                        <option value="3">Belo Horizonte</option>
                                    </c:when>
                                    <c:when test="${usuario.filial == 2}">
                                        <option value="0">São Paulo</option>
                                        <option value="1">Rio de Janeiro</option>
                                        <option selected value="2">Porto Alegre</option>
                                        <option value="3">Belo Horizonte</option>
                                    </c:when>
                                    <c:when test="${usuario.filial == 3}">
                                        <option  value="0">São Paulo</option>
                                        <option value="1">Rio de Janeiro</option>
                                        <option value="2">Porto Alegre</option>
                                        <option selected value="3">Belo Horizonte</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>Loja</option>
                                    </c:otherwise>
                                </c:choose>
                            </select></td></tr>

                    <tr><td>
                            <c:choose>
                                <c:when test="${usuario.ativo== true}">
                                    <input type="radio" name="ativo" checked/>Ativo <br>
                                    <input type="radio" name="ativo"/>Inativo
                                </c:when>
                                <c:when test="${usuario.ativo== false}">
                                    <input type="radio" name="ativo"/>Ativo
                                    <input type="radio" name="ativo" checked/>Inativo</c:when>
                                <c:otherwise>
                                    <input disabled type="radio" name="ativo"/>Ativo <br>
                                    <input disabled type="radio" name="ativo"/>Inativo
                                </c:otherwise>
                            </c:choose>
                        <td></tr>
                </table>
                <button type="submit" value="Atualizar">Atualizar</button>
            </form>
        </fieldset>
        <a href="usuarios.jsp">Voltar</a>
    </body>
</html>
