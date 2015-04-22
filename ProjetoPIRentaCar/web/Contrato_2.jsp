<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
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
        <title>Cadastrar Contrato</title>
    </head>
    <body>
        <form id="contrato" name="contrato">
            <fieldset>
                <legend>Contrato</legend>
                <table>
                    <tr><td>Data Retirada </td><td><input type="text" name="dtRetirada" value="<fmt:formatDate value="${ret}" pattern="dd/MM/yyyy"/>"></td>
                        <td>Data Devolução </td><td><input type="text" name="dtDevolucao" value="<fmt:formatDate value="${dev}" pattern="dd/MM/yyyy"/>"></td></tr>
                    <tr><td>Loja </td><td><select>
                                <option name="filial">${filial}</option>
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
                    

                    <tr><td>Diárias </td><td><input type="text" name="diarias" ></td></tr>
                    <tr><td>Saldo da Reserva </td><td><input disabled name="saldoReserva" placeholder="valor "/></td></tr>

                        <tr><td>Valor Recebido </td><td><input type="text" name="vlRecebido"  /></td></tr>
                   
                    <tr><td><button type="submit" name="btGravarContrato">Abrir Contrato</button></td></tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
