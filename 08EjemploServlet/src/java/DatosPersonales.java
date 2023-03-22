/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author alumno
 */
public class DatosPersonales extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //obtener los datos
            
            String nombre;
            int edad;
            
            //voy atender una peticion
            
            nombre = request.getParameter("nom");
            edad = Integer.parseInt(
                    request.getParameter("edad"));
            
            //vamos a obtener la ip 
            
            int puertolocal = request.getLocalPort();
            int puertoremoto = request.getRemotePort();
            
            String iplocal = request.getLocalAddr();
            String ipremota = request.getRemoteAddr();
            
            String namelocal = request.getLocalName();
            String nameremote = request.getRemoteUser();

            String adreesremote = request.getRemoteHost();
            String addreslocal = request.getLocalName();
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro Exitoso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Gracias por tus datos</h1>"
                    + "<br>"
                    + "<p>Tu nombre es: </p> "+nombre
                    + "<br>"
                    + "<p>Tu edad es: </p>"+edad
                    + "<br>"
                    + "<p> Elementos locales: " + iplocal + namelocal + puertolocal
                    + "<br>"
                    + "<p> Elementos remotos: " + ipremota + nameremote + puertoremoto
                    + "<br>"
                    + "<p> El host es: " + addreslocal
                    + "<a href='index.html' >Regresar a la pagina principal</a>");
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
