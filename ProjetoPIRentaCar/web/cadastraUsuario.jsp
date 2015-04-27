<%-- 
    Document   : index
    Created on : 20/03/2015, 22:06:39
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Cliente </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="container" style="width: 500px;">
            <form action="InserirUsuario" method="post">
                <fieldset>
                <legend>Cadastrar Usuário</legend>
                <table>
                    <tr><td>Nome:</td><td><input type="text" name="nome" /></td></tr>
                    <tr><td>RG:</td><td><input type="text" name="rg" /></td></tr>
                    <tr><td>CPF:</td><td><input type="text" name="cpf" /></td></tr>
                    <tr><td>Login:</td><td><input type="text" name="login" /></td></tr>
                    <tr><td>Senha:</td><td><input type="text" name="senha" /></td></tr>
                    <tr><td>Cargo: </td><td><select name="cargo">
                                <option>Escolha o cargo</option>
                                <option value="0">Atendente</option>
                                <option value="1">Gerente</option>
                                <option value="2">Diretor</option>
                            </select></td></tr>
                    <tr><td>Filial: </td><td><select name="filial">
                                <option>Escolha a loja</option>
                                <option value="0">São Paulo</option>
                                <option value="1">Rio de Janeiro</option>
                                <option value="2">Porto Alegre</option>
                                <option value="3">Belo Horizonte</option>
                            </select></td></tr>
                </table>
                <input type="submit" value="Cadastrar" name="submit"/>
                </fieldset>
            </form>
        </div>
        <a href="usuarios.jsp">Voltar</a>
    </body>
</html>

