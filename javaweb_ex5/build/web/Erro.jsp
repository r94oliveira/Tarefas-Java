<%-- 
    Document   : Erro
    Created on : 31 de jul de 2022, 00:08:20
    Author     : robson.mariano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro JSP</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="jumbotron text-center">
            <%              
              
                String mensagem = "Não é permitido acessar!";
              
                if ((String)request.getAttribute("msg") != null){
                    mensagem = (String)request.getAttribute("msg");
                }    
          
                String pagina = "index.jsp";
                if ((String)request.getAttribute("page") != null){
                    pagina = (String)request.getAttribute("page");
                }
                %>

            <h1 style="color:tomato"><%=mensagem%></h1>
            
            <a href='<%=pagina%>'>Retornar a página pricipal</a>
        <br/></div>
        <footer align='center'>Em caso de problemas contactar o administrador:        
        E-mail: <jsp:getProperty name="configuracao" property="email"/></footer>    
    </body>
</html>
