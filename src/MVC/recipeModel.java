package MVC;

import JavaBeans.userBean;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by JordanHope on 2/20/2016.
 */
public class recipeModel {
    HashSet userSet = new HashSet();

    public void addUser(userBean user) {
        userSet.add(user.getUsername());
    }

    public void removeUser(userBean user) {
        userSet.remove(user.getUsername());
    }

    public boolean checkForUser(userBean user) {
        return userSet.contains(user.getUsername());
    }

    public void printSet() {
        System.out.println(userSet);
    }

}
