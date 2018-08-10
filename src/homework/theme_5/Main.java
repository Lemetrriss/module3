package homework.theme_5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    private static void printData(Object myClass){
        try {
            Method method = MyTest.class.getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s = "blablabla";
        try {
            Field ff = String.class.getDeclaredField("value");
            ff.setAccessible(true);
            for (char ch : (char[])ff.get(s)) {
                System.out.print(ch+" ");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] f = String.class.getDeclaredFields();
        for (Field field : f) {
            try {
                field.setAccessible(true);
                System.out.println(field.getType().getSimpleName() + " " + field.getName() + " " + field.get(s));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        MyTest myTest = new MyTest();
        System.out.println(MyTest.class.getName());

        try {
            Field fieldd = myTest.getClass().getDeclaredField("name");
            fieldd.setAccessible(true);
            fieldd.set(myTest, "Oleg");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Field[] field = MyTest.class.getDeclaredFields();
        try {
            Field field2 = MyTest.class.getDeclaredField("name");
            field2.setAccessible(true);
            String temp = (String) field2.get(myTest);
            Field value = temp.getClass().getDeclaredField("value");
            value.setAccessible(true);
            value.set(temp, "qwerty".toCharArray());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Field field1 : field) {
            try {
                field1.setAccessible(true);
                System.out.println(field1.getName() + " " + field1.getType().getSimpleName() + " " + field1.get(myTest));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        printData(myTest);

        MyTest2 test2 = null;

//Code for DEFAULT constructor, without parameters;
        try {
            Class clazz = Class.forName(MyTest2.class.getName());
            test2 = (MyTest2) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Class clazz = Class.forName(MyTest2.class.getName());
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor.getName());
                if(constructor.getParameterCount()==0){
                    System.out.println("Default");
                    continue;
                }
                Class[] parameterTypes = constructor.getParameterTypes();
                if(parameterTypes.length==2){
                    test2 = (MyTest2) constructor.newInstance("Igor", "Vasiljev");
                }
                for (Class parameterType : parameterTypes) {
                    System.out.print(parameterType.getSimpleName() + " ");
                }
                System.out.println();
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(test2);
    }
}

class MyTest{
    private String name = "Dima";
    private String lastName = "Dmitrenko";
    private String gender = "male";
    private int age = 35;
    private int weight = 67;

    private void printData(){
        System.out.println(name + " " + lastName + " " + gender + " " + age + " " + weight);
    }
}

class MyTest2{
    private String name;
    private String lastName;
    private int age;

    public MyTest2() {
    }

    public MyTest2(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public MyTest2(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyTest2{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}