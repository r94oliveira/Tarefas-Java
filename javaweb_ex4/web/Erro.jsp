<%-- 
    Document   : Erro
    Created on : 23 de jul de 2022, 00:08:20
    Author     : robson.mariano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro JSP</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
        <%              
            
            String mensagem = "Não é permitido acessar.";
            
            if ((String)request.getAttribute("msg") != null){
                mensagem = (String)request.getAttribute("msg");
            }    
           
            String pagina = "index.html";
            if ((String)request.getAttribute("page") != null){
                pagina = (String)request.getAttribute("page");
            }
        %>

        <h1>Mensagem: <%=mensagem%></h1>
        
        <a href='<%=pagina%>'><button>Retornar a página pricipal</button></a>
        <br/><br/><br/><br/>
        <footer>Em caso de problemas contactar o administrador:        
        E-mail: <jsp:getProperty name="configuracao" property="email"/></footer>    
    </body>
</html>
