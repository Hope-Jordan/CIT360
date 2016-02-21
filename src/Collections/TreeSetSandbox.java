package Collections;

import java.util.TreeSet;

/**
 * Created by JordanHope on 2/5/2016.
 */
public class TreeSetSandbox {

    public static void main(String args[]) {
        /*
         * TreeSet will order elements in the set, does not accept duplicates.
         * TreeSet has to either work with the same data type or has to be passed a
         * comparator. A comparator is a function that handles how different data types can be compared
         * example, a string should become before a char, but after int.
         */


        /*******************************************
         * HAPPY PATHS
         *******************************************/


        System.out.println("********HAPPY PATHS********\n");

        TreeSet set = new TreeSet();

        set.add("element");
        set.add("Is");
        set.add("My");
        set.add("2.1");
        set.add("3");
        set.add("a");

        System.out.println("TreeSet of strings");
        System.out.println(set);
        System.out.println(set.contains("2.1"));


        TreeSet setB = new TreeSet();

        setB.add(1);
        setB.add(5);
        setB.add(3);
        setB.add(2);
        setB.add(4);

        System.out.println("TreeSet of ints");
        System.out.println(setB);

        TreeSet setC = new TreeSet();

        int a = 1;
        int b = 2;
        int c = 250000000;
        int d = 3;
        int e = 99999999;

        setC.add(a);
        setC.add(b);
        setC.add(c);
        setC.add(d);
        setC.add(e);
        System.out.println(setC);

        setC.remove(a);
        System.out.println("Removing an element");
        System.out.println(setC);

        System.out.println("Adding the two TreeSets of ints together using addAll method");
        setC.addAll(setB);
        System.out.println(setC);

        System.out.println("Clearing a TreeSet using clear method");
        setB.clear();
        System.out.println(setB);

        /*********************
         * NASTY PATHS
         **********************/
        System.out.println("\n\n *******NASTY PATHS*******\n");

        TreeSet nasty = new TreeSet();
        nasty.addAll(setC);

        System.out.println("Before anything nasty is done");
        System.out.println(nasty);

        try {
            nasty.add(null);
            System.out.println("Adding a null to the TreeSet");
            System.out.println(nasty);
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("Null cannot be added as an element in a TreeSet, Null pointer exception");
        }

        try {
            nasty.remove(6);
            System.out.println("Remove an element that does not exist");
            System.out.println(nasty);
        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.println("You can not remove an element that does not exist");
        }

        try {
            nasty.add(1);
            System.out.println("Adding an element that already exists");
            System.out.println(nasty);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

