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
                        <li><a id="ativo" href="ConsultaContrato.jsp">Consulta Contrato</a></li>

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

                <fieldset>
                    <form action="BuscarContrato" method="POST">
                        <div class="msgerro"><p><c:out value="${erro}"/></p></div>
                        <label>Contrato </label> <input type="text" name="contrato">
                        <button type="submit" name="btPesquisa">Pesquisar </button>
                    </form>
                    <table class="contrato">
                        <tr><td id="label">Número da reserva</td><td><c:out value="${contrato.contratoId}"/></td></tr>                   
                        <tr><td id="label">Nome Cliente </td><td><c:out value="${cliente.nome}"/></td></tr>
                        <tr><td id="label">CPF Cliente </td><td><c:out value="${cliente.cpf}"/></td></tr>
                        <tr><td id="label">Data Retirada </td><td><fmt:formatDate value="${contrato.dataRetirada}" pattern="dd/MM/yyyy"/></td></tr>
                        <tr><td id="label">Data Devolução </td><td><fmt:formatDate value="${contrato.dataDevolucao}" pattern="dd/MM/yyyy"/></td></tr>
                        <tr><td id="label">Loja </td><td>
                                <c:choose>
                                    <c:when test="${contrato.filialId == 0}">São Paulo
                                    </c:when>
                                    <c:when test="${contrato.filialId == 1}">Rio de Janeiro
                                    </c:when>
                                    <c:when test="${contrato.filialId == 2}">Porto Alegre
                                    </c:when>
                                    <c:when test="${contrato.filialId == 3}">Belo Horizonte
                                    </c:when>
                                </c:choose>
                            </td></tr>
                        <tr><td id="label">Veiculo </td><td><c:out value="${veiculo.categoria} - ${veiculo.marca} ${veiculo.nomeVeiculo}"/></td></tr>
                        <tr><td id="label">Diárias </td><td id="data"><c:out value="${contrato.quantidadeDiarias}"/></td></tr>
                        <tr><td id="label">Total da Reserva </td><td id="data">R$<c:out value="${contrato.saldoReserva}"/></td></tr>
                        <tr><td id="label">Valor Recebido </td><td id="data">R$<c:out value="${pgtoRecebido}"/></td></tr>

                        <tr><td id="label">Status </td><td>
                                <c:choose>
                                    <c:when test="${contrato.aberto == true}">Aberto
                                    </c:when>
                                    <c:when test="${contrato.aberto == false}">Fechado
                                    </c:when>
                                </c:choose>
                            </td></tr>

                    </table>
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
