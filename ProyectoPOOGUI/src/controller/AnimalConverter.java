/*
 * Archivo AnimalConverter.java
 */
package controller;


import javafx.util.StringConverter;
import model.Animal;

/**
 * Para convertir los animales
 * @author Joabh
 */
public class AnimalConverter extends StringConverter<Animal> {

    /**
     * Método para obtener al animal
     * @param animal
     * @return animal
     */
    @Override
    public String toString(Animal animal) {
        return animal == null ? null: animal.getNombre();
    }

    /**
     * Método para obtener null
     * @param string
     * @return null
     */
    @Override
    public Animal fromString(String string) {
        return null;
    }
    
}
