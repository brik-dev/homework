package lesson_three.homework;

public class Person {
   protected String lastName;
   protected String phoneNumber;
   protected String email;

    public Person(String lastName, String phoneNumber, String email){
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getInfo(){
        return phoneNumber + " " + email;
    }

    public String getLastName(){
        return lastName;
    }

}
