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
        FileWriter fw = new FileWriter(nombreArchivo,append);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);        
        pw.println(texto);
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



}

