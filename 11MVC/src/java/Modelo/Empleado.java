/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author demon
 */
public class Empleado {
    
    private int id;
    private String nom;
    private String appat;
    private String apmat;
    private String correo;
    private String pass;
    
    public Empleado(){
    }

    public Empleado(int id, String nom, String appat, String apmat, String correo, String pass) {
        this.id = id;
        this.nom = nom;
        this.appat = appat;
        this.apmat = apmat;
        this.correo = correo;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAppat() {
        return appat;
    }

    public void setAppat(String appat) {
        this.appat = appat;
    }

    public String getApmat() {
        return apmat;
    }

    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
    
    
}
