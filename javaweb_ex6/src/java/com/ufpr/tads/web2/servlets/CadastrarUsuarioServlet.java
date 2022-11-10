/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author robson.mariano
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns ={"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        LoginBean loginBeanSession = (LoginBean)session.getAttribute("loginBean");

        if (loginBeanSession.getNomeUsuario() == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Erro.jsp");            
            request.setAttribute("msg", "Usuário não está logado");  
            request.setAttribute("page", "index.html");
            
            response.setContentType("text/html;charset=UTF-8");
            
            rd.forward(request, response);
        }else{
   
            Usuario objUsuario = new Usuario();
            UsuarioDAO userDAO = new UsuarioDAO();

            objUsuario.setNome(request.getParameter("nome"));
            objUsuario.setLogin(request.getParameter("login"));
            objUsuario.setSenha(request.getParameter("senha"));

            userDAO.save(objUsuario);

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(objUsuario.getNome() + " cadastrado(a) com sucesso.<br/>");
            out.println("<a href='./portal.jsp'>Portal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
