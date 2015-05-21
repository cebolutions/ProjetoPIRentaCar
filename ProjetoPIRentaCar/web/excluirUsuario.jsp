<%-- 
    Document   : excluirUsuario
    Created on : 20/05/2015, 21:59:08
    Author     : pc
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
                        <li><a id="cadastra" href="cadastraUsuario.jsp">Cadastrar Usuário</a></li>
                        <li><a id="atualiza" href="atualizarUsuario.jsp">Atualizar Usuário</a></li>
                        <li><a id="ativo" href="excluirUsuario.jsp">Excluir Usuário</a></li>
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
                        <li><a id="usuariosAtivo" href="http://localhost:8080/ProjetoPIRentaCar/AcessoUsuarios">Usuários</a></li>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorio" href="http://localhost:8080/ProjetoPIRentaCar/AcessoRelatorios">Relatórios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <fieldset>
                    <legend>Excluir Usuario</legend>
                    <div class="msgsucesso"><p>${sucesso}</p></div>
                    <div class="msgerro"><p>${erro}</p></div>
                    <form action="ExcluirUsuario" method="post">
                        <label>CPF Usuario </label><input type="text" maxlength="11" name="CPFUsuario">
                        <button type="submit" name="btPesquisa">Pesquisar </button>
                    </form>
                    <form action="ExcluirUsuario" method="post">
                        <table class="consulta">
                            <tr><td id="label">ID:</td><td><input hidden name="id" value="${usuario.usuarioId}"><c:out value="${usuario.usuarioId}"/></td></tr>
                            <tr><td id="label">Nome:</td><td><c:out value="${usuario.nome}"/></td></tr>
                            <tr><td id="label">CPF:</td><td><c:out value="${usuario.cpf}"/></td></tr>
                            <tr><td id="label">Login:</td><td><c:out value="${usuario.login}"/></td></tr>

                        </table>

                        <div class="submeter"><input type="submit" value="Excluir"></div>
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