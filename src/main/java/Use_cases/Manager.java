package src.main.java.Use_cases;

interface Manager {
    Object search(String name);

    void addElement(Object[] elements);

    void addElement(Object element);

    void removeElement(Object[] elements);

    void removeElement(Object element);
}
