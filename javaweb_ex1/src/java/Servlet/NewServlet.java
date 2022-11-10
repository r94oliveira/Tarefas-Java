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

/**
 *
 * @author robson.mariano
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            
            out.println("<style>");
            out.println("h1 {");
            out.println("color:blue;");
            out.println("font-size:35px;");
            out.println("font-family:Verdana;");
            out.println("}");
            out.println("p {");
            out.println("color:black;");
            out.println("font-size:10px;");
            out.println("font-family:Arial;");
            out.println("}");
            out.println("</style>");
            
            out.println("</head>");
            
            out.println("<body>");
            
            /*topo*/
            out.println("<h1>SEPT - SETOR DE EDUCAÇÃO PROFISSIONAL E TECNOLÓGICA</h1>");
            out.println("<p>Endereço: Rua Dr. Alcides Vieira Arcoverde, 1225 - CEP: 81520-260 - Jardim das Américas - Curitiba (PR) - Brasil</p><br/>");

            /*Tabela*/
            out.println("<table border='2'>");
        
            out.println("<tr>");
            out.println("<th>Curso</th>");
            out.println("<th>Página</th>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TPG</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/petroleogas/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TACS</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/agentesaude/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TADS</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/analisesistemas/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TCI</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/comunicacaoinstitucional/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TGQ</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/gestaoqualidade/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TGP</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/gestaopublica/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TL</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/luteria/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TNI</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/negociosimobiliarios/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TPC</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/producaocenica/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>TS</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/secretariado/sobre-o-curso/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Especialização em Inteligência Artificial Aplicada</td>");
            out.println("<td><a href='http://www.iaa.ufpr.br/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Especialização em Desenvolvimento Ágil de Software</td>");
            out.println("<td><a href='https://das.ufpr.br/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>MBA em Mercado Imobiliário</td>");
            out.println("<td><a href='http://www.sept.ufpr.br/portal/mbani/'>Link para a página do curso</a></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Pós-Graduação em Bioinformática</td>");
            out.println("<td><a href='http://www.bioinfo.ufpr.br/'>Link para a página do curso</a></td>");
            out.println("</tr>");
            out.println("</table>");

            /* Link JSP */
            out.println("<br/>");
            out.println("<a href='http://localhost:8080/WebApplication1/newjsp.jsp'>Meu TADS</a>");
            out.println("<br/>");
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
