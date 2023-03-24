/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author demon
 */
public class ConsultarAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
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
    
    
    @Override
    public void init(ServletConfig scg) throws ServletException {
        //debo definir donde esta la bd
        String url = "jdbc:mysql:3306//localhost/alumnoscecyt9";
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
            url = "jdbc:mysql://localhost/alumnoscecyt9";
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
            out.println("<title>Lista de Alumnos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Alumnos Registrados al Dia de hoy</h1>"
                    + "<table>"
                    + "<tr>"
                    + "<td>Boleta</td>"
                    + "<td>Nombre Completo</td>"
                    + "<td>Edad</td>"
                    + "</tr>");
            
            try{
                int bol, edad;
                String nom, appat, apmat;
                
                //necesito mi querry
                String q = "select * from estudiante";
                
                //primero debo preparar la sentencia
                set = con.createStatement();
                
                rs = set.executeQuery(q);
                
                while(rs.next()){
                    //primero debo de obtener cada uno de los valores de la tabla
                    bol = rs.getInt("boleta");
                    nom = rs.getString("nombre");
                    appat = rs.getString("appat");
                    apmat = rs.getString("apmat");
                    edad = rs.getInt("edad");
                
                    //imprimir los elementos en la tabla
                    out.println("<tr>"
                            + "<td>"+bol+"</td>"  //boleta
                            + "<td>"+nom +" "+appat+ " "+ apmat +"</td>"  //nombre completo
                            + "<td>"+ edad +"</td>"  //edad
                            + "<tr>");
                }
                
                rs.close();
                set.close();
                
                
            }catch(Exception e){
                out.println("<h1>Registro No Exitoso solo juguito contigo</h1>");
                System.out.println("Error: " + e.getMessage());
                System.out.println("Origen: " + e.getStackTrace());
            }
            
            out.println("</table>");
            out.println("<a href = 'index.html'>Regresar al Inicio </a>");
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
