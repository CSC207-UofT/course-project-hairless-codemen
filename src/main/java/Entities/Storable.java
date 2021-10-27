package src.main.java.Entities;

import java.util.ArrayList;

interface Storable {
    static void addElement(Object object) {}

    static void addElement(Object[] objects){};

    static void deleteElement(Object object){};

    static void deleteElement(Object[] objects){};

    static ArrayList<Object> search() {
        return null;
    }
}