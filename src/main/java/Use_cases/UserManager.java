package src.main.java.Use_cases;

import src.main.java.Entities.User;
import src.main.java.Entities.UserStorage;

public class UserManager implements Manager {

    public static Object[] createUser(String username, String password){
        UserStorage st = new UserStorage();
        int userid = st.getTotalNumber();
        User u = new User(username, userid, password, 100);
        UserManager um = new UserManager();
        um.addElement(u);
        return new Object[]{u, u.getName(), u.getId()};
    }

    @Override
    public Object search(String username) {
        return null;
    }

    public static User search(int userId){
        return UserStorage.getUserList().get(userId);
    }

    public static double getMoney(User u){
        return u.getWallet().getMoney();
    }

    public static void subtractMoney(User u, double money){
        u.getWallet().subtractMoney(money);
    }

    @Override
    public void addElement(Object[] users) {
    }

    @Override
    public void addElement(Object user) {
        UserStorage.addElement(user);
    }

    @Override
    public void removeElement(Object[] elements) {
    }

    @Override
    public void removeElement(Object element) {

    }
}
