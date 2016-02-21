package Collections;

import java.util.*;

/**
 * Created by JordanHope on 2/20/2016.
 */
public class CollectionIteratorSandbox {
    public static void main (String args[]){
        HashSet stuff = new HashSet();
        LinkedList things = new LinkedList();
        HashMap test = new HashMap();


        stuff.add(1);
        stuff.add(2);
        stuff.add(3);
        stuff.add(4);
        stuff.add(5);
        stuff.add(6);
        stuff.add(7);
        stuff.add(8);

        things.add(1);
        things.add(2);
        things.add(3);
        things.add(4);
        things.add(5);
        things.add(6);
        things.add(7);
        things.add(8);

        test.put(1, "one");
        test.put(2, "two");
        test.put(3, "three");
        test.put(4, "four");
        test.put(5, "five");
        test.put(6, "six");

        Iterator stuffIterator = stuff.iterator();
        System.out.print("Conents of stuff: ");
        while (stuffIterator.hasNext()) {
            System.out.print(stuffIterator.next() + " ");
        }
        System.out.println();


        ListIterator thingsIterator = things.listIterator();
        System.out.print("Conents of things: ");
        while (thingsIterator.hasNext()) {
            System.out.print(thingsIterator.next() + " ");
        }
        System.out.println();

        System.out.print("things backwards: ");
        while (thingsIterator.hasPrevious()) {
            System.out.print(thingsIterator.previous() + " ");
        }
        System.out.println();

        /*Iterating through a map is a little bit different, you can create an iterator for
        a set of either the entry values or the key values.*/

        Set entrySet = test.entrySet();

        Iterator testIt = entrySet.iterator();

        System.out.println("Test pairs : ");
        while(testIt.hasNext()){
            Map.Entry me = (Map.Entry)testIt.next();
            System.out.println("Key is: "+me.getKey() + " & " + "value is: "+me.getValue());
        }
    }
}

