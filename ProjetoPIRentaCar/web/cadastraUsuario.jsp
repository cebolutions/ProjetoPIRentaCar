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
                        <li><a id="ativo" href="cadastraUsuario.jsp">Cadastrar Usuário</a></li>
                        <li><a id="consulta" href="atualizarUsuario.jsp">Atualizar Usuário</a></li>
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
                    <form action="InserirUsuario" method="post">
                        <fieldset>
                            <legend>Cadastrar Usuário</legend>
                            <table class="cadastroUsuario">
                                <tr><td id="label">Nome:</td><td id="input"><input required type="text" name="nome" /></td></tr>
                                <tr><td id="label">RG:</td><td id="input"><input required type="text" name="rg" /></td></tr>
                                <tr><td id="label">CPF:</td><td id="input"><input required maxlength="11" type="text" name="cpf" /></td></tr>
                                <tr><td id="label">Login:</td><td id="input"><input required type="text" name="login" /></td></tr>
                                <tr><td id="label">Senha:</td><td id="input"><input required type="text" name="senha" /></td></tr>
                                <tr><td id="label">Cargo: </td><td id="input"><select required name="cargo">
                                            <option>Escolha o cargo</option>
                                            <option value="0">Atendente</option>
                                            <option value="1">Gerente</option>
                                            <option value="2">Diretor</option>
                                        </select></td></tr>
                                <tr><td id="label">Filial: </td><td id="input"><select required name="filial">
                                            <option>Escolha a loja</option>
                                            <option value="0">São Paulo</option>
                                            <option value="1">Rio de Janeiro</option>
                                            <option value="2">Porto Alegre</option>
                                            <option value="3">Belo Horizonte</option>
                                        </select></td></tr>
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

