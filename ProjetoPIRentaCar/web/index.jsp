<%-- 
    Document   : index
    Created on : 20/03/2015, 22:06:39
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="container" style="border: 1px solid black; width: 500px;">
            <form action="page1.jsp" method="post">

                <table>
                    <tr><td>Nome</td><td><input type="text" name="nome" /></td></tr>
                    <tr><td>SobreNome</td><td><input type="text" name="sobrenome" /></td></tr>
                    <tr><td>CPF:</td><td><input type="text" name="CPF" /></td></tr>
                    <tr><td>Endereço</td><td><input type="text" name="endereco" /></td></tr>
                </table>
                <input type="submit" value="Ingressar"/>
            </form>
        </div>
    </body>
</html>

