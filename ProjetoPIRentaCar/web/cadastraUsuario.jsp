<%-- 
    Document   : index
    Created on : 20/03/2015, 22:06:39
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <li><a id="ativo" href="cadastraUsuario.jsp">Cadastrar Usuário</a></li>
                        <li><a id="consulta" href="atualizarUsuario.jsp">Atualizar Usuário</a></li>
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
                    <legend>Cadastrar Usuário</legend>
                    <form action="InserirUsuario" method="post" name="usuario" id="usuario">
                        <table class="cadastroUsuario">
                            <tr><td id="label">Nome:</td><td id="input"><input required type="text" name="nome" id="nome"/></td></tr>
                            <tr><td id="label">RG:</td><td id="input"><input required type="text" name="rg" id="rg"/></td></tr>
                            <tr><td id="label">CPF:</td><td id="input"><input type="text" name="cpf" id="cpf" /></td></tr>
                            <tr><td id="label">Login:</td><td id="input"><input required type="text" name="login" /></td></tr>
                            <tr><td id="label">Senha:</td><td id="input"><input required type="text" name="senha" /></td></tr>
                            <tr><td id="label">Cargo: </td><td id="input"><select required name="cargo">
                                        <option value="">Escolha o cargo</option>
                                        <option value="0">Atendente</option>
                                        <option value="1">Gerente</option>
                                        <option value="2">Diretor</option>
                                    </select></td></tr>
                            <tr><td id="label">Filial: </td><td id="input"><select required name="filial">
                                        <option value="">Escolha a loja</option>
                                        <option value="0">São Paulo</option>
                                        <option value="1">Rio de Janeiro</option>
                                        <option value="2">Porto Alegre</option>
                                        <option value="3">Belo Horizonte</option>
                                    </select></td></tr>
                        </table>
                        <div class="submeter"><input type="button" value="Cadastrar" onClick="validar()"></div>
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

        <script src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
        <script type="text/javascript" src="js/jquery.inputmask.bundle.js"></script>
        <script type="text/javascript" src="js/mask.js"></script>
        <script type="text/javascript">
                            if (${erroLogin == 'true'}) {
                                alert("ERRO\n\Login já utilizado\n\Tente novamente")
                            }
                            if (${erroCpf == 'true'}) {
                                alert("ERRO\n\CPF já cadastrado\n\Tente novamente")
                            }


                            function validar() {
                                if (document.usuario.nome.value == "") {
                                    alert("Nome precisa ser informado!")
                                    document.usuario.nome.focus();
                                    return false;
                                }
                                if (document.usuario.rg.value == "") {
                                    alert("RG precisa ser informado!")
                                    document.usuario.rg.focus();
                                    return false;
                                }
                                var cpf = document.usuario.cpf.value.replace(/\D/g, "");
                                if (cpf.length != 11 ||
                                        cpf == "00000000000" ||
                                        cpf == "11111111111" ||
                                        cpf == "22222222222" ||
                                        cpf == "33333333333" ||
                                        cpf == "44444444444" ||
                                        cpf == "55555555555" ||
                                        cpf == "66666666666" ||
                                        cpf == "77777777777" ||
                                        cpf == "88888888888" ||
                                        cpf == "99999999999") {
                                    alert("CPF inválido!")
                                    document.usuario.cpf.focus();
                                    return false;
                                }
                                if (document.usuario.login.value == "") {
                                    alert("Login precisa ser informado!")
                                    document.usuario.login.focus();
                                    return false;
                                }
                                if (document.usuario.senha.value == "") {
                                    alert("Senha precisa ser informada!")
                                    document.usuario.senha.focus();
                                    return false;
                                }
                                if (document.usuario.cargo.value == "") {
                                    alert("Cargo precisa ser informado!")
                                    document.usuario.cargo.focus();
                                    return false;
                                }
                                if (document.usuario.filial.value == "") {
                                    alert("Filial precisa ser informada!")
                                    document.usuario.filial.focus();
                                    return false;
                                }
                                document.usuario.submit();
                            }

        </script>
    </body>
</html>

