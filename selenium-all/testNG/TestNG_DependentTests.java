package testNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_DependentTests {

    SomeClassToTest obj;

    @BeforeClass
    public void setUp(){
        obj = new SomeClassToTest();
        System.out.println("Before class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("After class");
    }

    @Test(dependsOnMethods = {"testMethod2"}, alwaysRun = true)
    public void testMethod1(){
        System.out.println("Method 1");

    }

    @Test
    public void testMethod2(){
        System.out.println("Method 2");
        int result = obj.sumNumbers(1,2);
        Assert.assertEquals(result,2);
    }

    @Test(dependsOnMethods = {"testMethod1"})
    public void testMethod3(){
        System.out.println("Method 3");
    }

    @Test//(dependsOnMethods = {"testMethod3"})
    public void testMethod4(){
        System.out.println("Method 4");
    }
}
