
package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns ={"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //requisita a sessão
        HttpSession session = request.getSession();

        //verifica se o usuário está logado
        LoginBean loginBeanSession = (LoginBean)session.getAttribute("loginBean");

        if (loginBeanSession.getNomeUsuario() == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro.jsp");            
            request.setAttribute("msg", "Usuário não está logado");  
            request.setAttribute("page", "index.jsp");
            
            response.setContentType("text/html;charset=UTF-8");
            
            rd.forward(request, response);
        }else{
            //Classe   //objeto      //classe
            Usuario objUsuario = new Usuario();
            UsuarioDAO userDAO = new UsuarioDAO();

            //cria um objeto do tipo Usuario e insere os dados vindos de inserir.jsp
            //neste objeto, passados pelo request
            objUsuario.setNome_usuario(request.getParameter("nome"));
            objUsuario.setLogin_usuario(request.getParameter("login"));
            objUsuario.setSenha_usuario(request.getParameter("senha"));

            /*userDAO é um objeto de acesso aos dados do BD. Executa a função de insert no 
            BD pela DAO (data acess object)*/
            userDAO.save(objUsuario);

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(objUsuario.getNome_usuario() + " cadastrado(a) com sucesso.<br/>");
            out.println("<a href='./portal.jsp'>Portal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
