package testNG;

import org.testng.annotations.*;

public class TestNG_Priority {

    @BeforeClass
    public void setUp(){
        System.out.println("TestNG_Priority -> Before class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("TestNG_Priority -> After class");
    }

    @Test(priority = 0)
    public void testMethod1(){
        System.out.println("TestNG_Priority -> Test Method 1");
    }

    @Test(priority = 1)
    public void testMethod2(){
        System.out.println("TestNG_Priority -> Test Method 2");
    }

    @Test(priority = 2)
    public void testMethod3(){
        System.out.println("TestNG_Priority -> Test Method 3");
    }
}
