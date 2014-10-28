package junit4.homework.task3;

import org.testng.annotations.DataProvider;
import com.homework.task2.Person;
import com.homework.task2.Position;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rteresch on 27.10.2014.
 */
public class DataForJoinUtilTest {
    @DataProvider(name = "DataForOnlyEqualPersons")
    public static Object[][] createData() {
        // First set of data - only 1 pair is equal
        ArrayList<Person> p1 = new ArrayList<>();
        ArrayList<Person> p2 = new ArrayList<>();
        ArrayList<Person> expectedResult1 = new ArrayList<>();

        p1.add(new Person.Builder().firstName("Roma").secondName("rteresch").personAge(28).personPost(Position.DEVELOPER).build());
        p1.add(new Person.Builder().firstName("Tany").secondName("Voytenko").personAge(25).personPost(Position.DEVELOPER).build());
        p2.add(new Person.Builder().firstName("Tany").secondName("Voytenko").personAge(25).personPost(Position.DEVELOPER).build());
        p2.add(new Person.Builder().firstName("Katy").secondName("Smirnova").personAge(18).personPost(Position.QA).build());
        p2.add(new Person.Builder().firstName("Katy").secondName("Smirnova").personAge(18).personPost(Position.QA).build());
        expectedResult1.add(p1.get(1));

        // Second set of data - both lists of Persons are totally different
        ArrayList<Person> p3 = new ArrayList<>();
        ArrayList<Person> p4 = new ArrayList<>();
        ArrayList<Person> expectedResult2 = new ArrayList<>();

        p3.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p3.add(new Person.Builder().firstName("Rustem").secondName("Ruslanovich").personAge(21).personPost(Position.QA).build());
        p3.add(new Person.Builder().firstName("Ruslan").secondName("Rustemovich").personAge(22).personPost(Position.QA).build());
        p4.add(new Person.Builder().firstName("Anna").secondName("Alinovna").personAge(23).personPost(Position.DIRECTOR).build());
        p4.add(new Person.Builder().firstName("Alina").secondName("Annovna").personAge(24).personPost(Position.DEVELOPER).build());
        p4.add(new Person.Builder().firstName("Alla").secondName("Balovna").personAge(25).personPost(Position.QA).build());


        // Third set of data - all Persons are equal
        ArrayList<Person> p5 = new ArrayList<>();
        ArrayList<Person> p6 = new ArrayList<>();
        ArrayList<Person> expectedResult3 = new ArrayList<>();


        p5.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p5.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p5.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p6.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p6.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p6.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p6.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        expectedResult3.addAll(p5);

        // Fourth set of data - both lists of Persons are empty
        ArrayList<Person> p7 = new ArrayList<>();
        ArrayList<Person> p8 = new ArrayList<>();
        ArrayList<Person> expectedResult4 = new ArrayList<>();

        // Fifth test on null references
        ArrayList<Person> p9 = null;
        ArrayList<Person> p10 = null;
        ArrayList<Person> expectedResult5 = new ArrayList<>();

        // 5 tests with 3 params
        return new Object[][]
                       {{p1, p2, expectedResult1},
                        {p3, p4, expectedResult2},
                        {p5, p6, expectedResult3},
                        {p7, p8, expectedResult4},
                        {p9,p10, expectedResult5}};
    }



    @DataProvider(name = "DataForOnlyDifferentPersons")
    public static Object[][] createDataForDifferentPersons() {
        // First set of data - only 1 pair is equal
        ArrayList<Person> p1 = new ArrayList<>();
        ArrayList<Person> p2 = new ArrayList<>();
        ArrayList<Person> expectedResult1 = new ArrayList<>();

        p1.add(new Person.Builder().firstName("Roma").secondName("rteresch").personAge(28).personPost(Position.DEVELOPER).build());
        p1.add(new Person.Builder().firstName("Tany").secondName("Voytenko").personAge(25).personPost(Position.DEVELOPER).build());
        p2.add(new Person.Builder().firstName("Tany").secondName("Voytenko").personAge(25).personPost(Position.DEVELOPER).build());
        p2.add(new Person.Builder().firstName("Katy").secondName("Smirnova").personAge(18).personPost(Position.QA).build());
        p2.add(new Person.Builder().firstName("Katy").secondName("Smirnova").personAge(18).personPost(Position.QA).build());
        Collections.addAll(expectedResult1,p1.get(0),p2.get(1),p2.get(2));

        // Second set of data - both lists of Persons are totally different
        ArrayList<Person> p3 = new ArrayList<>();
        ArrayList<Person> p4 = new ArrayList<>();
        ArrayList<Person> expectedResult2 = new ArrayList<>();

        p3.add(new Person.Builder().firstName("Roma").secondName("Romanovich").personAge(20).personPost(Position.DIRECTOR).build());
        p3.add(new Person.Builder().firstName("Rustem").secondName("Ruslanovich").personAge(21).personPost(Position.QA).build());
        p3.add(new Person.Builder().firstName("Ruslan").secondName("Rustemovich").personAge(22).personPost(Position.QA).build());
        p4.add(new Person.Builder().firstName("Anna").secondName("Alinovna").personAge(23).personPost(Position.DIRECTOR).build());
        p4.add(new Person.Builder().firstName("Alina").secondName("Annovna").personAge(24).personPost(Position.DEVELOPER).build());
        p4.add(new Person.Builder().firstName("Alla").secondName("Balovna").personAge(25).personPost(Position.QA).build());
        expectedResult2.addAll(p3);
        expectedResult2.addAll(p4);

        // Third set of data - all Persons are equal
        ArrayList<Person> p5 = new ArrayList<>();
        ArrayList<Person> p6 = new ArrayList<>();
        ArrayList<Person> expectedResult3 = new ArrayList<Person>(){};


          p5.add(new Person.Builder().firstName("Roma").secondName("Tereschenko").personAge(20).personPost(Position.DIRECTOR).build());
          p5.add(new Person.Builder().firstName("Roma").secondName("Tereschenko").personAge(20).personPost(Position.DIRECTOR).build());;
          p6.add(new Person.Builder().firstName("Roma").secondName("Tereschenko").personAge(20).personPost(Position.DIRECTOR).build());
          p6.add(new Person.Builder().firstName("Roma").secondName("Tereschenko").personAge(20).personPost(Position.DIRECTOR).build());

        // Fourth set of data - both lists of Persons are empty
        ArrayList<Person> p7 = new ArrayList<>();
        ArrayList<Person> p8 = new ArrayList<>();
        ArrayList<Person> expectedResult4 = new ArrayList<>();

        // Fifth set of data - test on null references
        ArrayList<Person> p9 = null;
        ArrayList<Person> p10 = null;
        ArrayList<Person> expectedResult5 = new ArrayList<>();

        // 5 tests with 3 params
        return new Object[][]
                       {{p1, p2, expectedResult1},
                        {p3, p4, expectedResult2},
                        {p5, p6, expectedResult3},
                        {p7, p8, expectedResult4},
                        {p9,p10, expectedResult5}};
    }
}