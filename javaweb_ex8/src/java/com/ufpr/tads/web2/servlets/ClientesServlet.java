

package com.ufpr.tads.web2.servlets;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.beans.LoginBean;
import com.ufpr.tads.web2.dao.EstadoDAO;
import com.ufpr.tads.web2.facade.AlterarClienteException;
import com.ufpr.tads.web2.facade.ClientesFacade;
import com.ufpr.tads.web2.facade.InserirClienteException;
import com.ufpr.tads.web2.facade.RemoverClienteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Servlet Controladora
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
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
            //pega o valor de action
            String action = request.getParameter("action");
            //se action vazia ou list
            if(action.isEmpty() || action.equals("list")){
                List<Cliente> clientes = new ArrayList<>();
                ClientesFacade facade = new ClientesFacade();
                
                //Lista de clientes
                clientes = facade.buscarTodosOsClientes();

                //Coloca no escopo da requisição o List<Cliente>
                request.setAttribute("listaClientes", clientes);

                //Efetua forward para clientesListar.jsp
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesListar.jsp");            

                rd.forward(request, response);
            }
            //visualizar cliente (lupa)
            else if(action.equals("show")){
                Cliente cliente = new Cliente();
                ClientesFacade facade = new ClientesFacade();

                //Recebe um parâmetro (via parameter, GET) com o Id do cliente a ser mostrado
                int id_cliente = Integer.parseInt(request.getParameter("id"));
                cliente.setId_cliente(id_cliente);

                //Busca no banco de dados o objeto do cliente
                cliente = facade.buscarCliente(cliente);

                //Coloca no escopo da requisição o Cliente
                request.setAttribute("cliente", cliente);

                //Efetua forward para clientesVisualizar.jsp
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesVisualizar.jsp");         

                rd.forward(request, response);
            }
            //Alterar cliente (lapis)
            else if(action.equals("formUpdate")){
                Cliente cliente = new Cliente();
                ClientesFacade facade = new ClientesFacade();
                //cria lista de estados
                List<Estado> listaEstados = new ArrayList<>();                
                EstadoDAO estadoDAO = new EstadoDAO();
                
                //Recebe um parâmetro (via parameter, GET) com o Id do cliente a ser mostrado
                int id_cliente = Integer.parseInt(request.getParameter("id"));

                cliente.setId_cliente(id_cliente);

                //Busca no banco de dados o objeto do cliente
                cliente = facade.buscarCliente(cliente);

                //Coloca no escopo da requisição o Cliente
                request.setAttribute("cliente", cliente);
                
                //Busca no banco de dados a lista de Estados
                listaEstados = estadoDAO.selectAll();
                
               //coloca a lista de Estados no Escopo da requisição
                request.setAttribute("listaEstados", listaEstados);
                
                //envia para a clientesForm com o atributo form com o valor alterar
                //coloca o atributo form no escopo da requisição
                request.setAttribute("form", "alterar");
                
                //Efetua forward para clientesAlterar.jsp
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesForm.jsp");            

                rd.forward(request, response);
            }
            
            else if(action.equals("update")){
                try {
                    Cliente cliente = new Cliente();
                    ClientesFacade facade = new ClientesFacade();
                    String[] conversaoData = request.getParameter("Data").split("/");
                    String dataConvertida = conversaoData[2] + "-" + conversaoData[1] + "-" + conversaoData[0];
                    
                    //Recebe os parâmetros (dados do cliente, via POST)      
                    cliente.setId_cliente(Integer.parseInt(request.getParameter("id")));
                    cliente.setCpf_cliente(request.getParameter("CPF"));
                    cliente.setNome_cliente(request.getParameter("Nome"));
                    cliente.setEmail_cliente(request.getParameter("Email"));
                    cliente.setData_cliente(dataConvertida);
                    cliente.setRua_cliente(request.getParameter("Rua"));
                    cliente.setNr_cliente(Integer.parseInt(request.getParameter("Numero")));
                    cliente.setCep_cliente(request.getParameter("CEP"));
                    cliente.setCidade_cliente(request.getParameter("Cidade"));
                    cliente.setUf_cliente(request.getParameter("UF"));
                    
                    //Altera no banco de dados o objeto do cliente
                    facade.alterarCliente(cliente);
                    
                    //Efetua um redirecionamento para ClientesServlet
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");           
                    rd.forward(request, response);
                    
                } catch (AlterarClienteException erro){
                    request.setAttribute("msg", erro.getMessage());
                    request.setAttribute("javax.servlet.jsp.jspException", erro);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    rd.forward(request, response);
                } catch(NumberFormatException erro){
                    request.setAttribute("msg", "Erro na formatação de número: " + erro);
                    request.setAttribute("javax.servlet.jsp.jspException", erro);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    rd.forward(request, response);
                }
            }
            else if(action.equals("remove")){
                try{
                    Cliente cliente = new Cliente();
                    ClientesFacade facade = new ClientesFacade();

                    //Recebe um parâmetro (via parameter, GET) com o Id do cliente a ser removido
                    int id_cliente = Integer.parseInt(request.getParameter("id"));
                    cliente.setId_cliente(id_cliente);
                    
                    //Remove o cliente do banco de dados
                    facade.removerCliente(cliente);
                    
                    //Efetua forward para clientesServlet.jsp
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");            
                    rd.forward(request, response);
                } catch (RemoverClienteException erro){
                    request.setAttribute("msg", erro.getMessage());
                    request.setAttribute("javax.servlet.jsp.jspException", erro);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    rd.forward(request, response);
                } catch (NumberFormatException erro){
                    request.setAttribute("msg", "Erro na formatação de número: " + erro);
                    request.setAttribute("javax.servlet.jsp.jspException", erro);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    rd.forward(request, response);
                }  
            }
            else if(action.equals("formNew")){
                //Carrega a lista de Estados e efetua um redirecionamento
                List<Estado> listaEstados = new ArrayList<>();                
                EstadoDAO estadoDAO = new EstadoDAO();
                
                //Busca no banco de dados a lista de Estados
                listaEstados = estadoDAO.selectAll();
                
               //coloca a lista de Estados no Escopo da requisição
                request.setAttribute("listaEstados", listaEstados);
                
                //coloca o atributo form no escopo da requisição
                request.setAttribute("form", "novo");
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/clientesForm.jsp");            

                rd.forward(request, response);
            }
            else if(action.equals("new")){
                try{
                    Cliente cliente = new Cliente();
                    ClientesFacade facade = new ClientesFacade();
                    String[] conversaoData = request.getParameter("Data").split("/");
                    String dataConvertida = conversaoData[2] + "-" + conversaoData[1] + "-" + conversaoData[0];
                    
                    //Recebe os parâmetros (dados do cliente, via POST)      
                    cliente.setCpf_cliente(request.getParameter("CPF"));
                    cliente.setNome_cliente(request.getParameter("Nome"));
                    cliente.setEmail_cliente(request.getParameter("Email"));
                    cliente.setData_cliente(dataConvertida);
                    cliente.setRua_cliente(request.getParameter("Rua"));
                    cliente.setNr_cliente(Integer.parseInt(request.getParameter("Numero")));
                    cliente.setCep_cliente(request.getParameter("CEP"));
                    cliente.setCidade_cliente(request.getParameter("Cidade"));
                    cliente.setUf_cliente(request.getParameter("UF"));

                    //Insere no dados o objeto do cliente
                    facade.inserirCliente(cliente);
                    
                    //Efetua um redirecionamento para ClientesServlet
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ClientesServlet?action=list");            
                    rd.forward(request, response);
                    
                } catch (InserirClienteException erro){
                    request.setAttribute("msg", erro.getMessage());
                    request.setAttribute("javax.servlet.jsp.jspException", erro);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    rd.forward(request, response);
                } catch (NumberFormatException erro){
                    request.setAttribute("msg", "Erro na formatação de número: " + erro);
                    request.setAttribute("javax.servlet.jsp.jspException", erro);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    rd.forward(request, response);
                }
            }
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
