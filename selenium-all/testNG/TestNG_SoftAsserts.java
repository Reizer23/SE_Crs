package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_SoftAsserts {

    //This is to run all test with fail results
    @Test
    public void testSum(){
        SoftAssert sa = new SoftAssert();
        System.out.println("RunningTest -> testSum");
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1,2);
        sa.assertEquals(result, 2);
        System.out.println("Line after assert 1");
        sa.assertEquals(result, 3);
        System.out.println("Line after assert 2");
        sa.assertAll();
    }
}
