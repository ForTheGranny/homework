package roman.homework.task1;

import java.util.ArrayList;
import java.util.Iterator;

/** Task: a) распечатайте в консоль все параметры которые передаются как параметры при запуске
 *        b) распечатай количество переданных параметров
 *
 * Created by Roman Tereschenko on 10/8/2014.
 */
public class Main {

    private static void outputArgs(String[] params){
        System.out.print("The specified arguments are: ");
        for(String str : params){
            System.out.print(str + " ");
        }
    }

    public static void main(String[] args){
//        outputArgs(args);
//        System.out.println("\n" + "Total number of arguments: " + args.length );

        //Obtain an iterator to the start of the collection by calling the collection's iterator( ) method.
        //Set up a loop that makes a call to hasNext( ). Have the loop iterate as long as hasNext( ) returns true.
        //Within the loop, obtain each element by calling next( ).

        ArrayList al = new ArrayList();
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");


        //Traversing Collections of arguments

        // There are three ways to traverse collections:
        //      (1) using aggregate operations
        //      (2) with the for-each construct and
        //      (3) by using Iterators.

        // obtain a stream and perform aggregate operations on it.




        // forward  (backward -> while(it.hasPrevious())  it.previous();   )
        Iterator it = al.iterator();
            while(it.hasNext()){
            System.out.println(it.next());
        }



    }
}
