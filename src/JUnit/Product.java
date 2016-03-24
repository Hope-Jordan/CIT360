package JUnit;

/**
 * Created by JordanHope on 3/22/2016.
 */
public class Product {
    String name;
    double price;
    String store;

    public Product(String name, double price, String store) {
        this.name = name;
        this.price = price;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
