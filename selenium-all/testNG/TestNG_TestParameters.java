package testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_TestParameters {

    @BeforeClass
    @Parameters({"browser", "platform"})
    public void setUp(String browser, String platform){
        System.out.println("TestNG_TestParameters -> Setup");
        System.out.println("1. Parameter value from xml file: " + browser);
        System.out.println("2. Parameter value from xml file: " + platform);
    }

    @Test
    @Parameters({"response"})
    public void testMethod1(String response){
        String[] stringArray = response.split(",");
        System.out.println("TestNG_TestParameters -> Test Method 1");
        System.out.println("Response from xml file: " + response);
        System.out.println("stringArray[0] from xml file: " + stringArray[0]);
        System.out.println("stringArray[1] from xml file: " + stringArray[1]);
    }
}
