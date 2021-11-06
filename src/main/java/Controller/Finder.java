package src.main.java.Controller;
import src.main.java.Entities.Item;
import src.main.java.Entities.ItemStorage;
import src.main.java.Entities.OrderStorage;
import src.main.java.Use_cases.*;

import java.util.ArrayList;
import java.util.Map;

public class Finder {
    public Object find(String target){
        String user = "";
        for (String key: UserManager.getUserList().keySet()){
            if (target.equals(key)){user = key;}
        }
        if (user.equals("")){return ItemManager.search(target);}
        return ItemManager.search_by_owner(user);
    }

    public Object find(int target){
        return OrderManager.search(target);
    }
}
