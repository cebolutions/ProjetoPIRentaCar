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
        <form action="Contrato" method="POST">
            <label>CPF Cliente</label> <input type="text" maxlength="11" name="CPFClientePesquisa">
            <button type="submit" name="btPesquisa">Pesquisar </button><br>
        </form>

        <form id="contrato" name="contrato">
            <fieldset>
                <legend>Contrato</legend>
                <table>
                    <tr><td>Nome Cliente </td><td><input disabled name="nomeCliente" value="${cliente.nome}"/></td></tr>
                    <tr><td>CPF Cliente </td><td><input disabled name="cpfCliente" value="${cliente.cpf}"/></td></tr>
                    <tr><td>CNH Cliente </td><td><input disabled name="cnhCliente" value="${cliente.cnh}"/></td></tr>
                    <tr><td>Data Retirada </td><td><input type="date" name="dtRetirada"></td>
                        <td>Data Devolução </td><td><input type="date" name="dtDevolucao"></td></tr>
                    <tr><td>Loja </td><td><select>
                                <option name="0" value="sao">São Paulo</option>
                                <option name="1" value="rio">Rio de Janeiro</option>
                                <option name="2" value="poa">Porto Alegre</option>
                                <option name="3" value="bhz">Belo Horizonte</option>
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
                    

                    <tr><td><button type="submit" name="btVerifica">Verificar Disponibilidade</button></td></tr>

                    <tr><td>Diárias </td><td><input type="text" name="diarias" ></td></tr>
                    <tr><td>Saldo da Reserva </td><td><input disabled name="saldoReserva" placeholder="valor "/></td></tr>

                    <tr><td><a href="pagamento.jps">Inserir Pagamento</a></td></tr>
                    <p>Talvez não seja necessário inserir pagamento agora</p>
                </table>		
                <fieldset>
                    <table>

                        <legend>Inserir Pagamento</legend>
                        <tr><td>Forma de Pagamento</td><td><select>
                                    <option value="dinheiro">Dinheiro</option>
                                    <option value="cartao">Cartão</option>
                                </select>
                            </td></tr>
                        <tr><td>Valor Recebido </td><td><input type="text" name="vlRecebido"  /></td></tr>
                    </table>   
                </fieldset>
                <table>
                    <tr><td><button type="submit" name="btGravarContrato">Abrir Contrato</button></td></tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>
