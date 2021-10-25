/*
 * Archivo para convertir animales
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
     * Método para obtener el nombre del animal
     * @param animal
     * @return animal
     */
    @Override
    public String toString(Animal animal) {
        return animal == null ? null: animal.getNombre();
    }

    /**
     * Método para devolver null
     * @param string
     * @return null
     */
    @Override
    public Animal fromString(String string) {
        return null;
    }
    
}
