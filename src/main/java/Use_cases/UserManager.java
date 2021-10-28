package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;

public class UserManager implements Manager {

    public static Object[] createUser(String username, String password){
        UserStorage st = new UserStorage();
        int userid = st.getTotalNumber();
        User u = new User(username, userid, password, 100);
        UserManager.addElement(u);
        return new Object[]{u, u.getName(), u.getId()};
    }

    public static boolean login(String username, String password){
       return UserStorage.getUserList().get(username).getPassword().equals(password);
    }

    public Object search(String username) {
        return UserStorage.getUserList().get(username);
    }

    public static User search(int userId){
        for (String username: UserStorage.getUserList().keySet()){
            if (UserStorage.getUserList().get(username).getId() == userId){
                return UserStorage.getUserList().get(username);
            }
        }
        return null;
    }

    public static double getMoney(User u){
        return u.getWallet().getMoney();
    }

    public static void subtractMoney(User u, double money){
        u.getWallet().subtractMoney(money);
    }

    public void addElement(Object[] users) {
    }

    public static void addElement(Object user) {
        UserStorage.addElement(user);
    }

    public void removeElement(Object[] elements) {
    }

    public void removeElement(Object element) {

    }
}
