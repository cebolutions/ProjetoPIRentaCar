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
        <form id="BuscarContrato" name="BuscarContrato">
            <td>Contrato </td> <input type="text" maxlength="11" name="CPFClientePesquisa">
            <button type="submit" name="btPesquisa">Pesquisar </button><br>
            <br>


            <jsp:useBean id="cliente" class="projetorentacar.Cliente.buscarCliente"/>
            <c:forEach items="$(cliente.lista)" var = "cliente" varStatus="stat">
                <form id="contrato" name="contrato">
                    <fieldset>
                        <legend>Pagamento</legend>
                        <table>
                            <tr><td>Nome Cliente </td><td><input disabled name="nomeCliente" placeholder="dado do BD" /></td></tr>
                            <tr><td>CPF Cliente </td><td><input disabled name="cpfCliente" placeholder="dado do BD"/></td></tr>
                            <tr><td>CNH Cliente </td><td><input disabled name="cnhCliente" placeholder="dado do BD"/></td></tr>
                            <tr><td>Data Retirada </td><td><input disabled name="dtRetirada"></td></tr>
                            <tr><td>Data Devolução </td><td><input disabled name="dtDevolucao"></td></tr>
                            <tr><td>Loja </td><td><input disabled name="loja" value="nomeLoja" placeholder="nome da Loja puxada do BD"></td></tr>
                            <tr><td>Veiculo </td><td><input disabled name="veiculo" placeholder="pensar como mostrar lista, talvez dropdown"></td></tr>
                            <tr><td>Diárias </td><td><input disabled name="diarias" ></td></tr>
                            <tr><td>Saldo da Reserva </td><td><input disabled name="saldoReserva" placeholder="valor "/></td></tr>

                        </table>	
                        <fieldset>

                            <legend>Inserir Pagamento</legend>
                            <table>
                                <tr><td>Forma de Pagamento</td><td><select>
                                            <option value="dinheiro">Dinheiro</option>
                                            <option value="cartao">Cartão</option>
                                        </select>
                                    </td></tr>
                                <tr><td>Valor Recebido </td><td><input type="text" name="vlRecebido"  /></td></tr>
                                <tr><td><button type="submit" name="btAddPagto">Cadastrar Pagamento</button></td></tr>
                            </table>
                        </fieldset>
                    </fieldset>





                    <fieldset>
                        <legend>Pagamento Recebidos</legend>
                        <table border="1" cellpadding="5">
                            <tr>
                                <th>Data</th>
                                <th>Tipo de pagamento</th>
                                <th>Valor</th>
                            </tr>
                            <tr>
                                <th>01/01/1890</th>
                                <th>Dinheiro</th>
                                <th>100,00</th>
                            </tr>
                            <tr>
                                <th>02/01/1890</th>
                                <th>Cartão</th>
                                <th>100,00</th>
                            </tr>
                            <tr>
                                <th></th>
                                <th>Total Pago</th>
                                <th>200,00</th>
                            </tr>
                        </table>
                    </fieldset>

                    <p> só liberar o bt quando saldo = 0</p>
                    <button disabled type="submit" name="btFinalizarContrato">Finalizar Contrato</button><br>

                </form>


                </fieldset>	
                </body>
                </html>
