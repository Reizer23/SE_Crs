package testNG;

import org.testng.annotations.*;

public class TestNG_TestClass1 {

    @BeforeClass
    public void setUp(){
        System.out.println("TestNG_TestClass1 -> This runs once before class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("TestNG_TestClass1 -> This runs once after class");
    }

    @BeforeMethod
    public void testMethod(){
        System.out.println("TestNG_TestClass1 -> This runs before every method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("TestNG_TestClass1 -> This runs after every method");
    }

    @Test
    public void testMethod1(){
        System.out.println("Running Test -> TestNG_TestClass1 -> Test Method 1");
    }

    @Test
    public void testMethod2(){
        System.out.println("Running Test -> TestNG_TestClass1 -> Test Method 2");
    }
}
