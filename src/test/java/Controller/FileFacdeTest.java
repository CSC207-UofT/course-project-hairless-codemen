package src.test.java.Controller;

import org.junit.jupiter.api.*;
import src.main.java.Controller.FileFacade;
import src.main.java.Use_cases.ItemManager;
import src.main.java.Use_cases.OrderManager;

import java.io.File;
import java.io.IOException;

public class FileFacdeTest {



    @Test
    public void TestA() throws IOException, ClassNotFoundException {
        FileFacade.readItem();
        System.out.println(OrderManager.getItems());
        System.out.println(ItemManager.getItems());
        System.out.println("TestA over");

    }


    @AfterAll
    static void After(){
        new File("ItemData.ser").delete();
        new File("OrderData.ser").delete();
    }






}
