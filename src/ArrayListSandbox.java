import java.util.ArrayList;

/**
 * Created by JordanHope on 1/23/2016.
 */
public class ArrayListSandbox {
    public static void main(String args[]) {
    /*
         * ArrayList, stores objects in an array that can be accessed by index
         * in order to access an element in a ArrayList use the get function and the
         * index of the item you would like to access
         */

        System.out.println("*****HAPPY PATHS*****");
        ArrayList numbers = new ArrayList();

        //happy path, arrayList of numbers
        numbers.add(4);
        numbers.add(45);
        numbers.add(44);
        numbers.add(43);
        numbers.add(42);
        numbers.add(41);

        System.out.println(numbers);

        //print element of array list found in index 3
        System.out.println(numbers.get(3));

        //add an element to a specific index
        numbers.add(3, 16);
        System.out.println(numbers);

        //remove an element in a specific index
        numbers.remove(3);
        System.out.println(numbers);

        //add all can add another collection to an array list.
        ArrayList letters = new ArrayList();
        letters.add('a');
        letters.add('b');
        letters.add('c');
        numbers.addAll(letters);
        System.out.println(numbers);

        System.out.println("The element in index 2 is: " + numbers.get(2));

        System.out.println("Contains blue: " + numbers.contains("blue"));

        System.out.println("c is stored in index: " + numbers.indexOf('c'));

        //removes all elements in the array list
        numbers.removeAll(numbers);
        System.out.println(numbers);

        /**************************************************************
         * NASTY PATHS
         **************************************************************/

        System.out.println("******NASTY PATHS******");

        ArrayList nasty = new ArrayList();

        nasty.add("String One");
        nasty.add("String Two");
        nasty.add("String Three");
        nasty.add("String Four");

        System.out.println("This is arrayList nasty before I have done anything to it");
        System.out.println(nasty);

        /***************************************************************
         * Add an element to an index that is out of current bounds
         * Throws an out of bounds exception
         * *************************************************************/

        System.out.println("Adding an element to an index that is out of bounds");
        try {
            nasty.add(7, 5);
            System.out.println(nasty);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't do this");
        }

        /***********************************
         * Add an element using null index
         * Really doesn't like this
         * *********************************/
       /* try {
            nasty.add(null, 5);
            System.out.println(nasty);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /***********************************
         * Add an element that is null
         * Adds null just fine
         ***********************************/
        System.out.println("Add an element that is null");
        try {
            nasty.add(null);
            System.out.println(nasty);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*************************************
         * Removing elements that don't exist
         * Index out of bounds exception
         * ***********************************/
        System.out.println("Removing an element that is out of bounds");
        try {
            nasty.remove(5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't remove an element that is out of bounds");
        }

        System.out.println("using get on an index that is out of bounds");
        try {
            System.out.println("The element in index 15 is: " + nasty.get(15));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't do that");
        }

        System.out.println("Getting the index of an element that does not exist");
        try {
            System.out.println("The index of NANCY is: " + nasty.indexOf("Nancy"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
