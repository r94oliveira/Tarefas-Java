<%-- 
    Document   : clientesAlterar
    Created on : 31 de jul de 2022, 00:08:20
    Author     : robson.mariano
--%>
<%@page import="com.ufpr.tads.web2.dao.ClienteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <link rel="stylesheet" href="style.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
        
        <title>Lista de Clientes</title>
    </head>
    <body>
        <%-- Obtem o objeto LoginBean da sessão usando jsp:useBean --%>        
        <%if(session.getAttribute("loginBean") != null){ %>
            <%--MENU--%>                
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="./portal.jsp">Portal</a>
                </li>
                <li class="nav-item active">
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

            <h4 align='center'>Usuário logado: ${loginBean.nomeUsuario}</h4>
            <br/>
            
            <div align="center">
                <form name="Novo" action="ClientesServlet?action=formNew" method="post">
                    <input type="submit" class="btn btn-success" value="Novo">
                </form>
            </div>
            <br>
            
            <%--inicia a lista/Cabeçalho--%>
            <table class='table mx-auto w-auto'>
                <thead class="thead-dark">
                    <tr>
                       <th scope="col">CPF</th>
                       <th scope="col">Nome</th>
                       <th scope="col">E-mail</th>
                       <th scope="col">Ações</th>
                    </tr>
                </thead>

                <c:forEach items="${listaClientes}" var="cliente"> 
                    <tr>
                        <td>
                            ${cliente.cpf_cliente}
                        </td>

                        <td>
                            ${cliente.nome_cliente}
                        </td>

                        <td>
                            <%--<%=cliente.getEmail_cliente()%>--%>
                            ${cliente.email_cliente}
                        </td>                            

                        <%-- icones de ação --%>
                        <td>       
                            <%--<a href="./ClientesServlet?id=<%=cliente.getId_cliente()%>"><i class="bi bi-search"></i></a>--%>
                            <a href="./ClientesServlet?action=show&id=${cliente.id_cliente}"><i class="bi bi-search"></i></a>
                            <a href="./ClientesServlet?action=formUpdate&id=${cliente.id_cliente}"><i class="bi bi-pencil"></i></a>
                            <a href="./ClientesServlet?action=remove&id=${cliente.id_cliente}"><i class="bi bi-trash"></i></a>
                        </td> 
                    </tr>
                    
                    <script language=javascript>
                        function confirmarExclusao(){
                            if (confirm("Você realmente deseja excluir este cliente?"))
                                window.location = "./ClientesServlet?action=remove&id=${cliente.id_cliente}";
                        }
                    </script>
                </c:forEach>                          
            </table>

            <br/>
            <footer align="center">Em caso de problemas contactar o administrador:        
            E-mail: ${configuracao.email}</footer>   
        <%}else{ 
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");

            request.setAttribute("page", "index.jsp");
            rd.forward(request, response);  
        } 
       %> 
      
    </body>
</html>