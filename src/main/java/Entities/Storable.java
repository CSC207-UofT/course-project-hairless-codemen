package src.main.java.Entities;

import java.util.ArrayList;

interface Storable {

    /**
     * Add an object into a storable object.
     * @param object - object to be added into a storable object.
     */
    static void addElement(Object object) {}

    /**
     * Add a list of objects into a storable object.
     * @param objects - a list of objects to be added into a storable object.
     */
    static void addElement(Object[] objects){}

    /**
     * Delete an object from a storable object.
     * @param object - object to be deleted from a storable object.
     */
    static void deleteElement(Object object){}

    /**
     * Delete a list of objects from a storable object.
     * @param objects - a list of objects to be deleted from a storable object.
     */
    static void deleteElement(Object[] objects){}
}