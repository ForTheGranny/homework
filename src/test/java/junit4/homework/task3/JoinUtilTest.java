package junit4.homework.task3;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import roman.homework.task3.JoinUtil;
import roman.homework.task3.my.exception.IllegalArrayForMergeOperation;

public class JoinUtilTest {
    JoinUtil util;
    int[] firstArray;
    int[] secondArray;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        // initialize variable inputs
        firstArray = new int[]{1,5,4,23,65,32,78};
        secondArray = new int[]{3,5,24,4,1,2,34,45,32,5};

        // initialize class to test
        util = new JoinUtil();
    }

    @Test
    public void testIsNull() throws Exception {
        // invoke method on a class to test
        boolean actualResult = util.isNull(null,secondArray);
        // assert return value
        assertTrue("Fails when one of array's reference is null",actualResult);
    }

    @Test
    public void testIsAlreadyExist() throws Exception {
        // invoke method on a class to test
        boolean actualResult = util.isAlreadyExist(secondArray, 3);
        // assert return value
       assertTrue("Fails if the number does not exist",actualResult);
    }

    @Test
    public void testInnerJoin() throws Exception {
        // initialize variable inputs
        int[] expectedResult = new int[]{1,5,4,32};
        // invoke method on a class to test
        int[] actualResult = util.innerJoin(firstArray,secondArray);
        // assert return value
        assertArrayEquals("The expected result is {5,4,1,32}",expectedResult,actualResult);
    }

    @Test
    public void testOuterJoin() throws Exception {
        // initialize variable inputs
        int[] expectedResult = new int[]{23,65,78,3,24,2,34,45};
        // invoke method on a class to test
        int[] actualResult = util.outerJoin(firstArray, secondArray);
        // assert return value
        assertArrayEquals("Fails if it does not match with {23,65,78,3,24,2,34,45}",expectedResult,actualResult);
    }

    @Test
    public void testMerge() throws IllegalArrayForMergeOperation {
        // initialize variable inputs
        int[] expectedResult = new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 2, 34, 45};
        // invoke method on a class to test
        int[] actualResult = util.merge(firstArray, secondArray);
        // assert return value
        assertArrayEquals("Fails if it does not match with {1, 5, 4, 23, 65, 32, 78, 3, 24, 2, 34, 45}",expectedResult,actualResult);
    }

    @Test
    public void testMergeOnNullReference() throws IllegalArrayForMergeOperation {
        // can be used (expected = IllegalArrayForMergeOperation.class)
        exception.expect(IllegalArrayForMergeOperation.class);
        exception.expectMessage("firstArray reference is null");
        // invoke method on a class to test
        int[] actualResult = util.merge(null, secondArray);
    }
    
     @Test
    public void testLeftUnion(){
        // Input variables
        int[] leftArray = new int[]{1,4,8,7,9};
        int[] rightArray = new int[]{11,4,7,10,0};
        int[] expectedValues = new int[]{1,4,8,7,9,4,7};

        // init class
        JoinUtil util = new JoinUtil();

        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);

        // assert
        assertArrayEquals(expectedValues, actualResult);
    }

    @Test
    public void testLeftUnionOnNull(){
        // Input variables
        int[] leftArray =  new int[0];
        int[] rightArray = new int[]{11,4,7,10,0};
        int[] expectedValues = new int[0];

        // init class
        JoinUtil util = new JoinUtil();

        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);
        // assert
        assertArrayEquals(expectedValues, actualResult);
    }
}
