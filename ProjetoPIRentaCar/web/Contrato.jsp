<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="projetorentacar.Cliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Contrato</title>
    </head>
    <body>
        <form id="contrato" name="contrato">
            <fieldset>
                <legend>Contrato</legend>
                <table>
                    <tr><td>Nome Cliente </td><td><input disabled name="nomeCliente" value="${cliente.nome}"/></td></tr>
                    <tr><td>CPF Cliente </td><td><input disabled name="cpfCliente" value="${cliente.cpf}"/></td></tr>
                    <tr><td>CNH Cliente </td><td><input disabled name="cnhCliente" value="${cliente.cnh}"/></td></tr>
                    <tr><td>Data Retirada </td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="dtRetirada" value="<fmt:formatDate value="${ret}" pattern="dd/MM/yyyy"/>"></td>
                        <td>Data Devolução </td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="dtDevolucao" value="<fmt:formatDate value="${dev}" pattern="dd/MM/yyyy"/>"></td></tr>
                    <tr><td>Loja </td><td><select>
                                <option selected name="filial" value="${filialId}" title="Não é possível alterar">${filial}</option>
                            </select></td></tr>  
                    <tr>
                        <td>Veiculo </td>
                        <td>
                            <select>
                                <c:forEach items="${veic}" var="veic" varStatus="stat">
                                    <option><c:out value="${veic.categoria}"/> | <c:out value="${veic.marca}"/> | <c:out value="${veic.nomeVeiculo}"/> | <c:out value="${veic.quantidade}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <label>CPF Cliente</label> <input type="text" maxlength="11" name="CPFClientePesquisa">

                    <tr><td><button type="submit" name="btVerifica">Verificar Disponibilidade</button></td></tr>

                    <tr><td>Diárias </td><td><input type="text" name="diarias" ></td></tr>
                    <tr><td>Saldo da Reserva </td><td><input disabled name="saldoReserva" placeholder="valor "/></td></tr>

                </table>		
                <table>
                    <tr><td><button type="submit" name="btGravarContrato">Confirmar Contrato</button></td></tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>

