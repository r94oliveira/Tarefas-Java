/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author robson.mariano
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuarioServlet"})
public class CadastrarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Usuario user = new Usuario();
        UsuarioDAO userDAO = new UsuarioDAO();
        
        user.setNome(request.getParameter("user_name"));
        user.setLogin(request.getParameter("user_email"));
        user.setSenha(request.getParameter("user_pw"));
        
        userDAO.save(user);
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Cadastrar Usuário</title><link rel=\"stylesheet\" href=\"./style.css\"></head><body>");
        out.println("<header><h1>Usuario '" + user.getNome() + "' cadastrado com sucesso!</h1></header>");      
        out.println("<section class=\"content-cards\">");
        out.println("<div class=\"container\">");
        out.println("<div class=\"vector-card\">");
        out.println("<ul>");
        out.println("<li>");
        out.println("Nome: " + user.getNome());
        out.println("</li>"); 
        out.println("<li>");
        out.println("E-mail: " + user.getLogin());
        out.println("</li>"); 
        out.println("<li>");
        out.println("Senha: " + user.getSenha());
        out.println("</li>"); 
        out.println("<li class=\"button\">");
        out.println("<button><a href=\"PortalServlet\">Portal Servlet</a></button>");
        out.println("</li>"); 
        out.println("</ul></div></div></section>");
        out.println("</body></html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
