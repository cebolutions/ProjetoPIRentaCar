
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="shortcut icon" href="img/favicon.PNG" type="image/x-icon"/>
        <title>Cebolutions Rent a Car</title>
    <body>
    <main>
        <form action="ValidarLogin" method="POST" name="fLogin">
            <div class="msgerro"><p>${erro}</p></div>
            <table border="0">
                    <tr><td>Login</td><td><input type="text" name="login" required/></td></tr>
                    <tr><td>Senha</td><td><input type="password" name="senha" required/></td></tr>
                    
            </table>
            <div class="submeter"><input type="submit" value="Entrar"></div>
        </form>
    </main>
    </body>
</html>
