<%-- 
    Document   : registronuevo
    Created on : 27 mar 2023, 19:33:33
    Author     : alumno
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html"  language="java" import="java.io.*"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Registro</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <%
            //aqui ya es codigo java
            Connection con= null;
            Statement set=null;
            ResultSet rs=null;
            
            String username, password, url, driver;
            
            url="jdbc:mysql://localhost:3308/alumnoscecyt9";
            username= "root";
            password="n0m3l0";
            driver="com.mysql.cj.jdbc.Driver";
            
            try{
            //vamos a intentar conectarnos a la base de datos
            Class.forName(driver);
            //Establecer conexion
            con= DriverManager.getConnection(url,username,password);
            
            //ahora vamos a obtener los parametros para poder insertar en la bd
            
            try{
             String nom, appat, apmat, tel, edad;
             
             nom= request.getParameter("nom");
             appat=request.getParameter("appat");
             apmat=request.getParameter("apmat");
             tel=request.getParameter("telefono");
             edad= request.getParameter("edad");
             
             String q="insert into " + "alumnos(nom, appat, apmat,tel, edad)"+"values ('"+nom+"','"+appat+"','"+apmat+"', '"+tel+"', '"+edad+"')";
             
             set= con.createStatement();
             int registro= set.executeUpdate(q);
             System.out.println("Registro con exito");
             %>
             
             <h1>Registro Exitoso</h1>
             
             <%
            }catch(SQLException ex){
            System.out.println("Error en sql");
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Ruta: "+ ex.getStackTrace());

%>

<h1>No puego registrar en tabla</h1>

<%
            }
            }catch(Exception e){
            System.out.println("Error en sql");
            System.out.println("Error: " + e.getMessage());
            System.out.println("Ruta: "+ e.getStackTrace());
            %>
            
            <h1>No conecta a la bd</h1>
            <%
                }
                %>
                
                <a href="index.html">Regresar a la Pagina Principal</a>
    </body>
</html>
