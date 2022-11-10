<%-- 
    Document   : clientesAlterar
    Created on : 31 de jul de 2022, 00:08:20
    Author     : robson.mariano
--%>

<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            
            <h4 align='center'>Alterar Cliente</h4>
            
            <%-- Imprime um formulário com todas os dados do Cliente --%>
            <div align="center">
                <form name = "AlterarCliente" action="ClientesServlet?action=update" method="post">
                    <table class='table mx-auto w-auto'>
                        <thead class="thead-dark">
                            <tr>
                               <th scope="col">Atributo</th>
                               <th scope="col">Valor</th>
                            </tr>
                        </thead>
                            <tr>
                                <td>
                                    ID
                                </td>
                                <td>
                                    <input type="text" name="id" readonly="true" value="${cliente.id_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CPF
                                </td>
                                <td>
                                   <input type="text" name="CPF" value="${cliente.cpf_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Nome
                                </td>
                                <td>
                                   <input type="text" name="Nome" value="${cliente.nome_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    E-mail
                                </td>
                                <td>
                                   <input type="text" name="Email" value="${cliente.email_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Data
                                </td>
                                <td>
                                   <input type="text" name="Data" value="${cliente.data_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Rua
                                </td>
                                <td>
                                   <input type="text" name="Rua" value="${cliente.rua_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Nº
                                </td>
                                <td>
                                   <input type="text" name="Numero" value="${cliente.nr_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CEP
                                </td>
                                <td>
                                   <input type="text" name="CEP" value="${cliente.cep_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Cidade
                                </td>
                                <td>
                                   <input type="text" name="Cidade" value="${cliente.cidade_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    UF
                                </td>
                                <td>
                                   <input type="text" name="UF" value="${cliente.uf_cliente}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" name="action" class="btn btn-danger" formaction="ClientesServlet?action=list" value="Cancelar">
                                </td>
                                <td>
                                    <%-- Ao pressionar Alterar, deve-se submeter para ClientesServlet?action=update.--%> 
                                   <input type="submit" name="action" class="btn btn-primary" formaction="ClientesServlet?action=update" value="Alterar">
                                </td>
                            </tr>
                    </table>
                </form>
            </div>
            
            <br/>
            <footer align="center">Em caso de problemas contactar o administrador: 
            E-mail: ${configuracao.email} 
        <%}else{ 
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema.");

            request.setAttribute("page", "index.jsp");
            rd.forward(request, response);  
        } 
       %> 
    </body>
</html>
