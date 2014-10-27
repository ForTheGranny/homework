package roman.homework.task4;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Person> innerJoin(List<Person> list1, List<Person> list2) {
        if (list1 == null || list2 == null)          // check references on NULL
            return new ArrayList<>();
        return list1.stream().filter(list2::contains).collect(Collectors.toList()); //  functional programming: method references + streams from java.util.stream package
    }


    public List<Person> outerJoin(List<Person>  left, List<Person>  right) {
        if (left == null && right == null)
            return new ArrayList<>();
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        List<Person> result = new ArrayList<>(left);
        result.removeAll(right);
        right.removeAll(left);
        result.addAll(right);
        return result;
    }


        public List<Person> merge(List<Person> left, List<Person> right) {
        List<Person> result = left;
        for (Person person : right) {
            if (!result.contains(person))
                    result.add(person);
        }
        return result;
    }

    public List<Person> leftJoin(List<Person> left, List<Person> right){
        if(right == null && left != null)
            return left;
        else if(left == null)
            return new ArrayList<>();
        List<Person> result = left;
        for(Person person : right){
            if(result.contains(person))
                result.add(person);
        }
        return result;
    }

  }

