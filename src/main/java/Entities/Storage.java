package src.main.java.Entities;

import java.util.ArrayList;

public abstract class Storage {

    // Get Total Number of Objects stored in Storage
    abstract int getTotalNumber();

    abstract void addElement(Object object);

    abstract void deleteElement(Object object);
}