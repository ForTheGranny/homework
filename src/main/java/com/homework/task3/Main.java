package com.homework.task3;

import com.homework.task2.Person;

import java.util.Arrays;

/**
 * Created by Roman Tereschenko on 10/13/2014.
 Array join (inner, outer, merge consider duplicates )
 Для inner union (обеднение общих элементов)
 [1,5,4,23,65,32,78]
 [3,5,24,4,1,2,34,45,32,5]
 res:
 [5,4,32,1]


 Для outer union (Вывод разных отличающихся элементов):
 [1,5,4,23,65,32,78]
 [3,5,24,4,1,2,34,45,32,5]
 res:
 [23,65,78,3,24,2,34,45]

 */
public class Main {

    public static void main(String[] args) {
     JoinUtil util = new JoinUtil();
     Person[] firstPersonList = new Person[10];
     Person[] secondPersonList = new Person[8];
//     ArrayHelper serviceDelegate = new ArrayHelper(firstPersonList,secondPersonList);
//     serviceDelegate.compareTwoPersons();


        int[] firstArray = new int[] {1,5,4,23,65,32,78};
        int[] secondArray = new int[] {3,5,24,4,1,2,34,45,32,5};
        int[] leftArray = new int[]{1,4,8,7,9};
        int[] rightArray = new int[]{11,4,7,10,0};

        int[] res_inner = util.innerJoin(firstArray, secondArray);
        int[] res_outer = util.outerJoin(firstArray, secondArray);
        int[] res_merge = util.merge(firstArray, secondArray);
        int[] left_join = util.leftJoin(leftArray,rightArray);

        System.out.print("Equal elements are: " + Arrays.toString(res_inner));
        System.out.print("\n"+ "Only different elements from both arrays: " + Arrays.toString(res_outer));
        System.out.print("\n"+ "Merge result: " + Arrays.toString(res_merge));
        System.out.print("\n"+ "Left Union: " + Arrays.toString(left_join));


    }
}
