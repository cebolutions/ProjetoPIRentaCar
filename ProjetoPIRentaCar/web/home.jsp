<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
        </header>

        <div class="container destaque">
            <section class="menu-opcoes">
                <h2>opções</h2>
                <nav class>
                    <ul>
                        <li><a id="inicioAtivo" href="home.jsp">Inicio</a></li>
                        <li><a id="clientes" href="clientes.jsp">Clientes</a><br></li>
                        <li id="usuarioMenu"><a id="usuarios" href="AcessoUsuarios">Usuários</a></li>
                        <li><a id="contrato" href="Contrato_1.jsp">Contrato</a></li>
                        <li><a id="pagamento" href="Pagamento.jsp">Pagamento</a></li>
                        <li id="relMenu"><a id="relatorio" href="AcessoRelatorios">Relatórios</a></li>
                        <li><a id="logout" href="login.jsp">Logout</a></li>
                    </ul>
                </nav>
            </section><!-- fim .menu-opcoes -->
            <main>
                <div class="msgsucesso"><p>${erro}</p></div>
                <table class="icons">
                    <tr>
                        <td><a href="clientes.jsp"><img src="img/cliente.png" width="140" height="140" /></a></td>
                        <td id="usuarioIcon"><a href="AcessoUsuarios"><img src="img/user.png" width="140" height="140" /></a></td>
                        <td><a href="Contrato_1.jsp"><img src="img/car.png" width="140" height="140" /></a></td>
                    </tr>
                    <tr>
                        <td><a href="Pagamento.jsp"><img src="img/money.png" width="140" height="140" /></a></td>
                        <td id="relIcon"><a href="AcessoRelatorios"><img src="img/relatorio.png"  width="140" height="140" /></a></td>
                        <td><a href="login.jsp"><img src="img/exit.png" width="140" height="140" /></a></td>
                    </tr>
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
        <script type="text/javascript">
             
            if('<%=request.getSession().getAttribute("cargo")%>' == 0){
                document.getElementById("usuarioMenu").style.display = 'none';
                document.getElementById("usuarioIcon").style.display = 'none';
                document.getElementById("relMenu").style.display = 'none';
                document.getElementById("relIcon").style.display = 'none';
                
            }
                
        </script>
    </body>
</html>
