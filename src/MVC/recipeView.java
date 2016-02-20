package MVC;

import java.util.Scanner;

/**
 * Created by JordanHope on 2/20/2016.
 */
public class recipeView {

        Scanner in = new Scanner(System.in);
        String username;
        String password;

        String getUsername() {
            System.out.print("Username: ");
            username = in.next();
            return username;
        }

        String getPassword() {
            System.out.print("Password: ");
            password = in.next();
            return password;
        }

        void displayUsernameAndPassword() {
            System.out.println("Your username and password are: " + username + " | " + password);
        }

        public int userCount () {
            System.out.println("How many users do you want to register?");
            return in.nextInt();
        }

}
