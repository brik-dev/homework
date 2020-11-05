package lesson_1.homework;

import java.util.ArrayList;

/**
 * Задание 1: Написать метод, который меняет два элемента массива местами.
 * Задание 2: Написать метод, который преобразует массив в ArrayList;
 * Задание 3: Большая задача.
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
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
        Box<Apple> boxWithApples = new Box<Apple>(apple1,apple2,apple3);

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Box<Orange> boxWithOranges = new Box<>(orange1,orange2,orange3);

        System.out.println(boxWithApples.getWeight());
        System.out.println(boxWithOranges.getWeight());
        System.out.println(boxWithApples.compare(boxWithOranges));

        Box<Apple> boxWithApples2 = new Box<Apple>();
        boxWithApples.transferToAnotherBox(boxWithApples2);
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
