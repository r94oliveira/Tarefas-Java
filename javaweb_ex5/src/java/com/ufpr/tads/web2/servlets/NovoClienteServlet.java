
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

@WebServlet(name = "NovoClienteServlet", urlPatterns = { "/NovoClienteServlet" })
public class NovoClienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        LoginBean loginBeanSession = (LoginBean)session.getAttribute("loginBean");
        
        if (loginBeanSession.getNomeUsuario() == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

            request.setAttribute("msg", "Usuário deve se autenticar para acessar o sistema");  

            rd.forward(request, response);
          
        }else{
            Cliente cliente = new Cliente();
            ClienteDAO clienteDAO = new ClienteDAO();
     
            cliente.setCpf_cliente(request.getParameter("CPF"));
            cliente.setNome_cliente(request.getParameter("Nome"));
            cliente.setEmail_cliente(request.getParameter("Email"));
            cliente.setData_cliente(request.getParameter("Data"));
            cliente.setRua_cliente(request.getParameter("Rua"));
            cliente.setNr_cliente(Integer.parseInt(request.getParameter("Numero")));
            cliente.setCep_cliente(request.getParameter("CEP"));
            cliente.setCidade_cliente(request.getParameter("Cidade"));
            cliente.setUf_cliente(request.getParameter("UF"));

            clienteDAO.insert(cliente);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet");            

            rd.forward(request, response);
        }
    }
}
