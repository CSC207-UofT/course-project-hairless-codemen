package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;

import java.io.*;
import java.util.Map;

public class UserReadWriter implements Serializable {


    public static void SaveIntoFile(Object users) throws IOException {
                File f = new File("UserData.ser");
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(users);

                oos.close();
                fos.close();
                System.out.println("Serialization success");


        }


    public static void readFromFile() throws IOException, ClassNotFoundException {
                InputStream fis = new FileInputStream("UserData.ser");
                ObjectInput input = new ObjectInputStream(fis);
                UserStorage users = (UserStorage) input.readObject();
                UserStorage.addElement(users);
                input.close();
                fis.close();
                System.out.println("Read success" );
    }





}
