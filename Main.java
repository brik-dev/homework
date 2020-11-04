package lesson_1.homework;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Задание 1: Написать метод, который меняет два элемента массива местами.
 * Задание 2: Написать метод, который преобразует массив в ArrayList;
 * Задание 3: Большая задача.
 */

public class Main {
    public static void main(String[] args) {

        // Задание 1:
        System.out.println("Задание 1: ");
        System.out.println("*** Исходный массив ***");
        String[] arr = {"A", "B", "C", "D"};
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        System.out.println("*** Измененный массив ***");
        changeOrderOfItems(0, 3, arr);
        System.out.println();

        // Задание 2:
        System.out.println("Задание 2: ");
        transformToArrayList(arr);
        System.out.println();

        // Задание 3:
        System.out.println("Задание 3: ");

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        ArrayList<Apple> arrApples = new ArrayList<Apple>();
        arrApples.add(apple1);
        arrApples.add(apple2);
        arrApples.add(apple3);

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        ArrayList<Orange> arrOranges = new ArrayList<Orange>();
        arrOranges.add(orange1);
        arrOranges.add(orange2);
        arrOranges.add(orange3);


        Box<Apple> boxWithApples = new Box<Apple>(arrApples);

        Box<Orange> boxWithOranges = new Box<>(arrOranges);

        System.out.println(boxWithApples.getWeight());
        System.out.println(boxWithApples.compare(boxWithOranges));


    }

    private static void changeOrderOfItems(int item1, int item2, String[] arr) {
        String buffer;
        try{
            buffer = arr[item1];
            arr[item1] = arr[item2];
            arr[item2] = buffer;
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i]);
            }
            System.out.println();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void transformToArrayList(String[] arrString) {

        ArrayList<String> list = new ArrayList<>();
        for (String b : arrString) {
            list.add(b);
        }
        System.out.println(list);
    }
}
