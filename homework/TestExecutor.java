package lesson_g.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestExecutor {

    private static Object object;

    public static void start(Class cls){
        if(!areBeforeAfterSuiteCorrect(cls)){
            throw new RuntimeException("@BeforeSuite or @AfterSuite are not available");
        }

        try {
            object = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Method beforeAnnotation = null;
        Method afterAnnotation = null;
        Method[] objectMethods = cls.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();

        for (Method m : objectMethods) {
            if(m.getAnnotation(BeforeSuite.class) != null){
                beforeAnnotation = m;
            }else if(m.getAnnotation(AfterSuite.class) != null){
                afterAnnotation = m;
            }else if(m.getAnnotation(Test.class) != null){
                testMethods.add(m);
            }

            testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority())); // разобраться с сортировкой

            if(beforeAnnotation != null){
                testMethods.add(0, beforeAnnotation);
            }

            if(afterAnnotation != null){
                testMethods.add(afterAnnotation);
            }

            for (Method testMethod : testMethods) {
                if (Modifier.isPrivate(testMethod.getModifiers())) {
                    testMethod.setAccessible(true);
                }
                try {
                    testMethod.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static boolean areBeforeAfterSuiteCorrect(Class cls) {

        int beforeAnnotationCount = 0;
        int afterAnnotationCount = 0;

        for (Method m : cls.getDeclaredMethods()) {
            if(m.getAnnotation(BeforeSuite.class) != null){
                beforeAnnotationCount++;
            }
            if(m.getAnnotation(AfterSuite.class) != null){
                afterAnnotationCount++;
            }
        }
        return (beforeAnnotationCount < 2) && (afterAnnotationCount < 2);
    }

}
