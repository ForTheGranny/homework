package com.homework.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.homework.task2.Person;
import com.homework.task2.Position;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Roman Tereschenko on 10/23/2014.
 */
public class Main {
    // Log4j2.0 - obtain logger for this package with INFO level
    static final Logger logger = LogManager.getLogger(Main.class.getPackage().getName());

    public static void main(String[] args) {
        final JoinUtil util = new JoinUtil();
        final PersonHelper delegateService = new PersonHelper(util);

        List<Person> p1 = new ArrayList<>();
                     p1.add(new Person.Builder()
                             .firstName("Roma")
                             .secondName("rteresch")
                             .personAge(10)
                             .personPost(Position.DEVELOPER)
                             .build());
                     p1.add(new Person.Builder()
                             .firstName("Roma")
                             .secondName("rteresch")
                             .personAge(10)
                             .personPost(Position.DEVELOPER)
                             .build());
                     p1.add(new Person.Builder()
                             .firstName("D")
                             .secondName("Ds")
                             .personAge(40)
                             .personPost(Position.DIRECTOR)
                             .build());
        List<Person> p2 = new ArrayList<>();
                    p2.add(new Person.Builder()
                            .firstName("Roma")
                            .secondName("rteresch")
                            .personAge(10)
                            .personPost(Position.DEVELOPER)
                            .build());
                    p2.add(new Person.Builder()
                            .firstName("D")
                            .secondName("Ds")
                            .personAge(40)
                            .personPost(Position.DIRECTOR)
                            .build());
                    p2.add(new Person.Builder()
                            .firstName("B")
                            .secondName("Bs")
                            .personAge(7)
                            .personPost(Position.QA)
                            .build());
                    p2.add(new Person.Builder()
                            .firstName("C")
                            .secondName("Cs")
                            .personAge(15)
                            .personPost(Position.DIRECTOR)
                            .build());

//        List<Person> p1 = getPersons(100);
//        List<Person> p2 = getPersons(100);

        //delegateService.onlyEqualPersons(p1,p2);
        delegateService.onlyDifferentPersons(p1,p2);
        //delegateService.mergePersons(p1,p2);



    }

    // util method to generate the required amount of randomly generated Persons
    private static List<Person> getPersons(int quantity){
        if(quantity == 0)
            return new ArrayList<>();

        char[] alphabet = "abcefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder name = new StringBuilder();
        StringBuilder surname = new StringBuilder();
        Random random = new Random();
        List<Person> result = new ArrayList<>();

        // Get the char by its numeric representation and append to the end of StringBuilder
        while(result.size() <= quantity){
            if(name.length() > 0 && surname.length() > 0) {
                name.delete(0, name.length());
                surname.delete(0, surname.length());
            }
            // Defines quantity of characters in a Person's name
            for (int i = 0; i < 3; i++) {
                char n = (i == 0)? Character.toUpperCase(alphabet[random.nextInt(alphabet.length)]) : alphabet[random.nextInt(alphabet.length)];
                char s = (i == 0)? Character.toUpperCase(alphabet[random.nextInt(alphabet.length)]) : alphabet[random.nextInt(alphabet.length)];
                name.append(n);
                surname.append(s);
            }
            result.add(new Person.Builder()
                    .firstName(name.toString())
                    .secondName(surname.toString())
                    .personAge((int) (Math.random() * 15) + 10)
                    .personPost(Position.values()[((int) (Math.random() * 3))])
                    .build());
        }
        return result;
    }

}
