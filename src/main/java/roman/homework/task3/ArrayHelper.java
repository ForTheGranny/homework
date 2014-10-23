package roman.homework.task3;

import roman.homework.task2.Person;

/**
 * Created by Танечка on 21.10.2014.
 */
public class ArrayHelper {

      JoinUtil<Person> util;
      Person[] p1;
      Person[] p2;


     public ArrayHelper(Person[] p1, Person[] p2) {
         this.p1 = p1;
         this.p2 = p2;
     }

    public void compareTwoPersons(){
        if(this.p1 != null && this.p2 != null) {
            Person[] result = util.merge(this.p1, this.p2);
            System.out.println(result.toString());
        } else if( p1 == null)
            System.out.println("Person p1 is null");
          else
            System.out.println("Person p2 is null");
    }


}
