import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import roman.homework.task3.JoinUtil;

import static org.junit.Assert.*;

/*Дополнительные сценарии поведения:
        - пустой первый массив
        - пустой второй массив
        - первый массив - null
        - второй массив - null
        - большой второй массив (size IInteger.MAX_VALUE)
        - большой первый массив (size IInteger.MAX_VALUE)
        - тест с дубликатами*/


public class JoinUtilTest {
    JoinUtil util;
    int[] firstArray;
    int[] secondArray;
    int[] leftArray;
    int[] rightArray;

    @Before
    public void setUp() throws Exception {
        // initialize variable inputs
        firstArray = new int[]{1,5,4,23,65,32,78};
        secondArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        leftArray = new int[]{1,4,8,7,9};
        rightArray = new int[]{11,4,7,10,0};


        // initialize class to test
        util = new JoinUtil();
    }

    @After
    public void tearDown() throws Exception {
        // clean data
        firstArray = null;
        secondArray = null;
        leftArray =  null;
        rightArray = null;

        // clean reference;
        util = null;
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
    public void testIsAlreadyExistOnNullReference() throws Exception {
        // initialize variable inputs
        secondArray = null;
        // invoke method on a class to test
        boolean actualResult = util.isAlreadyExist(secondArray, 3);
        // assert return value
        assertFalse("Fails if true is returned",actualResult);
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
    public void testInnerJoinOnNullLeftReference() throws Exception {
        int[] expectedResult = new int[0];
        // invoke method on a class to test
        int[] actualResult = util.innerJoin(null,secondArray);
        // assert return value
        assertArrayEquals("The expected result is {5,4,1,32}",expectedResult,actualResult);
    }

    @Test
    public void testInnerJoinOnNullRightReference() throws Exception {
        int[] expectedResult = new int[0];
        // invoke method on a class to test
        int[] actualResult = util.innerJoin(firstArray,null);
        // assert return value
        assertArrayEquals("The expected result is {5,4,1,32}",expectedResult,actualResult);
    }

    @Test
    public void testInnerJoinOnEmptyLeftArray() throws Exception {
        // initialize variable inputs
        firstArray =  new int[0];
        int[] expectedResult = new int[0];
        // invoke method on a class to test
        int[] actualResult = util.innerJoin(firstArray,secondArray);
        // assert return value
        assertArrayEquals("The expected result is {5,4,1,32}",expectedResult,actualResult);
    }

    @Test
    public void testInnerJoinOnEmptyRightArray() throws Exception {
        // initialize variable inputs
        secondArray =  new int[0];
        int[] expectedResult = new int[0];
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
    public void testOuterJoinOnNullLeftReference() throws Exception {
        // initialize variable inputs
        int[] expectedResult = secondArray;
        // invoke method on a class to test
        int[] actualResult = util.outerJoin(null, secondArray);
        // assert return value
        assertArrayEquals("Fails if it does not match with {23,65,78,3,24,2,34,45}",expectedResult,actualResult);
    }

    @Test
    public void testOuterJoinOnNullRightReference() throws Exception {
        int[] expectedResult = firstArray;
        // invoke method on a class to test
        int[] actualResult = util.outerJoin(firstArray, null);
        // assert return value
        assertArrayEquals("Fails if it does not match with {23,65,78,3,24,2,34,45}",expectedResult,actualResult);
    }


    @Test
    public void testOuterJoinOnEmptyLeftArray() throws Exception {
        // initialize variable inputs !
        firstArray = new int[0];
        int[] expectedResult = secondArray;
        // invoke method on a class to test
        int[] actualResult = util.outerJoin(firstArray, secondArray);
        // assert return value
        assertArrayEquals("Fails if it does not match with {23,65,78,3,24,2,34,45}",expectedResult,actualResult);
    }

    @Test
    public void testOuterJoinOnEmptyRightArray() throws Exception {
        // initialize variable inputs !
        secondArray = new int[0];
        int[] expectedResult = firstArray;
        // invoke method on a class to test
        int[] actualResult = util.outerJoin(firstArray, secondArray);
        // assert return value
        assertArrayEquals("Fails if it does not match with {23,65,78,3,24,2,34,45}",expectedResult,actualResult);
    }

    @Test
    public void testMerge() throws Exception {
        // initialize variable inputs
        int[] expectedResult = new int[]{1, 5, 4, 23, 65, 32, 78, 3, 24, 2, 34, 45};
        // invoke method on a class to test
        int[] actualResult = util.merge(firstArray, secondArray);
        // assert return value
        assertArrayEquals("Fails if it does not match with {1, 5, 4, 23, 65, 32, 78, 3, 24, 2, 34, 45}",expectedResult,actualResult);
    }

    @Test
    public void testMergeOnNullLeftReference() throws Exception {
        int[] expectedResult = secondArray;
        // invoke method on a class to test
        int[] actualResult = util.merge(null, secondArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult,actualResult);
    }

    @Test
    public void testMergeOnNullRightReference() throws Exception {
        int[] expectedResult = firstArray;
        // invoke method on a class to test
        int[] actualResult = util.merge(firstArray, null);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult,actualResult);
    }

    @Test
    public void testMergeOnEmptyLeftArray() throws Exception {
        firstArray = new int[0];
        int[] expectedResult = secondArray;
        // invoke method on a class to test
        int[] actualResult = util.merge(firstArray, secondArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult,actualResult);
    }

    @Test
    public void testMergeOnEmptyRightArray() throws Exception {
        secondArray = new int[0];
        int[] expectedResult = firstArray;
        // invoke method on a class to test
        int[] actualResult = util.merge(firstArray, secondArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult,actualResult);
    }

     @Test
    public void testLeftUnion() throws Exception {
        int[] expectedResult = new int[]{1,4,8,7,9,4,7};
        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);
        // assert
        assertArrayEquals("Fails if it does not return {1,4,8,7,9,4,7}",expectedResult, actualResult);
    }


    @Test
    public void testLeftUnionOnEmptyLeftArray() throws Exception {
        // Input variables
        leftArray =  new int[0];
        int[] expectedResult = new int[0];
        // init class
        JoinUtil util = new JoinUtil();
        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult, actualResult);
    }

    @Test
    public void testLeftUnionOnEmptyRightArray() throws Exception {
        // Input variables
        rightArray =  new int[0];
        int[] expectedResult = leftArray;
        // init class
        JoinUtil util = new JoinUtil();
        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult, actualResult);
    }


    @Test
    public void testLeftUnionOnNullLeftReference() throws Exception {
        // Input variables
        leftArray =  null;
        int[] expectedResult = new int[0];
        // init class
        JoinUtil util = new JoinUtil();
        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult, actualResult);
    }

    @Test
    public void testLeftUnionOnNullRightReference() throws Exception {
        // Input variables
        rightArray =  null;
        int[] expectedResult = leftArray;
        // init class
        JoinUtil util = new JoinUtil();
        // invoke method
        int[] actualResult = util.leftJoin(leftArray,rightArray);
        // assert
        assertArrayEquals("Fails if it does not return an empty array",expectedResult, actualResult);
    }
}

