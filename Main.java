package lesson_three.homework;

import java.util.*;

/**
 * 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
 *  - Найти список слов, из которых состоит текст (дубликаты не считать);
 *  - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 * 2. Написать простой класс PhoneBook(внутри использовать HashMap):
 *  - В качестве ключа использовать фамилию
 *  - В каждой записи всего два поля: phone, e-mail
 *  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
 * * Следует учесть, что под одной фамилией может быть несколько записей. Итого должно получиться 3 класса Main, PhoneBook, Person.
 */

public class Main {

    public static void main(String[] args){
        System.out.println("***** Задание №1 *****");
        String[] words = {
                "абонемент",
                "абсолютный",
                "авиамодель",
                "авиация",
                "автобиография",
                "автомобиль",
                "автомат",
                "агитатор",
                "агрегат",
                "автомобиль",

                "багаж",
                "багор",
                "багровый",
                "багряный",
                "бакалея",
                "балет",
                "баллада",
                "бандероль",
                "барахтаться",
                "баллада",

                "вагон",
                "валенки",
                "варежки",
                "вдохновение",
                "вдребезги",
                "ведомость",
                "веер",
                "велеть",
                "великий",
                "вдохновение"
        };

        System.out.println("Выводим массив как он есть с повторениями:");
        for(int i = 0; i < words.length; i++){
            System.out.print(words[i] + " ");
        }
        System.out.println();

        //организуем массив в коллекцию LinkedHashSet, которая не добавляет повторения,
        // то есть мы выводим текст,но дубликаты при этом не считаем
        System.out.println();
        System.out.println("Выводим массив без дубликатов:");
        Set<String> list = new LinkedHashSet<>();
        for (int i = 0; i < words.length; i++){

            list.add(words[i]);

        }
        System.out.print(list);
        System.out.println();

        // считаем, сколько раз встречается каждое слово
        System.out.println();
        System.out.println("Выводим слова и количество их повторений:");
        ArrayList<String> wordList = new ArrayList<>();
        Map<String, Integer> countWords = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            wordList.add(words[i]);
        }
        for (String s : wordList) {
            if(!countWords.containsKey(s)){
                countWords.put(s, 1);
            }else if(countWords.containsKey(s)){
                Integer factor = countWords.get(s);
                countWords.put(s, factor + 1);
            }
        }
        System.out.println(countWords);

        System.out.println();
        System.out.println("***** Задание №2 *****");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.printAllNames();

        String lastName = "Ivanov";
        System.out.println("Номер телефона и e-mail по фамилии " + lastName + ": " + phoneBook.searchPhoneNumber(lastName));

    }
}


