package junit4.homework.task3;

import org.testng.annotations.DataProvider;
import roman.homework.task2.Person;
import roman.homework.task2.Position;

import java.util.ArrayList;

/**
 * Created by rteresch on 27.10.2014.
 */
public class DataForJoinUtilTest {
    @DataProvider(name = "PersonsProvider")
    public static Object[][] createData() {
        // First set of data to test Persons
        ArrayList<Person> p1 = new ArrayList<>();
        ArrayList<Person> p2 = new ArrayList<>();
        ArrayList<Person> expectedResult1 = new ArrayList<>();

        p1.add( new Person.Builder().firstName("Roma").secondName("rteresch").personAge(28).personPost(Position.DEVELOPER).build());
        p1.add( new Person.Builder().firstName("Tany").secondName("Voytenko").personAge(25).personPost(Position.DEVELOPER).build());
        p2.add( new Person.Builder().firstName("Tany").secondName("Voytenko").personAge(25).personPost(Position.DEVELOPER).build());
        p2.add( new Person.Builder().firstName("Katy").secondName("Smirnova").personAge(18).personPost(Position.QA).build());
        p2.add( new Person.Builder().firstName("Katy").secondName("Smirnova").personAge(18).personPost(Position.QA).build());
        expectedResult1.add(p1.get(1));

        //Second set of data to test Persons
        ArrayList<Person> p3 = new ArrayList<>();
        ArrayList<Person> p4 = new ArrayList<>();
        ArrayList<Person> expectedResult2 = new ArrayList<>();

        p3.add( new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p3.add( new Person.Builder().firstName("Rustem").secondName("Ruslanovich").personAge(21).personPost(Position.QA).build());
        p3.add( new Person.Builder().firstName("Ruslan").secondName("Rustemovich").personAge(22).personPost(Position.QA).build());
        p4.add( new Person.Builder().firstName("Anna").secondName("Alinovna").personAge(23).personPost(Position.DIRECTOR).build());
        p4.add( new Person.Builder().firstName("Alina").secondName("Annovna").personAge(24).personPost(Position.DEVELOPER).build());
        p4.add( new Person.Builder().firstName("Alla").secondName("Balovna").personAge(25).personPost(Position.QA).build());

        return new Object[][]
                            {{p1,p2, expectedResult1},
                             {p3,p4, expectedResult2}};
    }
}