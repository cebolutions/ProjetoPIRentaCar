
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
        <div id="login">
            <img src="img/logo2.PNG" alt="logo2"/>

            <form action="ValidarLogin" method="POST" name="fLogin">
                <table id="log">
                    <tr><td></td><td><div class="msgerro"><p>${erro}</p></div></td></tr>
                    <tr><td>Login</td><td><input required type="text" name="login"></td></tr>
                    <tr><td>Senha</td><td><input required type="password" name="senha"></td></tr>

                </table>
                <div class="submeter"><input type="submit" value="Entrar"></div>
            </form>
        </div>
</body>
</html>
