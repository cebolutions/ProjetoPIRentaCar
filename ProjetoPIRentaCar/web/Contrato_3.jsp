<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Contrato</title>
    </head>
       <body>
           <form id="contrato" action="ConfirmarReserva" method="POST">
            <input type="hidden" name="userLogado" value="${CPFlogado}">
            <fieldset>
                <legend>Reserva</legend>
                <table>
                    <tr><td>Data Retirada </td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="dtRetirada" value="<fmt:formatDate value="${ret}" pattern="dd/MM/yyyy"/>"></td>
                        <td>Data Devolução </td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="dtDevolucao" value="<fmt:formatDate value="${dev}" pattern="dd/MM/yyyy"/>"></td></tr>
                    <tr><td>Loja </td><td><select name="filial">
                                <c:choose>
                                    <c:when test="${filial == 0}">
                                        <option selected value="0">São Paulo</option>
                                    </c:when>
                                    <c:when test="${filial == 1}">
                                        <option selected value="1">Rio de Janeiro</option>
                                    </c:when>
                                    <c:when test="${filial == 2}">
                                        <option selected value="2">Porto Alegre</option>
                                    </c:when>
                                    <c:when test="${filial == 3}">
                                        <option selected value="3">Belo Horizonte</option>
                                    </c:when>
                                </c:choose>
                            </select></td></tr>            
                    <tr><td>Diárias </td><td><input readonly="readonly" type="text" name="diarias" value="${diarias}"></td></tr>
                    <tr><td>Valor Total Reserva: </td><td><input readonly="readonly" type="text" name="valor" value="${valor}"> (<c:out value="${diarias}"/>x R$<c:out value="${veic.valorCategoria}"/>)</td></tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>Disponibilidade</legend>
                <table>
                <tr>
                    <td>Veiculo Escolhido</td>
                    <td>
                <tr><td><input type="hidden" name="veiculo" value="${veic.idVeiculo}"><c:out value="${veic.categoria}"/> | <c:out value="${veic.marca}"/> | <c:out value="${veic.nomeVeiculo}"/> | R$<c:out value="${veic.valorCategoria}"/></td>
                </tr>
                </table>
            </fieldset>
                        <fieldset>
                <legend>Cliente</legend>
                <table>
                <label>CPF Cliente </label><input type="text" maxlength="11" name="CPFClientePesquisa">
                <tr><td><button type="submit" name="btGravarContrato">Avançar</button></td></tr>
                </table>
            </fieldset>
        </form>
                            <a href="Contrato_1.jsp">Alterar dados da busca</a>
                            <h2>3</h2>
    </body>
</html>
