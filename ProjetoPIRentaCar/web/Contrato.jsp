<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
    Author     : pc
--%>

<%@page import="projetorentacar.Cliente" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <form id="BuscarCliente" name="BuscarCliente">
            <label>CPF Cliente</label> <input type="text" maxlength="11" name="CPFClientePesquisa">
            <button type="submit" name="btPesquisa">Pesquisar</button><br>
            <br>


            <jsp:useBean id="cliente" class="projetorentacar.Cliente"/>
                <form id="contrato" name="contrato">
                    <fieldset>
                        <legend>Contrato</legend>
                        <table>
                            <tr><td>Nome Cliente </td><td><input disabled name="nomeCliente" placeholder="dado do BD" /><c:out value="${cliente.clienteId}"/></td></tr>
                            <tr><td>CPF Cliente </td><td><input disabled name="cpfCliente" placeholder="dado do BD"/></td></tr>
                            <tr><td>CNH Cliente </td><td><input disabled name="cnhCliente" placeholder="dado do BD"/></td></tr>
                            <tr><td>Data Retirada </td><td><input type="date" name="dtRetirada"></td>
                                <td>Data Devolução </td><td><input type="date" name="dtDevolucao"></td></tr>
                            <tr><td>Loja </td><td><input disabled name="loja" value="nomeLoja" placeholder="nome da Loja puxada do BD"></td></tr>
                            <tr><td>Veiculo </td><td><input disabled name="veiculo" placeholder="pensar como mostrar lista, talvez dropdown"></td></tr>
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
