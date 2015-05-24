<%-- 
    Document   : AtualizarCliente
    Created on : 12/04/2015, 19:14:40
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
                        <li><a id="ativo" href="atualizarUsuario.jsp">Atualizar Usuário</a></li>
                        <li><a id="excluir" href="excluirUsuario.jsp">Excluir Usuário</a></li>
                        <li><a id="buscar" href="BuscarUsuarios">Lista de Usuários</a></li>

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
                <fieldset>
                    <legend>Atualizar Dados do Usuario</legend>
                    <form action="AtualizarUsuario" method="post">
                        <label>CPF Usuario </label><input type="text" maxlength="11" name="CPFUsuario">
                        <button type="submit" name="btPesquisa">Pesquisar </button>
                    </form>
                    <form id="atualizar" action="AtualizarUsuario" method="POST">
                        <table class="atualizar">
                            <tr><td id="label">ID:</td><td><input type="text" name="id" value="${usuario.usuarioId}"/></td></tr>
                            <tr><td id="label">Nome:</td><td><input type="text" name="nome" value="${usuario.nome}"/></td></tr>
                            <tr><td id="label">RG:</td><td><input type="text" name="rg" value="${usuario.rg}"/></td></tr>
                            <tr><td id="label">CPF:</td><td><input type="text" name="cpf" value="${usuario.cpf}"/></td></tr>
                            <tr><td id="label">Login:</td><td><input type="text" name="login" value="${usuario.login}"/></td></tr>
                            <tr><td id="label">Senha:</td><td><input type="text" name="senha" value="${usuario.senha}"/></td></tr>
                            <tr><td id="label">Cargo: </td><td><select name="cargo">
                                        <c:choose>
                                            <c:when test="${usuario.cargo == 0}">
                                                <option selected value="0">Atendente</option>
                                                <option value="1">Gerente</option>
                                                <option value="2">Diretor</option>
                                            </c:when>
                                            <c:when test="${usuario.cargo == 1}">
                                                <option value="0">Atendente</option>
                                                <option selected value="1">Gerente</option>
                                                <option value="2">Diretor</option>
                                            </c:when>
                                            <c:when test="${usuario.cargo == 2}">
                                                <option value="0">Atendente</option>
                                                <option value="1">Gerente</option>
                                                <option selected value="2">Diretor</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option>Cargo</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </select></td></tr>
                            <tr><td id="label">Filial: </td><td><select name="filial">
                                        <c:choose>
                                            <c:when test="${usuario.filial == 0}">
                                                <option selected value="0">São Paulo</option>
                                                <option value="1">Rio de Janeiro</option>
                                                <option value="2">Porto Alegre</option>
                                                <option value="3">Belo Horizonte</option>
                                            </c:when>
                                            <c:when test="${usuario.filial == 1}">
                                                <option value="0">São Paulo</option>
                                                <option selected value="1">Rio de Janeiro</option>
                                                <option value="2">Porto Alegre</option>
                                                <option value="3">Belo Horizonte</option>
                                            </c:when>
                                            <c:when test="${usuario.filial == 2}">
                                                <option value="0">São Paulo</option>
                                                <option value="1">Rio de Janeiro</option>
                                                <option selected value="2">Porto Alegre</option>
                                                <option value="3">Belo Horizonte</option>
                                            </c:when>
                                            <c:when test="${usuario.filial == 3}">
                                                <option  value="0">São Paulo</option>
                                                <option value="1">Rio de Janeiro</option>
                                                <option value="2">Porto Alegre</option>
                                                <option selected value="3">Belo Horizonte</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option>Loja</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select></td></tr>



                        </table>
                        <table class="radio">
                            <c:choose>
                                <c:when test="${usuario.ativo== true}">
                                    <tr><td id="radio"><input type="radio" value="TRUE" name="ativo" checked/></td><td id="label">Ativo</td></tr>
                                    <tr><td id="radio"><input type="radio" value="FALSE" name="ativo"/></td><td id="label">Inativo</td></tr>
                                        </c:when>
                                        <c:when test="${usuario.ativo== false}">
                                    <tr><td id="radio"><input type="radio" value="TRUE" name="ativo"/></td><td id="label">Ativo</td></tr>
                                    <tr><td id="radio"><input type="radio" value="FALSE" name="ativo" checked/></td><td id="label">Inativo</td></tr>                
                                        </c:when>
                                        <c:otherwise>
                                    <tr><td id="radio"><input disabled type="radio" name="ativo"/></td><td id="label">Ativo</td></tr>
                                    <tr><td id="radio"><input disabled type="radio" name="ativo"/></td><td id="label">Inativo</td></tr>
                                        </c:otherwise>
                                    </c:choose>
                        </table>
                        <div class="submeter"><input type="submit" value="Atualizar"></div>
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
        if(${erro == 'true'}){
                alert("ERRO!\n\CPF NÃO encontrado.\n\Tente novamente.");
            }
    </body>
</html>
