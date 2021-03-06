/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/******************************************************************
Ultima modificacion: 29/09/2021

Clase organizaciones: maneja la información de las organizaciones
@file Organizaciones.java
@author Jose
@version 1.0, 29/09/2021
******************************************************************/


public class Organizacion {

    private String nombre;
    private String annioDeCreacion;
    private String lugar;
    private String informacionDeContacto;
    private String informacion;

    /**
     * Método constructor
     * @param nombre
     * @param annioDeCreacion
     * @param lugar
     * @param informacionDeContacto
     * @param informacion
     */
    public Organizacion(String nombre, String annioDeCreacion, String lugar, String informacionDeContacto, String informacion) {
        this.setNombre(nombre);
        this.setAnnioDeCreacion(annioDeCreacion);
        this.setLugar(lugar);
        this.setInformacionDeContacto(informacionDeContacto);
        this.setInformacion(informacion);
    }
   

    
    /** 
     * Establece el nombre de la organizacion
     * @param nom nombre de la organizacion
     */
    public void setNombre(String nom){
        this.nombre=nom;
    }
   
    
    /** 
     * Regresa el nombre de la organizacion
     * @return String
     */
    public String getNombre(){
        return nombre;
    }
    
    
    /** 
     * Establece el anio de creacion de la organizacion
     * @param annio anio de creacion
     */
    public void setAnnioDeCreacion(String annio){
        this.annioDeCreacion=annio;
    }
   
    
    /** 
     * Devuelve el anio de creacion de la organizacion
     * @return String
     */
    public String getAnnioDeCreacion(){
        return annioDeCreacion;
    }
   
    
    /** 
     * Establece el lugar de la organizacion
     * @param lug lugar de la organizacion
     */
    public void setLugar(String lug){
        this.lugar=lug;
    }
   
    
    /** 
     * Regresa el lugar de la organizacion
     * @return String
     */
    public String getLugar(){
        return lugar;
    }
    
    
    /** 
     * Establece la informacion de contecto de la organizacion
     * @param infoC informacion de contacto
     */
    public void setInformacionDeContacto(String infoC){
        this.informacionDeContacto=infoC;
    }
  
    
    /** 
     * Devuelve la informacion de contacto de la organizacion
     * @return String
     */
    public String getInformacionDeContacto() {
        return informacionDeContacto;
    }
    
    
    /** 
     * Establece la informacion acerca de la organizacion
     * @param info informacion
     */
    public void setInformacion(String info){
        this.informacion=info;
    }
   
    
    /** 
     * Devuelve informacion acerca de la organizacion
     * @return String
     */
    public String getInformacion(){
        return informacion;
    }

    
    
    /** 
     * Devuelve un string con todas las variables de la organizacion
     * Esto sirve para meterlas al file
     * @return String
     */
    public String organizacionesString1(){
        String s = this.getNombre()+"|"+this.getAnnioDeCreacion()+"|"+this.getLugar()+"|"+this.getInformacionDeContacto()+"|"+this.getInformacion()+"\n";
        return s;
    }
    
    public String organizacionesString2(){
        String s = "\n"+this.getNombre()+"|"+this.getAnnioDeCreacion()+"|"+this.getLugar()+"|"+this.getInformacionDeContacto()+"|"+this.getInformacion();
        return s;
    }

    }

