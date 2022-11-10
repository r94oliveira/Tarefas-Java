<%-- 
    Document   : index
    Created on : 31 de jul de 2022, 00:014:30
    Author     : robson.mariano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Página Principal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="jumbotron text-center">
            <h1 style="color:black;">Bem-vindo ao meu sistema!</h1>
            <p> <%

                String mensagem = "";
                if ((String) request.getAttribute("msg") != null) {
                    mensagem = (String) request.getAttribute("msg");%>
            <h3 style="color:Tomato;"><%=mensagem%></h3>
            <% }
                         %>           
            <form name="Formulario" action="LoginServlet" method="post">

                <div class="container">
                    <label for="login"><b>Login</b></label>
                    <input type="text" placeholder="Digite seu login" name="login" required>

                    <label for="senha"><b>Senha</b></label>
                    <input type="password" placeholder="Digite a sua senha" name="senha" required>

                    <button type="submit">Logar</button>

                </div>


            </form>
        </p> 
    </div>






    <br/>
    <footer align="center">Em caso de problemas contactar o administrador:        
        E-mail: <jsp:getProperty name="configuracao" property="email"/></footer> 
</body>
</html>
