<%-- 
    Document   : cadastrarContrato
    Created on : 11/04/2015, 12:08:23
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="projetorentacar.Cliente" %>
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
                        <li><a id="ativo" href="Contrato_1.jsp">Consultar Estoque</a></li>
                        <li><a id="veiculo" href="Contrato_2.jsp">Escolher Veiculo</a></li>
                        <li><a id="atualiza" href="Contrato_3.jsp">Selecionar Cliente</a></li>
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
                <form action="Disponibilidade" method="POST">
                    <fieldset class="consultaEstoque">
                        <table>
                            <tr><td>Data Retirada: </td><td><input type="text" placeholder="dd/mm/aaaa" name="dtRetirada"></td>
                                <td id="dev">Data Devolução: </td><td><input type="text" placeholder="dd/mm/aaaa" name="dtDevolucao"></td></tr>
                            <tr><td id="loja">Loja: </td><td><select name="filial">
                                        <option>Escolha a loja</option>
                                        <option value="0">São Paulo</option>
                                        <option value="1">Rio de Janeiro</option>
                                        <option value="2">Porto Alegre</option>
                                        <option value="3">Belo Horizonte</option>
                                    </select></td></tr>
                        </table>
                        <div class="submeter"><input type="submit" value="Avançar"></div>
                    </fieldset>
                    <fieldset class="disponibilidadeInativo">
                        <h4>Disponibilidade</h4>
                    </fieldset>
                    <fieldset class="clienteInativo">
                        <h4>Dados do Cliente</h4>
                    </fieldset>
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
