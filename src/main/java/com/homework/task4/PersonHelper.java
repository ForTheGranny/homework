package com.homework.task4;

import com.homework.task2.Person;

import java.util.List;

/**
 * Created by Roman Tereschenko on 10/27/2014.
 */
public class PersonHelper {
        private JoinUtil<Person> util;



    public PersonHelper(JoinUtil<Person> util) {
        this.util = util;
    }

    public List<Person> mergePersons(List p1, List p2) {
        List<Person> result = util.merge(p1, p2);
        System.out.println(result.toString());
        return result;
    }

    public List<Person> onlyEqualPersons(List p1, List p2) {
        List<Person> result = util.innerJoin(p1, p2);
        System.out.println(result.toString());
        return result;
    }

    public List<Person> onlyDifferentPersons(List p1, List p2) {
        List<Person> result = util.outerJoin(p1, p2);
        System.out.println(result.toString());
        return result;
    }


}