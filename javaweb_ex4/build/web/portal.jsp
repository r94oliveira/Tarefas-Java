<%-- 
    Document   : portal
    Created on : 23 de jul de 2022, 00:08:52
    Author     : robson.mariano
--%>

<%@page import="com.ufpr.tads.web2.dao.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ufpr.tads.web2.beans.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
               
        <%  if(session.getAttribute("loginBean") != null){ %>
                <jsp:useBean id="loginBean" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>   
                <h2>Usuário logado: <jsp:getProperty name="loginBean" property="nomeUsuario" />  <%-- ${loginBean.nomeUsuario} --%> </h2>
                <a href="inserir.jsp"><button>Inserir</button></a> <br/>
                <a href="LogoutServlet"><button>Logout</button></a>  
                <br/>
                
                <table border='1'>
		 <tr>
                    <th>Nome</th>
                    <th>Login</th>
                    <th>Senha</th>
		 </tr>

                <% List<Usuario> usuarios = new ArrayList<Usuario>();
                UsuarioDAO userDAO = new UsuarioDAO();
                usuarios = userDAO.selectAll();
                
                for(Usuario usuario : usuarios){ %>
                    <tr>
                        <td>
                            <%=usuario.getNome()%>
                        </td>

                        <td>
                            <%=usuario.getLogin()%>
                        </td>

                        <td>
                            <%=usuario.getSenha()%>
                        </td>
                    </tr>
                <%} %>                       
                </table>
                
                <jsp:useBean id="configuracao" class="com.ufpr.tads.web2.beans.ConfigBean"
                scope="application" />
                <br/>
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
