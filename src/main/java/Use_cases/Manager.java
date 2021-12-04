package src.main.java.Use_cases;

import java.io.IOException;
import java.util.ArrayList;

interface Manager {

    /**
     * Search for an object based on name.
     * @param name - the parameter used to perform the search operation.
     * @returns object that matches the parameter
     */
    static Object search(Object name){return null;}

    /**
     * Add a list of elements into corresponding storage.
     * @param elements - the ArrayList of elements to be added into corresponding storage.
     */
    static void addElement(ArrayList<Object> elements){}

    /**
     * Add a single element into corresponding storage.
     * @param element - the element to be added into corresponding storage.
     */
    static void addElement(Object element){}

    /**
     * Remove a list of elements from corresponding storage.
     * @param elements - the list of elements to be removed from the corresponding storage.
     */
    static void removeElement(Object[] elements){}

    /**
     * Remove a single element from corresponding storage.
     * @param element - the element to be removed from the corresponding storage.
     */
    static void removeElement(Object element){}
}
