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
                        <li><a id="cadastra" href="cadastraUsuario.jsp">Cadastrar Usuário</a></li>
                        <li><a id="consulta" href="atualizarUsuario.jsp">Atualizar Usuário</a></li>
                        <li><a id="excluir" href="excluirUsuario.jsp">Excluir Usuário</a></li>
                        <li><a id="ativo" href="BuscarUsuarios">Lista de Usuários</a></li>

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
                        <li><a id="usuariosAtivo" href="AcessoUsuarios">Usuários</a></li>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorio" href="AcessoRelatorios">Relatórios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
        <table class="lista" border="1" cellpadding="10">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>RG</th>
                <th>CPF</th>
                <th>login</th>
                <th>Cargo</th>
                <th>Filial</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${lista}" var="user" varStatus="stat">
                <tr>
                    <td><c:out value="${user.usuarioId}" /></td>
                    <td> <c:out value="${user.nome}" /> </td>
                    <td> <c:out value="${user.rg}" /> </td>
                    <td> 
                        <a title="Clique para alterar" href="AtualizarUsuario?cpf=${user.cpf}">
                            <c:out value="${user.cpf}"/>
                        </a>
                    </td>
                    <td> <c:out value="${user.login}" /> </td>
                    <td> <c:choose>
                            <c:when test="${user.cargo == 0}">Atendente</c:when>
                            <c:when test="${user.cargo == 1}">Gerente</c:when>
                            <c:when test="${user.cargo == 2}">Diretor</c:when>
                        </c:choose></td>
                    <td> <c:choose>
                            <c:when test="${user.filial == 0}">São Paulo</c:when>
                            <c:when test="${user.filial == 1}">Rio de Janeiro</c:when>
                            <c:when test="${user.filial == 2}">Porto Alegre</c:when>
                            <c:when test="${user.filial == 3}">Belo Horizonte</c:when>
                        </c:choose></td>
                    <td> <c:choose>
                            <c:when test="${user.ativo== true}">Ativo</c:when>
                            <c:when test="${user.ativo== false}">Inativo</c:when>
                        </c:choose></td>
                </tr>
            </c:forEach>
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
        <script src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
        <script type="text/javascript" src="js/jquery.inputmask.bundle.js"></script>
        <script type="text/javascript" src="js/mask.js"></script>
    </body>
</html>
