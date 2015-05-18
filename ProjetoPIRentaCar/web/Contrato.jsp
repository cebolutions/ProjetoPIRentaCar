<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
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
                        <li><a id="ativo">Confirmar Contrato</a></li>

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
                <form id="contrato" action="CadastrarContrato" method="POST">
                    <input type="hidden" name="userLogado" value="${CPFlogado}">
                    <fieldset class="consultaEstoque">
                        <table>
                            <tr><td>Data Retirada </td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="dtRetirada" value="<fmt:formatDate value="${ret}" pattern="dd/MM/yyyy"/>"></td></tr>
                            <tr><td>Data Devolução </td><td><input type="text" readonly="readonly" title="Não é possível alterar" name="dtDevolucao" value="<fmt:formatDate value="${dev}" pattern="dd/MM/yyyy"/>"></td></tr>
                            <tr><td>Loja </td><td><select name="filial">
                                        <c:choose>
                                            <c:when test="${filial == 0}">
                                                <option selected value="0">São Paulo</option>
                                            </c:when>
                                            <c:when test="${filial == 1}">
                                                <option selected value="1">Rio de Janeiro</option>
                                            </c:when>
                                            <c:when test="${filial == 2}">
                                                <option selected value="2">Porto Alegre</option>
                                            </c:when>
                                            <c:when test="${filial == 3}">
                                                <option selected value="3">Belo Horizonte</option>
                                            </c:when>
                                        </c:choose>
                                    </select></td></tr>            
                            <tr><td>Diárias </td><td><input readonly="readonly" type="text" name="diarias" value="${diarias}"></td></tr>
                            <tr><td>Valor Total Reserva: R$</td><td><input readonly="readonly" type="text" name="valor" value="${valor}"></td></tr>
                            <tr><td>Veiculo Escolhido: </td><td><input type="hidden" name="veiculo" value="${veiculo.idVeiculo}"/><input id="veiculo" readonly="readonly" value="${veiculo.categoria} - ${veiculo.marca} ${veiculo.nomeVeiculo}"></tr>
                            <tr><td>Id:</td><td><input readonly="readonly" title="Não é possível alterar" type="text" name="id" value="${cliente.clienteId}"></td></tr>
                            <tr><td>Nome:</td><td><input readonly="readonly" name="nome" value="${cliente.nome}"></td></tr>
                            <tr><td>CPF:</td><td><input readonly="readonly" name="cpf" value="${cliente.cpf}"></td></tr>

                        </table>
                        <div class="submeter"><input type="submit" value="Finalizar"></div>
                    </fieldset>
                            <div class="opcao"><a href="Contrato_1.jsp">Alterar Contrato</a></div>
                </form>
                            
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
