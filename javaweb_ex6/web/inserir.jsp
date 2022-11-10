<%-- 
    Document   : inserir
    Created on : 23 de jul de 2022, 00:08:44
    Author     : robson.mariano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir JSP</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
           
        <%  if(session.getAttribute("loginBean") != null){ %>
                <jsp:useBean id="loginBean" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>   
                <h2>Usuário logado: <jsp:getProperty name="loginBean" property="nomeUsuario" />  <%-- ${loginBean.nomeUsuario} --%> </h2>
            
                
                <form name='Formulario' action='CadastrarUsuarioServlet' method='post'>
                    Nome: <input type='text' name='nome' value='' /> <br/>
                    Login: <input type='text' name='login' value='' /> <br/>
                    Senha: <input type='password' name='senha' value='' /> <br/> 
                    
                    <button type='submit'>Salvar</button>
                </form><br/>

                <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean"
                scope="application" />
             
                <footer>E-mail: <jsp:getProperty name="configuracao" property="email" /> </footer>    
        <%  }else{ 
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro.jsp");
            
                request.setAttribute("msg", "Usuário não está logado.");

                request.setAttribute("page", "index.html");
                rd.forward(request, response);  
            } 
        %>             
    </body>
</html>
