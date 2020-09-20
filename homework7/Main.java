package com.company.brik.homework7;

import java.util.Scanner;

/**
 * Домашнее задание No 7
 * 1. Расширить задачу про котов и тарелки с едой
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
 * 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

public class Main
{
    public static void main(String[] args) {
        int answer = 1;
        int addition;
        Scanner scanner = new Scanner(System.in);
        /**
         * 1. Расширить задачу про котов и тарелки с едой: Добавили котов, создали одну тарелку.
         * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
         */

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", 10);
        cats[1] = new Cat("Murzij", 20);
        cats[2] = new Cat("Ryzhik", 30);
        Plate plate = new Plate(95);

        /**
         * Блок кода, помогающий осуществить задание 2 - Количество еды в тарелки не становится отрицательным.
         * При этом выводится информация о сытости котов.
         */
        /*for(int i = 0; i < cats.length; i++)
        {
            cats[i].eat(plate);
            plate.info();
        }*/

        /**
         * Блок кода, помогающий осуществить задание 6 - добавлять еду с тарелку.
         * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
         * При этом выводится информация о сытости котов и наполнености тарелки.
         * Если кот не поел, потому что не достаточно в тарелке еды, выходит запрос о добавке.
         */
        while (plate.getFood() > 0 && answer == 1) {
            for (int i = 0; i < cats.length; i++)
            {
                System.out.println(cats[i].eatWhenFoodEnough(plate));
                System.out.println(cats[i].getName() + " has satiation level of " + cats[i].getSatiation());
                plate.info();

                if (!cats[i].eatWhenFoodEnough(plate))
                {
                    System.out.println("There is not enough food.");
                    System.out.println("Should I put more food? 1 for yes, 2 for no");
                    answer = scanner.nextInt();

                    if (answer == 1)
                    {
                        System.out.println("How much food?");
                        addition = scanner.nextInt();
                        plate.putFood(addition);
                    } else
                        break;
                }
            }
        }
    }
}

