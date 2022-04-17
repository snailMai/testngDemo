package com.test.testng.src.main.java;

import org.testng.annotations.*;

public class TC_testuser_local_001 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @Test
    public void test(){
        System.out.println("test");
    }
}
