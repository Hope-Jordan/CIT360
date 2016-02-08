import java.util.HashMap;

/**
 * Created by JordanHope on 2/8/2016.
 */
public class HashMapSandbox {
    public static void main(String[] args) {

        /**********************************
         * HAPPY PATH
         **********************************/
        HashMap map = new HashMap();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");

        System.out.println("HashMap of int key 1 - 6, string words one - six");
        System.out.println(map);

        System.out.println("Using remove to remove key 4");
        map.remove(4);
        System.out.println(map);

        System.out.println("Using containsKey, returns bool");
        System.out.println("map contains the key 3: " + map.containsKey(3));
        System.out.println("map contains the key 4: " + map.containsKey(4));

        System.out.println("Using containsValue, returns bool");
        System.out.println("map contains the value Three: " + map.containsValue("Three"));
        System.out.println("map contains the value Four: " + map.containsValue("Four"));

        System.out.println("Using size()");
        System.out.println("The size of map is: " + map.size());

        System.out.println("Using values(), returns a Collection of the values in the map");
        System.out.println(map.values());

        System.out.println("Using keySet() returns the keys in a Set");
        System.out.println(map.keySet());

        System.out.println("Using entrySet(), returns the values in the map in a Set");
        System.out.println(map.entrySet());

        System.out.println("Using get(1), returns the element with the associated key.");
        System.out.println(map.get(1));

        System.out.println();

        System.out.println("*****NASTY PATHS*****");
        System.out.println();

        System.out.println("Adding a value when the key is 7 and the value is null");
        try {
            map.put(7, null);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Adding a value when key is null");
        try {
            map.put(null, "Test");
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("using get for a key that does not exist");
        try {
            System.out.println(map.get(45));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(map.get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
