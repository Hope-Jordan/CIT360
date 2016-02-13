import java.io.Serializable;

/**
 * Created by JordanHope on 2/13/2016.
 */
public class recipeBean implements Serializable {
    private String name;
    private String description;

    public recipeBean() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
