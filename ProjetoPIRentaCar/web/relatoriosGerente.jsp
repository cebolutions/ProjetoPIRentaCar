<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <form action="buscaRelatorio" method="POST">
                        <table>
                            <tr><td><input type="radio" name="relatorio" value="0">Quantidade Veiculos</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="1">Veiculos por Usuários</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="3">Vendas por Usuário</td></tr>
                            <tr><td><label>Identificação Usuário:</label></td><td><input type="text" name="usuarioId"></td></tr>
                            
                            <tr><td><input type="radio" name="relatorio" value="4">Valor de Vendas por Usuários</td></tr>
                            <tr><td><label>Período: </label></td><td><input type="text" name="perInicial" placeholder="Inicio"></td><td><input type="text" name="perFinal" placeholder="Final"></td></tr>
                            <tr><td><input type="radio" name="relatorio" value="5">Quantidade Veiculos</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="6">Vendas por usuários (1sem)</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="7">Vendas por usuários (filial)</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="8">Vendas por Usuário</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="9">Qtd Veículos por filial</td></tr>
                            <tr><td><input type="radio" name="relatorio" value="10">Formas de pagamento</td></tr>
                            <tr><div class="submeter"><input type="submit" value="Buscar"></div></tr>

                        </table>
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
