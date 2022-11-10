<%-- 
    Document   : newjsp
    Created on : 30 de jun de 2022, 02:03:22
    Author     : robson.mariano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <title>JSP Page</title>

    </head>
    <body>

        <%-- Cabecalho com logo e curso --%> 
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <p class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <img src="img/septufpr.png" class="bi me-2" width="60" height="42" alt="SEPT UUPR">
                    <span class="fs-4">TADS - Tecnologia em Análise e Desenvolvimento de Sistemas</span>
                </p>

            </header>
        </div>

        <%-- Tabela com rede social --%>      
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Rede Social</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Robson Mariano Euzébio de Oliveira</td>
                    <td><a href='https://www.instagram.com/r94oliveira/'>Instagram</a></td>
                </tr> 
                <tr>
                    <td>Katiana Mara Zeitz</td>
                    <td><a href='https://www.instagram.com/obsk.aventurin/'>Instagram</a></td>
                </tr> 
                <tr>
                    <td>Rafael prestes Tombolato</td>
                    <td><a href='https://www.instagram.com/obsk.aventurin/'>Instagram</a></td>
                </tr> 
                <tr>
                    <td>Rafael Soares de Paula Filho</td>
                    <td><a href='https://www.instagram.com/obsk.aventurin/'>Instagram</a></td>
                </tr> 
                <tr>
                    <td>Janaína Keroline Ercole</td>
                    <td><a href='https://www.instagram.com/obsk.aventurin/'>Instagram</a></td>
                </tr>             
            </tbody> 
        </table>

        <%-- Link voltar --%> 
        <a href='http://localhost:8080/WebApplication1/NewServlet' class="btn btn-dark">Voltar</a>


    </body>
</html>
