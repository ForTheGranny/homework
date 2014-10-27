package junit4.homework.task3;


import static org.testng.Assert.*;
import org.testng.annotations.*;
import roman.homework.task2.Person;
import roman.homework.task4.JoinUtil;
import roman.homework.task4.PersonHelper;

import java.util.ArrayList;
import java.util.List;

public class JoinUtilTest {
    JoinUtil util;
    PersonHelper delegateService;

    @BeforeTest
    public void initData(){
    util = new JoinUtil();
    delegateService = new PersonHelper(util);
    }

    @Test(groups = {"PersonsTests"}, dataProvider ="PersonsProvider", dataProviderClass = DataForJoinUtilTest.class)
    public void testInnerJoin(List<Person> p1, List<Person> p2, ArrayList<Person> expectedResult) throws Exception {
        // invoke method on a class to test
        List<Person> actualResult = delegateService.onlyEqualPersons(p1, p2);
        // assert return value
        assertEquals(actualResult,expectedResult,"Fails when one of array's reference is null");
    }
}

