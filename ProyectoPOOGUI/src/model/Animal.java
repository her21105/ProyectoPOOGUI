/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joabh
 */
public class Animal {

    private String nombre;
    private String descripcion;
    private String informacion;

    /**
     * Método constructor
     * @param nombre
     * @param descripcion
     * @param informacion
     */
    public Animal(String nombre, String descripcion, String informacion){
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setInformacion(informacion);
    }
    
    public Animal(){
        
    }

    /**
     * Asigna el valor a la variable nombre
     * @param nom the nombre to set
     */
    public void setNombre(String nom){
        this.nombre = nom;
    }

    /**
     * Devuelve el valor de la variable nombre
     * @return the nombre
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Asigna el valor a la variable descripcion
     * @param des the descripcion to set
     */
    public void setDescripcion(String des){
        this.descripcion = des;
    }

    /**
     * Devuelve el valor de la variable descripcion
     * @return the descripcion
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Asigna el valor de la variable informacion
     * @param info the informacion to set
     */
    public void setInformacion(String info){
        this.informacion = info;
    }

    /**
     * Devuelve el valor de la variable informacion
     * @return the informacion
     */
    public String getInformacion(){
        return informacion;
    }

    /**
     * Devuelve el valor de las tres variables de forma String
     * Sirve para pasarlo a un archivo
     * @return string
     */
    public String animalString(){
        String s = "\n"+this.getNombre()+"|"+this.getDescripcion()+"|"+this.getInformacion();
        return s;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        
        return "nombre: "+getNombre()+"\n"
                + "descripción: "+getDescripcion()+"\n"
                + "información: "+getInformacion();
        
    }

}
