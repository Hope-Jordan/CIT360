package MVC;

/**
 * Created by JordanHope on 2/20/2016.
 */
public class recipe {
    public static void main (String args[]) {
        recipeView view = new recipeView();
        recipeModel model = new recipeModel();
        recipeControl control = new recipeControl(view, model);
        control.register();
    }
}

