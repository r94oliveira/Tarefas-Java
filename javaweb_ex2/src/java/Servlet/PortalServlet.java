/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Classes.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author robson.mariano
 */
@WebServlet(name = "PortalServlet", urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter())
        {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            
            Usuario usuario0 = new Usuario("robson", "robsonLogin", "robsonSenha");
            Usuario usuario1 = new Usuario("marcos", "marcosLogin", "marcosSenha");
            Usuario usuario2 = new Usuario();
            usuario2.setNome("michely");
            usuario2.setLogin("michelyLogin");
            usuario2.setSenha("michelySenha");
            
            usuarios.add(usuario0);
            usuarios.add(usuario1); 
            usuarios.add(usuario2);  
                     
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Portal</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h4>Cadastro de Usuário</h4>");
            out.println(
                "<form name='Formulario' action='./CadastrarUsuarioServlet' method='post'>"
                    + "Nome: <input type='text' name='nome' value='' /> <br/>" 
                    + "Login: <input type='text' name='login' value='' /> <br/>"
                    + "Senha: <input type='password' name='senha' value='' /> <br/>" 
                    + "<br /><input type='submit' value='Salvar'><br />"
                +"</form><br/>");
            
            out.println("<table border='2'>" + "<tr>" + "<th>Nome</th>" + "<th>Login</th>" + "<th>Senha</th>" + "</tr>");
            
            for(Usuario usuario : usuarios){
                out.println("<tr>");                  
                out.println("<td>"+ usuario.getNome() + "</td>");
                out.println("<td>"+ usuario.getLogin() + "</td>");
                out.println("<td>"+ usuario.getSenha() + "</td>");
                out.println("</tr>");
            }                        
            out.println("</table>");
            out.println("<br /><a href='./LogoutServlet'>Logout</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
