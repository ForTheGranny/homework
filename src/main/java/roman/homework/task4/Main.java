package roman.homework.task4;

import roman.homework.task2.Person;
import roman.homework.task2.Position;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Roman Tereschenko on 10/23/2014.
 */
public class Main {

    private static List<Person> getPersons(int quantity){
        if(quantity == 0)
            return new ArrayList<>();

        char[] alphabet = "abc".toCharArray();   //efghijklmnopqrstuvwxyz
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
            for (int i = 0; i < 4; i++) {
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

    public static void main(String[] args) {
        List<Person> p1 = new ArrayList<>();
                     p1.add(new Person.Builder()
                             .firstName("Roma")
                             .secondName("rteresch")
                             .personAge(10)
                             .personPost(Position.DEVELOPER)
                             .build());
                     p1.add(new Person.Builder()
                             .firstName("B")
                             .secondName("Bs")
                             .personAge(7)
                             .personPost(Position.QA)
                             .build());
        List<Person> p2 = new ArrayList<>();
                    p2.add(new Person.Builder()
                            .firstName("Roma")
                            .secondName("rteresch")
                            .personAge(10)
                            .personPost(Position.DEVELOPER)
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

        JoinUtil util = new JoinUtil();
//        List<Person> p1 = getPersons(100);
//        List<Person> p2 = getPersons(100);
//        List<Person> result = util.merge(p1,p2);
//        System.out.println(result.toString());
////
//        List<Person> result = util.leftJoin(p1,p2);
//        System.out.print(result.toString());
//
//        List<Person> result = util.innerJoin(p1,p2);
//        System.out.print(result.toString());

        List<Person> result = util.outerJoin(p1,p2);
        System.out.print(result.toString());
    }
}
