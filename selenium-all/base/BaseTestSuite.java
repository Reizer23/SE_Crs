package base;

import org.testng.annotations.*;

public class BaseTestSuite {

    @BeforeClass
    public void beforeClass(){
        System.out.println("BaseTestSuite -> Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("BaseTestSuite -> After Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BaseTestSuite -> Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("BaseTestSuite -> After Test");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BaseTestSuite -> Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("BaseTestSuite -> After Suite");
    }
}
