package src.main.java;

interface Manager {
    Object search(String name);

    void addElement(Object[] elements);

    void addElement(Object element);

    void removeElement(Object[] elements);

    void removeElement(Object element);
}
