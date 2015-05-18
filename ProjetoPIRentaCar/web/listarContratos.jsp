<%-- 
    Document   : listarClientes
    Created on : 05/04/2015, 19:20:52
    Author     : pc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <li><a id="ativo" href="http://localhost:8080/ProjetoPIRentaCar/BuscarContratos">Lista de Contrato</a></li>
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
                        <li><a id="usuarios" href="http://localhost:8080/ProjetoPIRentaCar/AcessoUsuarios">Usuários</a></li>
                        <li><a id="contratoAtivo" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorio" href="http://localhost:8080/ProjetoPIRentaCar/AcessoRelatorios">Relatórios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <table  class="lista" border="1" cellpadding="10">
                    <thead>
                        <tr>
                            <th>Contrato</th>
                            <th>Cliente</th>
                            <th>Data Retirada</th>
                            <th>Data Devolução</th>
                            <th>Diárias</th>
                            <th>Categoria</th>
                            <th>Valor Total</th>
                            <th>Data Abertura</th>
                            <th>Data Fechamento</th>
                            <th>Loja</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody id="itensTabela">
                        <c:forEach items="${lista}" var="contrato" varStatus="stat">
                        <tr>
                           <td> <a title="Clique para Inserir Pagamento" href="http://localhost:8080/ProjetoPIRentaCar/BuscarContratoPagamento?contrato=${contrato.contratoId}">
                                 <c:out value="${contrato.contratoId}" /></a></td>
                            <td> <c:out value="${contrato.nomeCliente}" /></td>
                            <td> <fmt:formatDate value="${contrato.dataRetirada}" pattern="dd/MM/yyyy"/> </td>
                            <td> <fmt:formatDate value="${contrato.dataDevolucao}" pattern="dd/MM/yyyy"/> </td>
                            <td> <c:out value="${contrato.quantidadeDiarias}" /></td>
                            <td> <c:out value="${contrato.categoria}" /></td>
                            <td> <c:out value="${contrato.totalReserva}" /></td>
                            <td> <fmt:formatDate value="${contrato.dataAbertura}" pattern="dd/MM/yyyy"/> </td>
                            <td> <fmt:formatDate value="${contrato.dataEncerramento}" pattern="dd/MM/yyyy"/> </td>
                            <td> <c:out value="${contrato.nomeFilial}" /></td>
                            <td> <c:choose>
                                    <c:when test="${contrato.aberto == true}">Aberto
                                    </c:when>
                                    <c:when test="${contrato.aberto == false}">Fechado
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    <tbody>
                </table>
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
        <script src="js/jscript.js" type="text/javascript"></script>
    </body>
</html>
