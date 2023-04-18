<%-- 
    Document   : ConsultaEmpleados
    Created on : 3 abr 2023, 20:39:16
    Author     : alumno
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Modelo.Empleado"%>
<%@page import="Controles.AccionesEmpleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla de todos los empleados</h1>
        <div class="container" >
            <table border="2" class="table" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Correo</th>
                        <th>Password</th>
                        <th>Editar</th>
                        <th>Borrar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        //primero necesito mi array para enlistar a todos los empleados
                        List<Empleado> listaempleados = 
                                AccionesEmpleado.listaAllEmpleados();
                        //tengo que recorrer la lista
                        for(Empleado e : listaempleados){
                        
                        
                %>
                <tr>
                    <td> <%=e.getId()%> </td>
                    <td> <%=e.getNom()%> </td>
                    <td> <%=e.getAppat()%> </td>
                    <td> <%=e.getApmat()%> </td>
                    <td> <%=e.getCorreo()%> </td>
                    <td> <%=e.getPass()%> </td>
                    <td> <a href="editarEmpleado.jsp?id<%=e.getId()%>" >
                            Editar</a> </td>
                    <td> <a href="borrarEmpleado?id<%=e.getId()%>" >
                            Editar</a> </td>        
                </tr>
                
                <%
                        
                        }
                        %>
                </tbody>
            </table>
        </div>
                <a href="index.html" >Regresar al Inicio</a>
    </body>
</html>
