package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Asserts {

    @Test(priority = 0)
    public void testSum(){
        System.out.println("RunningTest -> testSum");
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1,2);
        Assert.assertEquals(result, 3);
    }

    @Test(priority = 1)
    public void testStrings(){
        System.out.println("Running Test -> testStrings");
        String expectedString = "Hello World";
        SomeClassToTest obj = new SomeClassToTest();
        String result = obj.addStrings("Hello", "World");
        Assert.assertEquals(result, expectedString);
    }

    @Test(priority = 2)
    public void testArrays() {
        System.out.println("Running Test -> testArrays");
        int[] expectedArray = {1, 2, 3};
        SomeClassToTest obj = new SomeClassToTest();
        int[] result = obj.getArray();
        Assert.assertEquals(result, expectedArray);
        System.out.println("End Test -> testArrays");
    }
}
