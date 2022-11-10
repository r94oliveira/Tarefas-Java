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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>Portal</title>
    </head>
    <body>    
              
        <%-- Obtem o objeto LoginBean da sessão usando jsp:useBean --%>        
        <%  if(session.getAttribute("loginBean") != null){ %> 
        
                <%--MENU--%>                
                <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                  <ul class="navbar-nav">
                    <li class="nav-item active">
                      <a class="nav-link" href="./portal.jsp">Portal</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./ClientesServlet?action=list">Cadastro de Clientes</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./inserir.jsp">Cadastro de Usuários</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="./LogoutServlet">Sair</a>
                    </li>
                  </ul>
                </nav>

                
                <h4 align='center'>Usuário logado: ${loginBean.nomeUsuario} </h4>
                <br/><br/>
                
		<%--inicia a lista/Cabeçalho--%>
                <table class='table mx-auto w-auto'>
                     <thead class="thead-dark">
                        <tr>
                           <th scope='col'>Nome</th>
                           <th scope='col'>Login</th>
                           <th scope='col'>Senha</th>
                        </tr>
                     </thead>

                    <%-- imprime tabela com usuarios cadastrados no BD --%>
                    <% List<Usuario> usuarios = new ArrayList<Usuario>();
                    UsuarioDAO userDAO = new UsuarioDAO();
                    usuarios = userDAO.selectAll();

                    for(Usuario usuario : usuarios){ %>
                        <tr>
                            <td>
                                <%=usuario.getNome_usuario()%>
                            </td>

                            <td>
                                <%=usuario.getLogin_usuario()%>
                            </td>

                            <td>
                                <%=usuario.getSenha_usuario()%>
                            </td>
                        </tr>
                    <%} %>                       
                </table>                
                
                <br/>
                <footer align="center">Em caso de problemas contactar o administrador:        
                E-mail: ${configuracao.email} </footer>   
        <%  }else{ 
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            
                request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");

                request.setAttribute("page", "index.jsp");
                rd.forward(request, response);  
            } 
        %>    
    </body>
</html>
