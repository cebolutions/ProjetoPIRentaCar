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
        <title>Cadastrar Contrato</title>
    </head>
    <body>
        
        <form action="Disponibilidade" method="POST">
            <fieldset>
                <legend>Reserva</legend>
                <table>
                    <tr><td>Data Retirada </td><td><input type="text" name="dtRetirada"></td>
                        <td>Data Devolução </td><td><input type="text" name="dtDevolucao"></td></tr>
                    <tr><td>Loja </td><td><select name="filial">
                                <option>Escolha a loja</option>
                                <option value="0">São Paulo</option>
                                <option value="1">Rio de Janeiro</option>
                                <option value="2">Porto Alegre</option>
                                <option value="3">Belo Horizonte</option>
                            </select></td></tr>
                    
                    <tr><td><button type="submit" name="btVerifica">Avançar</button></td></tr>

                </table>
            </fieldset>
            <fieldset>
                <legend>Disponibilidade</legend>
                <h4>Disponibilidade</h4>
            </fieldset>
            <fieldset>
                <legend>Cliente</legend>
                <h4>Dados do Cliente</h4>
            </fieldset>
            
            <h2>1</h2>
        </form>
    </body>
</html>
