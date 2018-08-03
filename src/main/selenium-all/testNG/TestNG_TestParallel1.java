package testNG;

import org.testng.annotations.Test;

public class TestNG_TestParallel1 {

    @Test
    public void testMethod1() throws InterruptedException {
        System.out.println("TestNG_TestParallel1 -> Test Method 1");
        Thread.sleep(3000);
        System.out.println("TestNG_TestParallel1 -> Test Method 1 -> More Steps");
    }

    @Test
    public void testMethod2() throws InterruptedException {
        System.out.println("TestNG_TestParallel1 -> Test Method 2");
        Thread.sleep(3000);
        System.out.println("TestNG_TestParallel1 -> Test Method 2 -> More Steps");
    }
}
