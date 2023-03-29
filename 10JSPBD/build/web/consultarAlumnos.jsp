<%-- 
    Document   : consultarAlumnos
    Created on : 28 mar 2023, 20:08:36
    Author     : alumno
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Alumnos Inscritos</title>
    </head>
    <body>
        <h1>Tabla de Alumnos Inscritos para Dictamen</h1>
        <br><!-- comment -->
        <table border="2" >
            <thead>
                <tr>
                    <th>Boleta</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    
                    <th>Telefono</th>
                    <th>Edad</th>
                    <th>Editar</th>
                    <th>Borrar</th>
                </tr>
            </thead> 
            <tbody>
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
                Class.forName(driver);
                con = DriverManager
                .getConnection(url, username, password);
                
                //hacemos otro try
                try{
                    String q = "select * from alumnos order by boleta ASC";
                    //estoy creando una sentencia para una consulta
                    set = con.createStatement();
                    //es el unico que sirve para poder hacer consultas
                    rs = set.executeQuery(q);
                    
                    while(rs.next()){
                        
                    %>
                    <tr>
                        <td> <%=rs.getInt("boleta")%> </td>
                        <td> <%=rs.getString("nom")%> </td>
                        <td> <%=rs.getString("appat")%> </td>
                        <td> <%=rs.getString("apmat")%> </td>
                        <td> <%=rs.getString("tel")%> </td>
                        <td> <%=rs.getString("edad")%> </td>
                        <td> <a 
                                href="editarAlumno.jsp?id= 
                                <%=rs.getInt("boleta")%>">Editar</a> </td>
                        <td> <a 
                                href="borrarAlumno.jsp?id= 
                                <%=rs.getInt("boleta")%>">Borrar</a> </td>
                    </tr>
                    
                    <%
                    System.out.println("Consulta de todos los alumnos");
                    }
                    
                }catch(SQLException eq){
                    System.out.println("No conecto con la tabla");
                    System.out.println("Error: " + eq.getMessage());
                    System.out.println("Ruta: " + eq.getStackTrace());
                    
                    %>
            <h1>Error al momento de procesar la consulta</h1>
                    <%

                    }
                    
            }catch(Exception ex){
                System.out.println("Error no conecta con la bd");
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Ruta: " + ex.getStackTrace());
                    %>
              <h1>No conecta la BD</h1>      
                    <%
            }
                    %>
                
            </tbody>
        </table>
        <a href="index.html" >Regresar a la pagina principal</a>            
        <br>
        <a href="registronuevo.jsp" >Registrar nuevo Alumno</a>
    </body>
</html>
