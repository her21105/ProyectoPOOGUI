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
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
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
        System.out.println("este es el texto: "+texto);
        FileWriter fw = new FileWriter(nombreArchivo,append);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);        
        pw.write(texto);
        pw.close();
        bw.close();
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
    public boolean MagregarAnimal(Animal a){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/animalesFile.txt").getFile());
            guardarEnFile(file, a.animalString1(), true); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean agregarAnimal(Animal a){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/animalesFile.txt").getFile());
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
            guardarEnFile(file, a.animalString2(), true); 
=======
>>>>>>> Stashed changes
            guardarEnFile(file, a.animalString(), true); 
>>>>>>> d53b9200b7a0f0b3e790c8467f3fa82b81260630
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
    public boolean MagregarUsuario(Usuario u){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/registro.txt").getFile());
            guardarEnFile(file, u.userString1(), true); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean agregarUsuario(Usuario u){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/registro.txt").getFile());
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
            guardarEnFile(file, u.userString2(), true); 
=======
>>>>>>> Stashed changes
            guardarEnFile(file, u.userString(), true); 
>>>>>>> d53b9200b7a0f0b3e790c8467f3fa82b81260630
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
    public boolean MagregarOrganizacion(Organizaciones o){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
            guardarEnFile(file, o.organizacionesString1(), true); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public boolean agregarOrganizacion(Organizaciones o){
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
            guardarEnFile(file, o.organizacionesString2(), true); 
=======
>>>>>>> Stashed changes
            guardarEnFile(file, o.organizacionesString(), true); 
>>>>>>> d53b9200b7a0f0b3e790c8467f3fa82b81260630
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    

    public void ModAnimales(String nombre, String description, String information, int valor) throws IOException{
        
        ArrayList<Animal> aux = new ArrayList<Animal>();
        aux.addAll(leerAnimalesDelArchivo());
        aux.get(valor).setNombre(nombre);
        aux.get(valor).setDescripcion(description);
        aux.get(valor).setInformacion(information);
        
        ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
        File file = new File(classLoader.getResource("containers/animalesFile.txt").getFile());
        file.delete();
        
        file.createNewFile();
        
        for (int i = 0; i < aux.size(); i++) {
            
            MagregarAnimal(aux.get(i));
            
            
        }
        
        
    }
    
    public void ModOrgs(String nombre, String anno, String lugar, String informacionC, String inform, int valor) throws IOException{
        
        ArrayList<Organizaciones> aux = new ArrayList<Organizaciones>();
        aux.addAll(leerOrganizacionesDelArchivo());
        aux.get(valor).setNombre(nombre);
        aux.get(valor).setAnnioDeCreacion(anno);
        aux.get(valor).setLugar(lugar);
        aux.get(valor).setInformacionDeContacto(informacionC);
        aux.get(valor).setInformacion(inform);
        
        ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
        File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
        file.delete();
        
        file.createNewFile();
        
        for (int i = 0; i < aux.size(); i++) {
            
            MagregarOrganizacion(aux.get(i));
            
            
        }
        
    }
    
    public void ModUsers(String user, String password, int valor) throws IOException{
        
        ArrayList<Usuario> aux = new ArrayList<Usuario>();
        aux.addAll(leerUsariosDelArchivo());
        aux.get(valor).setUser(user);
        aux.get(valor).setPassword(password);
        
        
        ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
        File file = new File(classLoader.getResource("containers/registro.txt").getFile());
        file.delete();
        
        file.createNewFile();
        
        for (int i = 0; i < aux.size(); i++) {
            
            MagregarUsuario(aux.get(i));
            
=======
>>>>>>> Stashed changes
    public void modificar(String archivo, int valor){
        
        try{
            switch(valor){
                
                case 1:
                    ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
                    File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
                    
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    
                    break;
                    
                
            }
            
            
            
        }catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "error");
<<<<<<< Updated upstream
            
        }
        
=======
>>>>>>> d53b9200b7a0f0b3e790c8467f3fa82b81260630
            
        }
        
    }

    
    private ArrayList<Animal> leerAnimalesDelArchivo(){//devuelve el arraylist de Animales
    
    ArrayList<Animal> listaAnimales = new ArrayList<Animal>();
    try{
        
        
        ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
        File file = new File(classLoader.getResource("containers/animalesFile.txt").getFile());
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
        
    } catch(Exception e){
        
        
        JOptionPane.showMessageDialog(null, "error al ingresar a la base de datos");
        
        }
        return listaAnimales;
    
    
>>>>>>> Stashed changes
    }

    private ArrayList<Organizaciones> leerOrganizacionesDelArchivo(){
        ArrayList<Organizaciones> listaOrganizaciones = new ArrayList<Organizaciones>();
        try{
            
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/organizacionesFile.txt").getFile());
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
    
    private ArrayList<Usuario> leerUsariosDelArchivo(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try{
            ClassLoader classLoader = getClass().getClassLoader(); //buscador de clases o recursos
            File file = new File(classLoader.getResource("containers/registro.txt").getFile());
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
}

