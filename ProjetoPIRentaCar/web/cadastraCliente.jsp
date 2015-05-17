<%-- 
    Document   : index
    Created on : 20/03/2015, 22:06:39
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="shortcut icon" href="img/favicon.PNG" type="image/x-icon"/>
        <script src ="js/mask.js" type="text/javascript"></script>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="js/jquery.maskedinput.js" type="text/javascript"></script>
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
                        <li><a id="ativo" href="cadastraCliente.jsp">Cadastrar Cliente</a></li>
                        <li><a id="consulta" href="consultaCliente.jsp">Consultar Cliente</a></li>
                        <li><a id="atualiza" href="atualizarCliente.jsp">Atualizar Cliente</a></li>
                        <li><a id="buscar" href="http://localhost:8080/ProjetoPIRentaCar/BuscarClientes">Lista de Clientes</a></li>

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
                        <li><a id="clientesAtivo" href="clientes.jsp">Clientes</a><br></li>
                        <li><a id="usuarios" href="usuarios.jsp">Usuários</a></li>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorio" href="Relatorios.jsp">Relatòrios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <form action="InserirCliente" method="post">
                    <fieldset>
                        <legend>Cadastro de Cliente</legend>
                        <form action="InserirCliente" method="post">
                            <table class="cadastro">
                                <tr><td>Nome:</td><td><input required type="text" name="nome" id="nome"/></td></tr>
                                <tr><td>RG:</td><td><input required type="text" name="rg" id="rg"/></td></tr>
                                <tr><td>CPF:</td><td><input required type="text" maxlength="11" name="cpf" id="cpf" /></td></tr>
                                <tr><td>CNH:</td><td><input required type="text" name="cnh" id="cnh"/></td></tr>
                                <tr><td>Data Nasc.:</td><td><input required placeholder="dd/mm/aaaa" type="text" name="dtNasc" id="dtNasc"/></td></tr>
                            </table>
                            <div class="submeter"><input type="submit" value="Cadastrar"></div>
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

