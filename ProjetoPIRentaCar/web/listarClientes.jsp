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
                        <li><a id="cadastro" href="cadastraCliente.jsp">Cadastrar Cliente</a></li>
                        <li><a id="consulta" href="consultaCliente.jsp">Consultar Cliente</a></li>
                        <li><a id="atualizar" href="atualizarCliente.jsp">Atualizar Cliente</a></li>
                        <li><a id="ativo" href="http://localhost:8080/ProjetoPIRentaCar/BuscarClientes">Lista de Clientes</a></li>

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
                <table class="lista" border="1" cellpadding="10">
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>RG</th>
                        <th>CPF</th>
                        <th>CNH</th>
                        <th>Data Nascimento</th>
                        <th>Data Cadastro</th>
                    </tr>
                    <c:forEach items="${lista}" var="cliente" varStatus="stat">
                        <tr>
                            <td> <c:out value="${cliente.clienteId}" /></td>
                            <td> <c:out value="${cliente.nome}" /> </td>
                            <td> <c:out value="${cliente.rg}" /> </td>
                            <td> 
                                <a title="Clique para alterar" href="http://localhost:8080/ProjetoPIRentaCar/AtualizarCliente?cpf=${cliente.cpf}">
                                    <c:out value="${cliente.cpf}" />
                                </a> </td>
                            <td> <c:out value="${cliente.cnh}" /> </td>
                            <td> <fmt:formatDate value="${cliente.dataNascimento}" pattern="dd/MM/yyyy"/> </td>
                            <td> <fmt:formatDate value="${cliente.dataCadastro}" pattern="dd/MM/yyyy"/> </td>
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
    </body>
</html>
