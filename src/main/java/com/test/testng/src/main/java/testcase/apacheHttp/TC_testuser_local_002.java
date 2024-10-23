package com.test.testng.src.main.java.testcase.apacheHttp;

import org.testng.annotations.*;

public class TC_testuser_local_002 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass2");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod2");
    }

    @Test
    public void test(){
        System.out.println("test2");
    }
}
