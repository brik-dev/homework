package lesson_g.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestClass {

    @Test(priority = 8)
    public void test1(){
        System.out.println("Test No 1");
    }

    @Test(priority = 5)
    public void test2(){
        System.out.println("Test No 2");
    }

    @Test(priority = 3)
    public void test3(){
        System.out.println("Test No 3");
    }

    @BeforeSuite
    public void runFirst(){
        System.out.println("This method will run first");
    }

    @AfterSuite
    public void runLast(){
        System.out.println("This method will run last");
    }
}
