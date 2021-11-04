package src.main.java.Use_cases;

import src.main.java.Entities.User;

import java.io.*;
import java.util.Map;

public class UserReadWriter implements Serializable {


    public static void SaveIntoFile(Map<String, User> users) throws IOException {
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
                Map<String,User> users = (Map<String, User>) input.readObject();
                /*
                如何把这个hashmap搞到storage里面去
                 */
                UserManager.userlist=users;
                input.close();
                System.out.println("Read success" );
    }





}
