package tests;

import org.junit.Assert;
import org.junit.Test;
import roman.homework.task3.JoinUtil;

import java.util.Arrays;

/**
 * Created by Танечка on 14.10.2014.
 */
public class JoinUtilTest {

    JoinUtil util = new JoinUtil();

    public static void main(String[] args) {
        JoinUtilTest utilTest = new JoinUtilTest();
        boolean[] testAssertationResults = new boolean[3];
        testAssertationResults[0] = utilTest.testInnerJoin();
        testAssertationResults[1] = utilTest.firstArrayIsEmpty();
        testAssertationResults[2] = utilTest.bothArraysAreEmpty();

        int counterOfFailedTests =0 ;
        int counterOfSuccessfulTests =0 ;
        for(boolean result : testAssertationResults){
            if(result)
                counterOfSuccessfulTests++;
            else
                counterOfFailedTests++;
        }
        System.out.println("Total test count: " + testAssertationResults.length);
        System.out.println("Successful " + counterOfSuccessfulTests);
        System.out.println("Failed: " + counterOfFailedTests);
    }

    int[] firstArray = new int[] {1,5,4,23,65,32,78};
    int[] secondArray = new int[] {3,5,24,4,1,2,34,45,32,5};

    public boolean testInnerJoin(){
        // input data
        int[] inputArrayOne = new int[] {1,5,4,23,65,32,78};
        int[] inputArrayTwo = new int[] {3,5,24,4,1,2,34,45,32,5};
        int[] expectedValues = {1,5,4,32};

        // init class
        JoinUtil util = new JoinUtil();

        // invoke method on class to test
        int[] returnedValue = util.innerJoin(inputArrayOne,inputArrayTwo);
        System.out.println("Result array: " + Arrays.toString(returnedValue));

        // assert return true
        boolean assertResult = Arrays.equals(expectedValues, returnedValue);
        System.out.println("Is test successful = " + assertResult);
        return assertResult;
    }

    public boolean firstArrayIsEmpty(){
        // input data fields
        int[] inputArrayOne = null;
        int[] inputArrayTwo = new int[] {3,5,24,4,1,2,34,45,32,5};
        int[] expectedValues = null;

        // init class
        JoinUtil util = new JoinUtil();

        // invoke method on class to test
        int[] returnedValue = util.innerJoin(inputArrayOne,inputArrayTwo);
        System.out.println("Result array: " + Arrays.toString(returnedValue));

        // assert return true
        boolean assertResult = Arrays.equals(expectedValues, returnedValue);
        System.out.println("Is test successful = " + assertResult);
        return assertResult;
    }

    public boolean bothArraysAreEmpty(){
        // input data
        int[] inputArrayOne = null;
        int[] inputArrayTwo = null;
        int[] expectedValues = null;

        // init class
        JoinUtil util = new JoinUtil();

        // invoke method on class to test
        int[] returnedValue = util.innerJoin(inputArrayOne,inputArrayTwo);
        System.out.println("Result array: " + Arrays.toString(returnedValue));

        // assert return true
        boolean assertResult = Arrays.equals(expectedValues, returnedValue);
        System.out.print("Is test successful = " + assertResult);
        return assertResult;
    }



}
