/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;


import model.bean.Usuario;
import Connection.ConnectionFactory;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robson.mariano
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {



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
     
        Usuario user = new Usuario();
        
        String sql = "SELECT * FROM tb_usuario WHERE login_usuario = '" + request.getParameter("uname") + 
                "' and senha_usuario = '" + request.getParameter("psw") + "'";
                
        Connection con = ConnectionFactory.getConnection();
        System.out.println("Conexao estabelecida com sucesso!");
        
        try {
            Statement st = con.createStatement();
            st.executeQuery(sql);
            ResultSet rs = st.getResultSet();
            while (rs.next()){
              user.setLogin(rs.getString("login_usuario"));
              user.setSenha(rs.getString("senha_usuario"));
              user.setNome(rs.getString("nome_usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        HttpSession session = request.getSession();
        
        if (user.getNome() != null){
             System.out.println("foi");
            session.setAttribute("usuario", user);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/PortalServlet");
            rd.include(request, response);                                  
        } else {
             System.out.println("foi2");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ErroServlet");
            
            request.setAttribute("msg", "Usuário/Senha não encontrado! Erro ao acessar a página solicitada");
            
            request.setAttribute("page", "index.html");
            rd.forward(request, response);
        }
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
