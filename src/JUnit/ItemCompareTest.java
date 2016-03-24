package JUnit;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;


/**
 * Created by JordanHope on 3/22/2016.
 */
public class ItemCompareTest {
    ItemCompare itemCompareTest;
    Product one, two, three, four, five;

    @Before
    public void setUp() throws Exception {
        one = new Product("Cookie", 1.00, "Store one");
        two = new Product("Cookie", 1.25, "Store two");
        three = new Product("Cookie", 1.50, "Store three");
        four = new Product("Cookie", 1.75, "Store four");
        five = new Product("Cookie", 2.00, "Store five");
    }

    @Test
    public void testAddProduct() {
        itemCompareTest.addProduct(one);
        int numProducts = itemCompareTest.products.size();
        assertEquals(1, numProducts);
    }
}
