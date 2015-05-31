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
                        <li><a id="ativo">Diretoria</a></li>
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
                        <li><a id="usuarios" href="AcessoUsuarios">Usuários</a></li>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li><a id="relatorioAtivo" href="AcessoRelatorios">Relatórios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <fieldset class="frel"><legend>Buscar Relatório</legend>

                    <table class="lista" border="1" cellpadding="10">
                        <c:choose>
                            <c:when test="${rel == 6}">
                                <tr>
                                    <td></td>
                                    <th scope="col">Quantidade Veículos</th>
                                </tr>
                                <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                                    <tr>
                                        <th scope="row"> <c:out value="${rel.nomeLoja}" /> </th>
                                        <td> <c:out value="${rel.qtdVeiculo}" /> </td>

                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:when test="${rel == 7}">
                                <tr>
                                    <td></td>
                                    <th scope="col">Total Vendas (R$)</th>
                                </tr>
                                <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                                    <tr>
                                        <th scope="row"> <c:out value="${rel.nomeLoja}" /> </th>
                                        <td> <c:out value="${rel.totalVendas}" /></td>

                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:when test="${rel == 8}">
                                <tr>
                                    <th>Nome Usuário</th>
                                    <th>Log</th>
                                    <th>Data Log</th>
                                    <th>Hora Log</th>

                                </tr>
                                <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                                    <tr>
                                        <td> <c:out value="${rel.nomeUsuario}" /></td>
                                        <td> <c:out value="${rel.tipoLog}" /> </td>
                                        <td> <fmt:formatDate value="${rel.dataLog}" pattern="dd/MM/yyyy"/> </td>
                                        <td> <fmt:formatDate type="time" value="${rel.horaLog}"/> </td> 
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </table>
                    <div class="opcao"><a href="AcessoRelatorios">Nova Busca</a></div>
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
        <script type="text/javascript" src="http://filamentgroup.github.com/EnhanceJS/enhance.js"></script>
        <script type="text/javascript">
            if (${rel != 8}) {
    

            // Run capabilities test
            enhance({
                loadScripts: [
                    {src: 'js/excanvas.js', iecondition: 'all'},
                    'js/jquery.js',
                    'js/visualize.jQuery.js',
                    'js/example.js'
                ],
                loadStyles: [
                    'css/visualize.css',
                    'css/visualize-light.css'
                ]
            });
            }
        </script>
    </body>
</html>
