package com.comics.jiabin;

import com.comics.jiabin.testcases.BaseTest;
import com.comics.jiabin.testcases.DriverTest;
import com.comics.jiabin.testcases.youxTest;
import org.testng.TestNG;
public class Entry {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        Class[] classes = {BaseTest.class, youxTest.class, DriverTest.class};
        testNG.setTestClasses(classes);
        testNG.run();
    }
}
