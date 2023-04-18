<%-- 
    Document   : editarEmpleado
    Created on : 3 abr 2023, 20:56:50
    Author     : alumno
--%>

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
        <h1>Actualiza los datos del empledo</h1>
        <div class="container" >
            <form method="post" name="formulario" action="ActualizarEmpleado" >
                <table class="table" border="2" >
                    <tr>
                        <% 
                        int id = Integer.parseInt(request.getParameter("id"));
                        Empleado e = AccionesEmpleado.buscarEmpleadoById(id);
                            %>
                        <td>ID</td>
                        <td> <input type="hidden" value="<%=e.getId()%>" > </td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td> <input type="text" value="<%=e.getNom()%>" 
                                    name="nombre2" > </td>
                    </tr>
                    <tr>
                        <td>Apellido Paterno: </td>
                        <td> <input type="text" value="<%=e.getAppat()%>" 
                                    name="appat2" > </td>
                    </tr>
                    <tr>
                        <td>Apellido Materno: </td>
                        <td> <input type="text" value="<%=e.getApmat()%>" 
                                    name="apmat2" > </td>
                    </tr>
                    <tr>
                        <td>Correo: </td>
                        <td> <input type="text" value="<%=e.getCorreo()%>" 
                                    name="email2" > </td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td> <input type="text" value="<%=e.getPass()%>" 
                                    name="pass2" > </td>
                    </tr>
                    <tr>
                        <td colspan="2" > <input type="submit" 
                                                 value="Actualizar Datos" > </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
