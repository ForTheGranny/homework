package roman.homework.task3;

import roman.homework.task2.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class JoinUtil<Person> {

    boolean isNull(int[] firstArray, int[] secondArray) {
        return (firstArray == null || secondArray == null);
    }


    boolean isAlreadyExist(int[] array, int value) {
        for (int number : array) {
            if (number == value)
                return true;
        }
        return false;
    }


    public int[] innerJoin(int[] firstArray, int[] secondArray) {
        if (isNull(firstArray, secondArray))          // check references on NULL
            return null;
        int[] temp = (firstArray.length > secondArray.length) ? new int[secondArray.length] : new int[firstArray.length];      // to allocate the size for temp[] array precisely
        int counter = 0;            // added counter to know the precise size of matched results quantity in the temp[] array
        for (int f : firstArray)
            for (int s : secondArray) {
                if (f == s) {
                    if (isAlreadyExist(temp, f))     // to write the equal values to temp[] array only once
                        break;
                    temp[counter++] = f;
                }
            }
        return Arrays.copyOf(temp, counter);     // returns the new array containing the equal values only
    }


    int[] outerJoin(int[] firstArray, int[] secondArray) {
        if (firstArray == null)
            return secondArray;          // check references on NULL
        if (secondArray == null)
            return firstArray;
        int[] temp = new int[firstArray.length + secondArray.length];
        int[] result = new int[temp.length];
        System.arraycopy(firstArray, 0, temp, 0, firstArray.length);   // copy both arrays to temp[]
        System.arraycopy(secondArray, 0, temp, firstArray.length, secondArray.length);
        int counter = 0;
        for (int j = 0; j < temp.length; j++) {
            boolean containsDuplicates = false;
            for (int k = 0; k < temp.length; k++) {
                if (j != k && temp[j] == temp[k])
                    containsDuplicates = true;
            }
            if (!containsDuplicates)
                result[counter++] = temp[j];
        }
        return Arrays.copyOf(result, counter);
    }


    int[] merge(int[] firstArray, int[] secondArray) {
        int[] temp = new int[firstArray.length + secondArray.length];    // problematic part as int + int  ( 64 bit should be used - long[] )
        int[] result = new int[temp.length];
        System.arraycopy(firstArray, 0, temp, 0, firstArray.length);   // copy both arrays to temp[]
        System.arraycopy(secondArray, 0, temp, firstArray.length, secondArray.length);
        int counter = 0;
        for (int j = 0; j < temp.length; j++) {
            boolean containsDuplicates = false;
            for (int k = 0; k < temp.length; k++) {
                if (temp[j] == temp[k]) {
                    for (int number : result) {
                        if (number == temp[j])
                            containsDuplicates = true;
                    }
                    if (!containsDuplicates)
                        result[counter++] = temp[j];
                }
            }
        }
        return Arrays.copyOf(result, counter);
    }

    List<Person> merge(List<Person> list1, List<Person> list2) {
        List<Person> result = new ArrayList<Person>();
        for (Person first : list1) {
            if (list2.contains(first)) {
                if (!result.contains(first))
                    result.add(first);
            }
        }
        return result;
    }

        public int[] leftJoin ( int[] leftArray, int[] rightArray){
            if (leftArray == null || leftArray.length == 0)
                return new int[0];
            if (rightArray == null)
                return leftArray;
            int[] temp = innerJoin(leftArray, rightArray);
            int[] sum = new int[leftArray.length + temp.length];
            System.arraycopy(leftArray, 0, sum, 0, leftArray.length);
            System.arraycopy(temp, 0, sum, leftArray.length, temp.length);
            return sum;
        }
  }

