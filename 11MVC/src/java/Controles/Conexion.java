/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author demon
 */
public class Conexion {
    
    public static Connection getConnection(){
        String url, username, password, driver;
        url = "jdbc:mysql:3306//localhost/empleados";
        username = "root";
        password = "n0m3l0";
        driver = "com.mysql.jdbc.Driver";
        
        Connection con = null;
        
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Se conecto a la bd");
            
        }catch(Exception e){
            System.out.println("No se conecto solo juguito");
            System.out.println("Error: " + e.getMessage());
        
        }
        return con;
    }
    
}
