package lesson_three.homework;

import java.util.*;

/**
 * Написать простой класс PhoneBook(внутри использовать HashMap):
 *  *  - В качестве ключа использовать фамилию
 *  *  - В каждой записи всего два поля: phone, e-mail
 *  *  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
 */

public class PhoneBook implements Comparable<PhoneBook> {
    private String lastName;
    private String phoneNumber;
    private String email;
    HashSet<Person> phoneBookEntries = new HashSet<>();
    HashMap<String, String> book = new HashMap<>();

    public PhoneBook() {

        Person person1 = new Person("Ivanov", "20394887459", "ivanov@mail.com");
        Person person2 = new Person("Petrov", "09829387556", "petrov@mail.com");
        Person person3 = new Person("Sidorov", "0928349875885", "sidorov@mail.com");

        phoneBookEntries.add(person1);
        phoneBookEntries.add(person2);
        phoneBookEntries.add(person3);

        book.put(person1.getLastName(), person1.getInfo());
        book.put(person2.getLastName(), person2.getInfo());
        book.put(person3.getLastName(), person3.getInfo());
    }

    //метод для вывода всего массива
    public void printAllNames() {

        System.out.println(book);
    }

    public String searchPhoneNumber(String lastName) {
        String searchResult = new String();
        this.lastName = lastName;

        for(String s : book.keySet()){
            if(lastName.equals(s)){
                searchResult = book.get(lastName);
            }
        }
        return searchResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, phoneNumber);
    }

    @Override
    public int compareTo(PhoneBook o) {
        return 0;
    }
}
