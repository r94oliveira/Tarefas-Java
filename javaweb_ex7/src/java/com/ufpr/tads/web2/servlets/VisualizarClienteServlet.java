/* Verifica se o usuário está logado. Se não estiver, redireciona via forward para 
index.jsp passando como parâmetro a mensagem "Usuário deve se autenticar para acessar 
o sistema" (parâmetro "msg").
Executa os seguintes passos:
	• Recebe um parâmetro (via parameter, GET) com o Id do cliente a ser mostrado
	• Busca no banco de dados o objeto do cliente
	• Adiciona o objeto no escopo da requisição
Efetua forward para clientesVisualizar.jsp */

package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.dao.ClienteDAO;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "VisualizarClienteServlet", urlPatterns = {"/VisualizarClienteServlet"})
public class VisualizarClienteServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //requisita a sessão
        HttpSession session = request.getSession();

        //verifica se o usuário está logado
        LoginBean loginBeanSession = (LoginBean)session.getAttribute("loginBean");
        
        if (loginBeanSession.getNomeUsuario() == null) {
          RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

          request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");  

          rd.forward(request, response);
        }else{
          Cliente cliente = new Cliente();
          ClienteDAO clienteDAO = new ClienteDAO();
          
          //Recebe um parâmetro (via parameter, GET) com o Id do cliente a ser mostrado
          int id_cliente = Integer.parseInt(request.getParameter("id"));
          
          cliente.setId_cliente(id_cliente);
          
          //Busca no banco de dados o objeto do cliente
          cliente = clienteDAO.select(cliente);

          //Coloca no escopo da requisição o Cliente
          request.setAttribute("cliente", cliente);

          //Efetua forward para clientesVisualizar.jsp
          RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesVisualizar.jsp");            

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

