
<%-- Esta JSP recebe dois parâmetros no escopo da requisição: "msg" e "page". Apresenta
 a mensagem de erro passada como parâmetro (parâmetro de nome "msg") no request e um link para
 o recurso cujo nome também foi passado como parâmetro (parâmetro de nome "page").
 No rodapé da página deve ser colocada a seguinte mensagem: "Em caso de problemas contactar 
o administrador: " juntamente com o e-mail armazenado no escopo da aplicação.--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Erro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="jumbotron text-center">           
            <h1 style="color:tomato">${msg}</h1>
            ${pageContext.exception.message}
            ${pageContext.out.flush()}
            ${pageContext.exception.printStackTrace(pageContext.response.writer)}
            <br/>
            <a href="${page}">Retornar a página pricipal</a>
            <br/><br/><br/><br/>
        </div>
        <footer align='center'>Em caso de problemas contactar o administrador:        
        E-mail: ${configuracao.email}</footer>    
    </body>
</html>
