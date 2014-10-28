package com.homework.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman Tereschnko on 10/9/2014.
 */
public class Main {

    // Performs comparison for Persons using equals(), passed object can be checked using instanceof on type relation as well



    public static void main(String[] args){
        Person p1 = new Person.Builder()
                .firstName("Roman")
                .secondName("Tereschenko")
                .personAge(27)
                .personPost(Position.DEVELOPER)
                .build();

        Person p2 = new Person.Builder()
                .firstName("Tany")
                .secondName("Voytenko")
                .personAge(25)
                .personPost(Position.DIRECTOR)
                .build();


        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();

        System.out.println();

//            System.out.println("Comparison by equals() - " + " object1: " + p1 +"   object2: " +p2 + " result is: " + p1.equals(p2));
//
//            // Compare persons using hashcode()
//            System.out.println("Comparison by hashcode() - " + " object1: " + p1 +"   object2: " +p2 + " result is: " + (p1.hashCode()== p2.hashCode()));
//
//            // Compare persons using == (by reference)
//            System.out.println("Comparison by == (reference) - " + " object1: " + p1 +"   object2: " +p2 + " result is: " + (p1 == p2));

    }
}
