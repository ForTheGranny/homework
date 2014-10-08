package roman.homework.task2;

/**
 * Created by Roman Tereschnko on 10/9/2014.
 */
public class Main {

    // Performs comparison for Persons using equals(), passed object can be checked using instanceof on type relation as well
    private static boolean comparePersons(Person p1,Person p2){
        if((p1 != null && p2 != null))
            return p1.equals(p2);
        else
            return false;
    }

    public static void main(String[] args){
        Person p1 = new Person();
        Person p2 = new Person();


        //
        if(p1 != null && p2 != null) {
            System.out.println("Comparison by equals() - " + comparePersons(p1, p2));

            // Compare persons using hashcode()
            System.out.println("Comparison by hashcode() - " + (p1.hashCode()== p2.hashCode()));

            // Compare persons using == (by reference)
            System.out.println("Comparison by == (reference) - " + (p1 == p2));
        }
    }
}
