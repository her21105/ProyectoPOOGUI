/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/******************************************************************
Ultima modificacion: 30/09/2021

Clase controlador maneja todos los arhivos del programa
@file Controlador.java
@author Montserrat
@version 1.0, 30/09/2021
******************************************************************/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Animal;
import model.Organizaciones;
import model.Usuario;




public class ControladorArchivos {
    
    /** 
     * Este metodo sirve para introducir informacion en un archivo
     * @param nombreArchivo  se necesita el path relativo
     * @param texto  texto que se agregara
     * @param append determina si la informacion va al final
     * @throws IOException
     * @return funciona 
     * true = funciona
     * false = no funciona
     */
    public boolean guardarEnFile(File nombreArchivo, String texto, boolean append) throws IOException{
        try{
        //File file1 = new File(nombreArchivo);
        FileWriter fw = new FileWriter(nombreArchivo,append);
        PrintWriter pw = new PrintWriter(fw);        
        pw.write(texto);
        pw.close();
        fw.close();
        return true;
        }catch(Exception e){
            return false;
        }
    }

    
    /** 
     * Este metodo sirve para ingresar animales al file de animales
     * @param a animal
     * @return funciona
     */
    public boolean agregarAnimal(Animal a){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/AnimalesFile.txt").getFile());
            guardarEnFile(file, a.animalString(), true); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    /** 
     * Este metodo agrega usuarios a el file
     * @param u usuario
     * @return funciona
     */
    public boolean agregarUsuario(Usuario u){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/registro.txt").getFile());
            guardarEnFile(file, u.userString(), true); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    /** 
     * Este metodo agrega organizaciones con todo y su informacion al file
     * @param o organizacion
     * @return funciona
     */
    public boolean agregarOrganizacion(Organizaciones o){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
            guardarEnFile(file, o.organizacionesString(), true); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    
    /** 
     * Este metodo lee el archivo y devuelve un array de animales
     * Sirve para poder utilizar los animales como objetos junto a sus metodos
     * @return ArrayList
     */
    public ArrayList<Animal> leerAnimalesDelArchivo(){
        ArrayList<Animal> listaAnimales = new ArrayList<Animal>();
        try{
            File file = new File("/containers/animalesFile.txt");
            Scanner s = new Scanner(file);
            
            while (s.hasNextLine()){
                String linea = s.nextLine();
                String[] items = linea.split("\\|");
                
                String nombre = items[0];
                String descripcion = items[1];
                String informacion = items[2];

                Animal nuevoAnimal = new Animal(nombre, descripcion, informacion);
                listaAnimales.add(nuevoAnimal);
            }
            s.close();
        } catch (Exception e){
            
        }
        return listaAnimales;
        
    }

    
    /** 
     * Este metodo lee el archivo y devuelve un array de usuarios
     * Sirve para poder utilizar los usuarios como objetos junto a sus metodos
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> leerUsariosDelArchivo(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try{
            File file = new File("/containers/registro.txt");
            Scanner s = new Scanner(file);
            
            while (s.hasNextLine()){
                String linea = s.nextLine();
                String[] items = linea.split("\\|");
                
                String user = items[0];
                String password = items[1];

                Usuario nuevoUsuario = new Usuario(user, password);
                listaUsuarios.add(nuevoUsuario);
            }
            s.close();
        } catch (Exception e){
            
        }
        return listaUsuarios;
    }

    
    /** 
     * Este metodo lee el archivo y devuelve un array de organizaciones
     * Sirve para poder utilizar las organizaciones como objetos junto a sus metodos
     * @return ArrayList<Organizaciones>
     */
    public ArrayList<Organizaciones> leerOrganizacionesDelArchivo(){
        ArrayList<Organizaciones> listaOrganizaciones = new ArrayList<Organizaciones>();
        try{
            File file = new File("/containers/organizacionesFile.txt");
            Scanner s = new Scanner(file);
            
            while (s.hasNextLine()){
                String linea = s.nextLine();
                String[] items = linea.split("\\|");
                
                String nombre = items[0];
                String annioDeCreacion = items[1];
                String lugar= items[2];
                String informacionDeContacto= items[3];
                String informacion= items[4];

                Organizaciones nuevaOrganizaciones = new Organizaciones(nombre, annioDeCreacion, lugar, informacionDeContacto, informacion);
                listaOrganizaciones.add(nuevaOrganizaciones);
            }
            s.close();
        } catch (Exception e){
            
        }
        return listaOrganizaciones;
        
    }


}

