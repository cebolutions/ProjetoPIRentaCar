<%-- 
    Document   : inserirPagamento
    Created on : 11/04/2015, 12:08:45
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="shortcut icon" href="img/favicon.PNG" type="image/x-icon"/>
        <title>Cebolutions Rent a Car</title>
    </head>
    <body>

        <header>
            <div class="logo-empresa">
                <a href="home.jsp"></a>
            </div>
            <section class="menu">
                <nav class>
                    <ul>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="consulta" href="ConsultaContrato.jsp">Consulta Contrato</a></li>
                        <li><a id="ativo">Finalizar Contrato</a></li>
                    </ul>
                </nav>
            </section>
            <div class="teste"></div>
        </header>

        <div class="container destaque">
            <section class="menu-opcoes">
                <h2>opções</h2>
                <nav class>
                    <ul>
                        <li><a id="inicio" href="home.jsp">Inicio</a></li>
                        <li><a id="clientes" href="clientes.jsp">Clientes</a><br></li>
                        <li><a id="usuarios" href="usuarios.jsp">Usuários</a></li>
                        <li><a id="contratoAtivo" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorio" href="Relatorios.jsp">Relatòrios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>

                <fieldset class="pagamento">
                    <form id="contrato" name="contrato" action="FecharContrato" method="POST">
                        <table>
                            <tr><td>Número da reserva</td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="contrato" value="<c:out value="${contrato.contratoId}"/>"></td></tr>                   
                            <tr><td>Nome Cliente </td><td><input readonly="readonly" name="nomeCliente" value="<c:out value="${cliente.nome}"/>"></td></tr>
                            <tr><td>CPF Cliente </td><td><input readonly="readonly" name="cpfCliente" value="<c:out value="${cliente.cpf}"/>"></td></tr>
                            <tr><td>Data Retirada </td><td><input readonly="readonly" name="dtRetirada" value="<fmt:formatDate value="${contrato.dataRetirada}" pattern="dd/MM/yyyy"/>"></td></tr>
                            <tr><td>Data Devolução </td><td><input type="text" readonly="readonly" name="dtDevolucao" value="<fmt:formatDate value="${contrato.dataDevolucao}" pattern="dd/MM/yyyy"/>"></td></tr>
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
                            <tr><td>Veiculo </td><td><input type="hidden" name="veiculo" value="${veiculo.idVeiculo}"/><input id="veiculo" readonly="readonly" value="${veiculo.categoria} - ${veiculo.marca} ${veiculo.nomeVeiculo}"></tr>
                            <tr><td>Diárias </td><td><input readonly="readonly" name="diarias" value="<c:out value="${contrato.quantidadeDiarias}"/>"></td></tr>
                            <tr><td>Total da Reserva </td><td><input readonly="readonly" name="totalReserva" value="<c:out value="${contrato.saldoReserva}"/>"></td></tr>
                            <tr><td>Valor Recebido </td><td><input readonly="readonly" name="valorPago" value="<c:out value="${pgtoRecebido}"/>"></td></tr>

                            <tr><td>Saldo da Reserva </td><td><input readonly="readonly" name="saldoReserva" value="<c:out value="${saldo}"/>"></td></tr>

                        </table>
                        <div class="submeter"><input type="submit" value="Finalizar"></div>

                    </form>
                </fieldset>
            </main>
        </div><!-- fim .container .destaque -->

        <footer>
            <div class="container">
                <p>Cebolutions <span>Rent a Car</span></p>

                <ul class="social">
                    <li><a href="http://facebook.com/">Facebook</a></li>
                    <li><a href="http://twitter.com/">Twitter</a></li>
                    <li><a href="http://plus.google.com/">Google+</a></li>
                </ul>
            </div>
        </footer>
    </body>
</html>
