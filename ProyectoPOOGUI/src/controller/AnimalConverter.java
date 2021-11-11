/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javafx.util.StringConverter;
import model.Animal;

/**
 *
 * @author Joabh
 */
public class AnimalConverter extends StringConverter<Animal> {

    
    /**
     * Metodo para convertir un animal en un string
    *@param Animal animal
    * @return String
    */
    @Override
    public String toString(Animal animal) {
        return animal == null ? null: animal.getNombre();
    }
    /**
     * Metodo para convertir un string en un animal
    *@return Animal animal
    * @param String
    */
    @Override
    public Animal fromString(String string) {
        return null;
    }
    
}
