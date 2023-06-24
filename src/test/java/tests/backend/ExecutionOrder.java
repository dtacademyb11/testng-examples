package tests.backend;

import org.testng.annotations.Test;

public class ExecutionOrder {



    // default order of execution - alphabetical(ascii table order)

    @Test (priority = -1)
    public void test1(){
        System.out.println("test 1");
    }

    @Test (priority = 20)
    public void test2_testUsername(){
        System.out.println("test 2");
    }

    @Test (priority = -150)
    public void test3(){
        System.out.println("test 3");
    }

    @Test (priority = 4)
    public void tc_test002_ui_testUsername(){
        System.out.println("test");
    }

    @Test // default priority is 0, and if there are 2 same priorities then the order will be alphabetic
    public void test0(){
        System.out.println("test 0");
    }

    @Test (priority = 6)
    public void test29(){
        System.out.println("test 29");
    }
}
