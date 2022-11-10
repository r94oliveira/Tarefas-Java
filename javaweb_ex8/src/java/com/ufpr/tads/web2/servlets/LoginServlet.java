

package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.LoginBean;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.ufpr.tads.web2.beans.Usuario;
import com.ufpr.tads.web2.dao.UsuarioDAO;

//Nome da Servlet - rececebe da index
@WebServlet(name = "LoginServlet", urlPatterns ={ "/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //select        
        Usuario user = new Usuario();
        UsuarioDAO userDAO = new UsuarioDAO();
        LoginBean loginBean = new LoginBean();
         
        user.setLogin_usuario(request.getParameter("login"));
        user.setSenha_usuario(request.getParameter("senha"));
        
        // user guarda todos os atributos do Usuario obtidos do BD
        user = userDAO.selectUser(user);
        
        //requisita a sessão
        HttpSession session = request.getSession();
        
        //verifica se tem usuario
        if (user.getNome_usuario() != null){
            //Preenche uma instância de LoginBean com os dados do usuário
            loginBean.setIdUsuario(user.getId_usuario());
            loginBean.setNomeUsuario(user.getNome_usuario());            
            
            //coloca objeto loginBean inteiro na sessão (este objeto armazena dados do usuario)
            session.setAttribute("loginBean", loginBean);
            
            response.setContentType("text/html;charset=UTF-8");
            
            //par login/senha encontrados no BD: Redireciona para a portal.jsp 
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/portal.jsp");
            rd.include(request, response);
        }
        else {                        
            /*
            par login/senha NÃO encontrados no BD: Redireciona para erro.jsp (via forward)
            passando como parâmetro a mensagem de erro a ser apresentada (parâmetro "msg") 
            e o nome da página para retornar (index.html) (parâmetro "page")
            */                       
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");            
            request.setAttribute("msg", "Usuário/Senha inválidos");  
            request.setAttribute("page", "index.jsp");
            response.setContentType("text/html;charset=UTF-8");
            rd.forward(request, response);
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
    //@Override
    //protected void doGet(HttpServletRequest request, HttpServletResponse response)
            //throws ServletException, IOException {
        //processRequest(request, response);
    //}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //@Override
    //protected void doPost(HttpServletRequest request, HttpServletResponse response)
            //throws ServletException, IOException {
        //processRequest(request, response);
    //}

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
