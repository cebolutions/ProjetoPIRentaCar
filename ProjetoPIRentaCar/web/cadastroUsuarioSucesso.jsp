<%-- 
    Document   : cadastroSucesso
    Created on : 16/04/2015, 21:06:15
    Author     : ygor.yppessoa
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <li><a id="cadastro" href="cadastraUsuario.jsp">Cadastrar Usuário</a></li>
                        <li><a id="ativo" href="atualizarUsuario.jsp">Atualizar Usuário</a></li>
                        <li><a id="buscar" href="http://localhost:8080/ProjetoPIRentaCar/BuscarUsuarios">Lista de Usuários</a></li>

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
                        <li><a id="usuariosAtivo" href="usuarios.jsp">Usuários</a></li>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorio" href="Relatorios.jsp">Relatòrios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <fieldset>
                    <div class="msgsucesso"><p>Cadastro Realizado com sucesso!!!</p></div>
                    <table class="consulta">
                        <tr><td>ID:</td><td><c:out value="${usuario.usuarioId}"/></td></tr>
                        <tr><td>Nome:</td><td><c:out value="${usuario.nome}"/></td></tr>
                        <tr><td>RG:</td><td><c:out value="${usuario.rg}"/></td></tr>
                        <tr><td>CPF:</td><td><c:out value="${usuario.cpf}"/></td></tr>
                        <tr><td>Login:</td><td><c:out value="${usuario.login}"/></td></tr>
                        <tr><td>Senha:</td><td><c:out value="${usuario.senha}"/></td></tr>
                        <tr><td>Cargo: </td><td>
                                <c:choose>
                                    <c:when test="${usuario.cargo == 0}"><c:out value="Atendente"/></c:when>
                                    <c:when test="${usuario.cargo == 1}"><c:out value="Gerente"/></c:when>
                                    <c:when test="${usuario.cargo == 2}"><c:out value="Diretor"/></c:when>
                                </c:choose></td></tr>
                        <tr><td>Filial: </td><td> 
                                <c:choose>
                                    <c:when test="${usuario.filial == 0}"><c:out value="São Paulo"/></c:when>
                                    <c:when test="${usuario.filial == 1}"><c:out value="Rio de Janeiro"/></c:when>
                                    <c:when test="${usuario.filial == 2}"><c:out value="Porto Alegre"/></c:when>
                                    <c:when test="${usuario.filial == 3}"><c:out value="Belo Horizonte"/></c:when>
                                </c:choose></td></tr>
                        <tr><td>Status: </td><td> 
                                <c:choose>
                                    <c:when test="${usuario.ativo== true}"><c:out value="Ativo"/></c:when>
                                    <c:when test="${usuario.ativo== false}"><c:out value="Inativo"/></c:when>
                                </c:choose></td></tr>
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
