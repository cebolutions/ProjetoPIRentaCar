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
        <form action="FecharContrato" id="BuscarContrato" name="BuscarContrato">
            <label>Contrato </label> <input type="text" name="contrato">
            <button type="submit" name="btPesquisa">Pesquisar </button>
        </form>

        <form id="contrato" name="contrato">
            <fieldset>
                <legend>Pagamento</legend>
                <table>
                    <tr><td>Número da reserva</td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="contrato" value="<c:out value="${contrato.contratoId}"/>"></td></tr>                   
                    <tr><td>Nome Cliente </td><td><input readonly="readonly" name="nomeCliente" value="<c:out value="${cliente.nome}"/>"></td></tr>
                    <tr><td>CPF Cliente </td><td><input readonly="readonly" name="cpfCliente" value="<c:out value="${cliente.cpf}"/>"></td></tr>
                    <tr><td>Data Retirada </td><td><input readonly="readonly" name="dtRetirada" value="<c:out value="${contrato.dataRetirada}"/>"></td></tr>
                    <tr><td>Data Devolução </td><td><input readonly="readonly" name="dtDevolucao" value="<c:out value="${contrato.dataDevolucao}"/>"></td></tr>
                    <tr><td>Loja </td><td>
                    <c:choose>
                        <c:when test="${contrato.filialId == 0}">
                            <input readonly="readonly" name="filial" value="São Paulo">
                        </c:when>
                        <c:when test="${contrato.filialId == 1}">
                            <input readonly="readonly" name="filial" value="Rio de Janeiro">
                        </c:when>
                        <c:when test="${contrato.filialId == 2}">
                            <input readonly="readonly" name="filial" value="Porto Alegre">
                        </c:when>
                        <c:when test="${contrato.filialId == 3}">
                            <input readonly="readonly" name="filial" value="Belo Horizonte">
                        </c:when>
                    </c:choose>
                    </td></tr>
                    <tr><td>Veiculo </td><td><input readonly="readonly" name="veiculo" value="<c:out value="${veiculo.nomeVeiculo}"/>"></td></tr>
                    <tr><td>Diárias </td><td><input readonly="readonly" name="diarias" value="<c:out value="${contrato.quantidadeDiarias}"/>"></td></tr>
                    <tr><td>Total da Reserva </td><td><input readonly="readonly" name="totalReserva" value="<c:out value="${contrato.saldoReserva}"/>"></td></tr>
                    <tr><td>Valor Recebido </td><td><input readonly="readonly" name="valorPago" value="<c:out value="${pgtoRecebido}"/>"></td></tr>

                    <tr><td>Saldo da Reserva </td><td><input readonly="readonly" name="saldoReserva" value="<c:out value="${saldo}"/>"></td></tr>


                </table>	
                <button type="submit" name="btFinalizarContrato">Finalizar Contrato</button><br>
            </fieldset>
        </form>

    </body>
</html>
