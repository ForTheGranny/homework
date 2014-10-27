package roman.homework.task4;

import roman.homework.task2.Person;

import java.util.List;

/**
 * Created by Roman Tereschenko on 10/27/2014.
 */
public class PersonHelper {
        JoinUtil<Person> util;
        List<Person> p1;
        List<Person> p2;


    public PersonHelper(JoinUtil<Person> util, List<Person> p1, List<Person> p2) {
        this.util = util;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void mergePersons() {
        if (this.p1 != null && this.p2 != null && this.util != null) {
            List<Person> result = util.merge(this.p1, this.p2);
            System.out.println(result.toString());
        } else if (util == null)
            throw new NullPointerException("Resource "+ util+" to delegete is null");
        else if (p1 == null)
            System.out.println("Person p1 is null");
        else
            System.out.println("Person p2 is null");
    }

    public void onlyEqualPersons() {
        if (this.p1 != null && this.p2 != null && this.util != null) {
            List<Person> result = util.innerJoin(this.p1, this.p2);
            System.out.println(result.toString());
        } else if (util == null)
            throw new NullPointerException("Resource "+ util+" to delegete is null");
        else if (p1 == null)
            System.out.println("Person p1 is null");
        else
            System.out.println("Person p2 is null");
    }

    public void onlyDifferentPersons() {
        if (this.p1 != null && this.p2 != null && this.util != null) {
            List<Person> result = util.outerJoin(this.p1, this.p2);
            System.out.println(result.toString());
        } else if (util == null)
            throw new NullPointerException("Resource "+ util+" to delegete is null");
        else if (p1 == null)
            System.out.println("Person p1 is null");
        else
            System.out.println("Person p2 is null");
    }


}