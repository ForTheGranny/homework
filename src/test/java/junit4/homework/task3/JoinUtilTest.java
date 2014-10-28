package junit4.homework.task3;


import static org.testng.Assert.*;
import org.testng.annotations.*;
import com.homework.task2.Person;
import com.homework.task4.JoinUtil;
import com.homework.task4.PersonHelper;

import java.util.List;

public class JoinUtilTest {
    JoinUtil util;
    PersonHelper delegateService;

    @BeforeTest
    public void initData(){
    util = new JoinUtil();
    delegateService = new PersonHelper(util);
    }

    @Test(groups = {"PersonsTests"}, dataProvider ="DataForOnlyEqualPersons", dataProviderClass = DataForJoinUtilTest.class)
    public void testInnerJoin(List<Person> p1, List<Person> p2, List<Person> expectedResult) throws Exception {
        // invoke method on a class to test
        List<Person> actualResult = delegateService.onlyEqualPersons(p1,p2);
        // assert return value
        assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"PersonsTests"}, dataProvider ="DataForOnlyDifferentPersons", dataProviderClass = DataForJoinUtilTest.class)
    public void testOuterJoin(List<Person> p1, List<Person> p2, List<Person> expectedResult) throws Exception {
        // invoke method on a class to test
        List<Person> actualResult = delegateService.onlyDifferentPersons(p1,p2);
        // assert return value
        assertEquals(actualResult,expectedResult);
    }
}

