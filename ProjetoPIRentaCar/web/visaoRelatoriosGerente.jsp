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
                        <li><a id="ativo">Gerência</a></li>
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
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorioAtivo" href="http://localhost:8080/ProjetoPIRentaCar/AcessoRelatorios">Relatórios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <fieldset><legend>Buscar Relatório</legend>

                    <table class="lista" border="1" cellpadding="10">
                        <c:choose>
                            <c:when test="${rel == 1}">
                                <tr>
                                    <th>Nome Usuário</th>
                                    <th>Quantidade Veículos</th>
                                    <th>Nome Veículo</th>
                                </tr>
                                <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                                    <tr>
                                        <td> <c:out value="${rel.nomeUsuario}" /></td>
                                        <td> <c:out value="${rel.qtdVeiculo}" /> </td>
                                        <td> <c:out value="${rel.nomeVeiculo}" /> </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:when test="${rel == 2}">
                                <tr>
                                    <th>Nome Usuário</th>
                                    <th>Quantidade Veículos</th>
                                </tr>
                                <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                                    <tr>
                                        <td> <c:out value="${rel.nomeUsuario}" /></td>
                                        <td> <c:out value="${rel.qtdVeiculo}" /> </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:when test="${rel == 3}">
                                <tr>
                                    <th>Nome Usuário</th>
                                    <th>Quantidade Veículos</th>
                                </tr>
                                <tr>
                                    <td> <c:out value="${relatorio.nomeUsuario}" /></td>
                                    <td> <c:out value="${relatorio.qtdVeiculo}" /> </td>
                                </tr>
                            </c:when>
                            <c:when test="${rel == 4}">
                                <tr>
                                    <th>Nome Usuário</th>
                                    <th>Total Vendas</th>
                                </tr>
                                <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                                    <tr>
                                        <td> <c:out value="${rel.nomeUsuario}" /></td>
                                        <td> <c:out value="${rel.totalVendas}" /> </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </table>
                    <div class="opcao"><a href="http://localhost:8080/ProjetoPIRentaCar/AcessoRelatorios">Nova Busca</a></div>
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
