package tests;

import org.testng.annotations.*;

public class AnnotationsDemo {


    @BeforeSuite
    public void setupSuite(){
        System.out.println("Set up suite");
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("Teardown suite");
    }


    @BeforeTest  // @BeforeTest vs @BeforeMethod  -> before <test> tag vs before each @Test method
    public void setupTestGroups(){
        System.out.println("Set up test group");
    }

    @AfterTest
    public void teardownTestGroups(){
        System.out.println("Teardown test group");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Set up class");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("Tear down class");
    }

    @BeforeMethod     // @BeforeTest vs @BeforeMethod  -> before <test> tag vs before each @Test method
    public void setUpMethod(){
        System.out.println("Set up method");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("Tear down method");
    }

    @Test
    public void test1(){
        System.out.println("test 1");
    }

    @Test
    public void test2(){
        System.out.println("test 2");
    }

    @Test
    public void test3(){
        System.out.println("test 3");
    }



}
