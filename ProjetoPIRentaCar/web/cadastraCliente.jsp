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
        <div id="container" style="border: 1px solid black; width: 500px;">
            <form action="InserirCliente" method="post">

                <table>
                    <tr><td>Nome:</td><td><input type="text" name="nome" /></td></tr>
                    <tr><td>RG:</td><td><input type="text" name="rg" /></td></tr>
                    <tr><td>CPF:</td><td><input type="text" name="cpf" /></td></tr>
                    <tr><td>CNH:</td><td><input type="text" name="cnh" /></td></tr>
                    <tr><td>Data Nasc.:</td><td><input type="date" name="dtNasc" /></td></tr>
                </table>
                <input type="submit" value="Cadastrar" name="submit"/>
            </form>
        </div>
        <a href="clientes.jsp">Voltar</a>
    </body>
</html>

