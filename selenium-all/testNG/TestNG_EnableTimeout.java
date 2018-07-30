package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_EnableTimeout {

    @BeforeClass
    public void setUp(){
        System.out.println("Before class");
    }

    @AfterClass
    public void cleanUp(){
        System.out.println("After class");
    }

    @Test(enabled = false)
    public void testMethod1(){
        System.out.println("Test Method 1");
    }

    @Test(timeOut = 100) //if the test is more than the time set, it will fail
    public void testMethod2() throws InterruptedException {
        System.out.println("Test Method 2");
        Thread.sleep(200);
    }
}
