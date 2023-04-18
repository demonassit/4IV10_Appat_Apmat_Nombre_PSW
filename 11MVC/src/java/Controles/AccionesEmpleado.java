/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author demon
 */
public class AccionesEmpleado {
    
    
    /*
    Vamos a crear todos los metodos necesarios para poder
    manipular a un objeto de empleado
    
    RegistrarNuevoEmpleado
    ConsultarTodosEmpleados
    BuscarEmpleadoPorID
    ActualizarDatosEmpleado
    EliminarEmpleado
    */
    
    public static int registrarNuevoEmpleado(Empleado e){
        int estatus = 0; // me sirve para saber si se ejecuto
        try{
            //establecemos la conexion
            Connection con = Conexion.getConnection();
            //establezco la sentencia
            String q = "insert into empleado(nom, appat, apmat, correo, pass) "
                    + "values (?, ?, ?, ?, ?)";
            
            //vamos a settear la querry
            
            //como estamos setteando la sentencia es necesario primero
            //preprarla
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //porque vamos a hacer uso de los getter y setters
            ps.setString(1, e.getNom());
            ps.setString(2, e.getAppat());
            ps.setString(3, e.getApmat());
            ps.setString(4, e.getCorreo());
            ps.setString(5, e.getPass());
            
            //ya que esta preparada mandamos a ejecutarla
            
            estatus = ps.executeUpdate();
            
            System.out.println("Registro Exitoso");
            //cerramos la conexion con la bd
            con.close();
            
            
        }catch(Exception ex){
            System.out.println("No se pudo registrar los datos");
            System.out.println("Error :" + ex.getMessage());
        
        }
        return estatus;
    }
    
    //consultar a todos los empleados
        public static List<Empleado> listaAllEmpleados(){
        //crear mi objeto del arraylist
        List<Empleado> lista = new ArrayList<Empleado>();
        
        try{
            //establecemos la conexion
            Connection con = Conexion.getConnection();
            //establezco la sentencia
            String q = "select * from empleados";
                                 
            PreparedStatement ps = con.prepareStatement(q);
            
            //es necesario prepararla porque la momento de obtener los datos
            //de la bd se uitilizara los get y set del encapsulamiento
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                //aqui es donde voy a generar mi objeto del empleado
                Empleado e = new Empleado();
                //y empiezo los get y set
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setAppat(rs.getString(3));
                e.setApmat(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setPass(rs.getString(6));
                lista.add(e);
            }
            
            System.out.println("Consulta Exitosa");
            //cerramos la conexion con la bd
            con.close();
            
            
        }catch(Exception ex){
            System.out.println("No se pudo Consultar los datos");
            System.out.println("Error :" + ex.getMessage());
        
        }
        return lista;
    }
        
        
     //buscar empleado por id
        public static Empleado buscarEmpleadoById(int id){
        //aqui es donde voy a generar mi objeto del empleado
        Empleado e = new Empleado();
        
        try{
            //establecemos la conexion
            Connection con = Conexion.getConnection();
            //establezco la sentencia
            String q = "select * from empleados where id = ?";
                                 
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            
            //es necesario prepararla porque la momento de obtener los datos
            //de la bd se uitilizara los get y set del encapsulamiento
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                //y empiezo los get y set
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setAppat(rs.getString(3));
                e.setApmat(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setPass(rs.getString(6));
                
            }
            
            System.out.println("Consulta Exitosa");
            //cerramos la conexion con la bd
            con.close();
            
            
        }catch(Exception ex){
            System.out.println("No se pudo Consultar los datos");
            System.out.println("Error :" + ex.getMessage());
        
        }
        return e;
    }    
        
    //vamos actualizar un empleado    
    public static int actualizarEmpleado(Empleado e){
        int estatus = 0; // me sirve para saber si se ejecuto
        try{
            //establecemos la conexion
            Connection con = Conexion.getConnection();
            //establezco la sentencia
            String q = "update empleado set nom = ?,  appat = ?, "
                    + " apmat = ?,  correo = ?,  pass = ? "
                    + " where id = ?";
            
            //vamos a settear la querry
            
            //como estamos setteando la sentencia es necesario primero
            //preprarla
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //porque vamos a hacer uso de los getter y setters
            ps.setString(1, e.getNom());
            ps.setString(2, e.getAppat());
            ps.setString(3, e.getApmat());
            ps.setString(4, e.getCorreo());
            ps.setString(5, e.getPass());
            ps.setInt(6, e.getId());
            
            //ya que esta preparada mandamos a ejecutarla
            
            estatus = ps.executeUpdate();
            
            System.out.println("Actualización Exitosa");
            //cerramos la conexion con la bd
            con.close();
            
            
        }catch(Exception ex){
            System.out.println("No se pudo actualizar los datos");
            System.out.println("Error :" + ex.getMessage());
        
        }
        return estatus;
    }    
    
    //vamos a eliminar un empleado
    public static int eliminarEmpleado(int id){
        int estatus = 0; // me sirve para saber si se ejecuto
        try{
            //establecemos la conexion
            Connection con = Conexion.getConnection();
            //establezco la sentencia
            String q = "delete from empleado where id = ?";
            
            //vamos a settear la querry
            
            //como estamos setteando la sentencia es necesario primero
            //preprarla
            
            PreparedStatement ps = con.prepareStatement(q);
            
            //porque vamos a hacer uso de los getter y setters
            ps.setInt(1, id);
            
            
            //ya que esta preparada mandamos a ejecutarla
            
            estatus = ps.executeUpdate();
            
            System.out.println("Registro Eliminado");
            //cerramos la conexion con la bd
            con.close();
            
            
        }catch(Exception ex){
            System.out.println("No se pudo elimnar los datos");
            System.out.println("Error :" + ex.getMessage());
        
        }
        return estatus;
    }
}
