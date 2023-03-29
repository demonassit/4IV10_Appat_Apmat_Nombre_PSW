<%-- 
    Document   : editarAlumno
    Created on : 28 mar 2023, 20:36:43
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
        <title>Editar Alumno</title>
    </head>
    <body>
        
        
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
             int id;
             
             id = Integer.parseInt(request.getParameter("id"));
             
             String q="select * from alumnos where boleta = "+id;
             
             set= con.createStatement();
             
             rs = set.executeQuery(q);
             
             while(rs.next()){
             
             System.out.println("Alumno encontrado");
             %>
             
             <form method="post" name="formulario" action="actualizaralumno.jsp"  > 
                 <label>Boleta</label>
                 <br><!-- comment -->
                 <input type="hidden" name="boleta2" 
                        value="<%=rs.getInt("boleta")%>" >
                 <br>
                 <label>Nombre: </label>
                 <br><!-- comment -->
                 <input type="text" name="nombre2" 
                        value="<%=rs.getString("nom")%>" >
                 <br>
                 <label>Apellido Paterno:</label>
                 <br><!-- comment -->
                 <input type="text" name="appat2" 
                        value="<%=rs.getString("appat")%>" >
                 <br>
                 <label>Apellido Materno:</label>
                 <br><!-- comment -->
                 <input type="text" name="apmat2" 
                        value="<%=rs.getString("apmat")%>" >
                 <br>
                 <label>Telefono:</label>
                 <br><!-- comment -->
                 <input type="text" name="tel2" 
                        value="<%=rs.getString("tel")%>" >
                 <br>
                 <label>Edad:</label>
                 <br><!-- comment -->
                 <input type="text" name="edad2" 
                        value="<%=rs.getString("edad")%>" >
                 <br>
                 <input type="submit" value="Actualizar Registro" >
                 <br>
                 <input type="reset" value="Borrar Datos" >
             </form>
             
             <%
                 }
            }catch(SQLException ex){
            System.out.println("Error en sql");
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Ruta: "+ ex.getStackTrace());

%>

<h1>No puedo obtener al alumno</h1>

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
