package JUnit;

import java.util.HashMap;

/**
 * Created by JordanHope on 3/22/2016.
 */
public class ItemCompare {
    protected HashMap<String, Product> products;

    public ItemCompare() {
        products = new HashMap<String, Product>();
    }

    public void addProduct(Product product) {
            String key = product.getName() +
                    ", " + product.getStore();
            products.put(key, product);
    }
}
