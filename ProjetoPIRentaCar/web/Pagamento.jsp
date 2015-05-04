<%-- 
    Document   : inserirPagamento
    Created on : 11/04/2015, 12:08:45
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagamentos</title>
    </head>
    <body>
        <form action="BuscarContratoPagamento" id="BuscarContrato" name="BuscarContrato">
            <label>Contrato </label> <input type="text" name="contrato">
            <button type="submit" name="btPesquisa">Pesquisar </button>
        </form>

        <form id="contrato" name="contrato">
            <fieldset>
                <legend>Pagamento</legend>
                <table>
                    <tr><td>Número da reserva</td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="contrato" value="<c:out value="${contrato.contratoId}"/>"></td></tr>                   
                    <tr><td>Nome Cliente </td><td><input readonly="readonly" name="nomeCliente" /></td></tr>
                    <tr><td>CPF Cliente </td><td><input readonly="readonly" name="cpfCliente" /></td></tr>
                    <tr><td>Data Retirada </td><td><input readonly="readonly" name="dtRetirada"></td></tr>
                    <tr><td>Data Devolução </td><td><input readonly="readonly" name="dtDevolucao"></td></tr>
                    <tr><td>Loja </td><td><input readonly="readonly" name="loja" ></td></tr>
                    <tr><td>Veiculo </td><td><input readonly="readonly" name="veiculo" ></td></tr>
                    <tr><td>Diárias </td><td><input readonly="readonly" name="diarias" ></td></tr>
                    <tr><td>Total da Reserva </td><td><input readonly="readonly" name="totalReserva" /></td></tr>
                    <tr><td>Valor Recebido </td><td><input readonly="readonly" name="valorPago" /></td></tr>

                    <tr><td>Saldo da Reserva </td><td><input readonly="readonly" name="saldoReserva" /></td></tr>

                </table>	
                <fieldset>

                    <legend>Inserir Pagamento</legend>
                    <table>
                        <tr><td>Forma de Pagamento</td>
                            <td><select>
                                    <option value="0">Dinheiro</option>
                                    <option value="1">Cartão</option>
                                </select>
                            </td>
                        </tr>
                        <tr><td>Valor Recebido </td><td><input type="text" name="vlPago"/></td></tr>
                        <tr><td><button type="submit" name="btAddPagto">Inserir Pagamento</button></td></tr>
                    </table>
                </fieldset>

                <button disabled type="submit" name="btFinalizarContrato">Finalizar Contrato</button><br>
                </form>

                </body>
                </html>
