package testNGoldObsolete;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_ReportersAndAsserts {

    @Test
    public void testStrings(){
        String actualValue = "Test Reporters And Asserts";
        Reporter.log("The actual String is " + actualValue, true);
        Assert.assertEquals(actualValue, "Test Reporters And Asserts");
        Reporter.log("Verifing the actual String with expected value", true);
    }

    @Test
    public void testInt(){
        int actualInt = 10;
        Reporter.log("The actual Integer is " + actualInt, true);
        Assert.assertEquals(actualInt, 10);
        Reporter.log("Verifing the actual Integer with expected value", true);
    }

    @Test
    public void testArrays(){
        int[] actualArray = {1,2,3};
        int[] expectedArray = {1,2,3};
        Reporter.log("The actual Array is " + actualArray, true);
        Assert.assertEquals(actualArray,expectedArray);
        Reporter.log("Verifing the actual array with expected value", true);
    }
}
