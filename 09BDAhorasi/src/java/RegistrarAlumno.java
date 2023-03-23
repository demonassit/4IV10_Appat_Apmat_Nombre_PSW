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
import java.sql.*;
import javax.servlet.ServletConfig;

/**
 *
 * @author alumno
 */
public class RegistrarAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * vamos a necesitar un constructor para poder
     * inicializar las variables que se van a ocupar para 
     * la conexion con la bd
     * para ello vamos a crear 3 tipos de objeto
     */
    
    private Connection con;
    
    /*
    Este objeto nos sirve para poder crear una conexion con 
    la base de datos, recordemos que en bd, se debe de ocupar
    sentencias que se diven en dos lmd y ldd
    */
    private Statement set;
    
    /*
    Este objeto es el que se encarga de poder establecer las
    sentencias para definir y manipular los datos
    por ejemplo
    insert into
    update
    create
    alter
    drop
    delete
    */
    private ResultSet rs;
    
    /*
    Este objeto es exclusivo de las consultas en la bd
    select
    */
    
    //vamos a crear el constructor
    
    
    public void init(ServletConfig scg) throws Exception {
        //debo definir donde esta la bd
        String url = "jdbc:mysql:3306//localhost/alumnos";
        //tipo de conector
        //motor de la bd
        //puerto
        //ip donde esta alojada la bd
        //nombre de la bd
        String username = "root";
        String password = "n0m3l0";
        
        try{
            //debo mandar a llamar a la clase para establecer la conexion
            Class.forName("com.mysql.jdbc.Driver");
            
            //establezco conexion
            
            con = DriverManager
                    .getConnection(url, username, password);
            //establezco la sentencia
            set = con.createStatement();
            
            System.out.println("Wiiii si conecto *w* ");
            
        }catch (Exception e){
            System.out.println("Solo juguito contigo");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Ruta: " + e.getStackTrace());
        
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarAlumno at " + request.getContextPath() + "</h1>");
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
