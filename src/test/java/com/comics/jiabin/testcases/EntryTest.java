package com.comics.jiabin.testcases;

import com.comics.jiabin.testcases.BaseTest;
import com.comics.jiabin.testcases.DriverTest;
import com.comics.jiabin.testcases.youxTest;
import org.testng.TestNG;
public class EntryTest {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        Class[] classes = {BaseTest.class, youxTest.class, DriverTest.class};
        testNG.setTestClasses(classes);
        testNG.run();
    }
}
