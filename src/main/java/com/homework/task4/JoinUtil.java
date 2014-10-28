package com.homework.task4;

import java.util.*;
import java.util.stream.Collectors;
import static com.homework.task4.Main.logger;

//  functional programming: aggregate functions, method references + streams from java.util.stream package

public class JoinUtil<Person> {

    public List<Person> innerJoin(List<Person> list1, List<Person> list2) {
        if (list1 == null || list2 == null) {
            logger.info("Can't compare Persons since null references is passed: first -> " +list1+ " second -> " +list2);
            return new ArrayList<>();
        }
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }


    public List<Person> outerJoin(List<Person>  list1, List<Person>  list2) {
        if (list1 == null || list2 == null) {
            logger.info("Can't differentiate Persons since null references is passed: first -> " +list1+ " second -> " +list2);
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>(list1);
        result.removeAll(list2);
        list2.removeAll(list1);
        result.addAll(list2);
        return result;
    }

    public List<Person> merge(List<Person> list1, List<Person> list2) {
        if (list1 == null || list2 == null) {
            logger.info("Can't merge Persons since null reference is passed: first -> " +list1+ " second -> " +list2);
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>(list1);
        list2.stream().filter(person -> !result.contains(person)).forEach(result::add);
        return result;
    }

    public List<Person> leftJoin(List<Person> list1, List<Person> list2){
        if (list1 == null || list2 == null) {
            logger.info("Can't compare leftJoin on Persons since null reference is passed: first -> " +list1+ " second -> " +list2);
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>(list1);
        list2.stream().filter(result::contains).forEach(result::add);
        return result;
    }

  }

