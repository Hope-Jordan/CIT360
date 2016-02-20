package MVC;

import JavaBeans.userBean;

/**
 * Created by JordanHope on 2/20/2016.
 */
public class recipeControl {
    private recipeView view;
    private recipeModel model;

    public recipeControl(recipeView view, recipeModel model){
        this.view = view;
        this.model = model;
    }

    public void register() {
        int userCount = view.userCount();

        for (int i = 0; i < userCount; i++) {

            String username = view.getUsername();
            String password = view.getPassword();

            userBean newUser = new userBean(username, password);

            if (!model.checkForUser(newUser)) {
                model.addUser(newUser);
                System.out.println("Registered Successfully");
                view.displayUsernameAndPassword();
            } else {
                System.out.println("That username already exists, try another username");
                i--;
            }
        }

        model.printSet();
    }
}
