<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="projetorentacar.Cliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Contrato</title>
    </head>
    <body>
<script>
            function disponibilidade(i) {
                var filial = document.getElementById("filial");
                filial.setAttribute("value", i);
                var url = '/Disponibilidade';

                var myAjax = new Ajax.Updater('veiculos', url, {
                            method: 'POST',
                            parameters: filial,
                        }
                );
            }
        </script>
        <form action="Contrato" method="POST" name="contrato">
            <fieldset>
                <legend>Contrato</legend>
                <table>

                    <tr><td>Data Retirada </td><td><input type="date" name="dtRetirada"></td>
                        <td>Data Devolução </td><td><input type="date" name="dtDevolucao"></td></tr>
                    <tr><td>Loja </td><td><select>
                                <option></option>
                                <option name="sao" id="0" >São Paulo</option>
                                <option name="rio" id="1" onselect="disponibilidade(1)">Rio de Janeiro</option>
                                <option name="bhz" id="2" onselect="disponibilidade(2)">Belo Horizonte</option>
                                <option name="poa" id="3" onselect="disponibilidade(3)">Porto Alegre</option>
                            </select></td></tr>
                    <input id="filial" hidden  name="filial"/>


                    <tr>
                        <td>Veiculo </td>
                        <td>
                            <select id="veiculos">
                                <c:forEach items="${veic}" var="veic" varStatus="stat">
                                    <option name="veicEscolhido" value="${veic.idVeiculo}"><c:out value="${veic.categoria}"/> | <c:out value="${veic.marca}"/> | <c:out value="${veic.nomeVeiculo}"/> | <c:out value="${veic.quantidade}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>



                    <tr><td>Diárias </td><td><input type="text" name="diarias" ></td></tr>
                    <tr><td>Saldo da Reserva </td><td><input disabled name="saldoReserva" placeholder="valor "/></td></tr>
                    <tr><td><button type="submit" name="btVerifica">Verificar Disponibilidade</button></td></tr>
                </table>
        </form>
        <fieldset>
            <form action="Contrato" method="POST">
                <label>CPF Cliente</label> <input type="text" maxlength="11" name="CPFClientePesquisa">
                <button type="submit" name="btPesquisa">Pesquisar </button><br>
                <table>
                    <tr><td>Nome Cliente </td><td><input disabled name="nomeCliente" value="${cliente.nome}"/></td></tr>
                    <tr><td>CNH Cliente </td><td><input disabled name="cnhCliente" value="${cliente.cnh}"/></td></tr>
                </table>

            </form>
        </fieldset>
        
    </body>
</html>
