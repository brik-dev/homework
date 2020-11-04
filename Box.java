package lesson_1.homework;

import java.util.ArrayList;

public class Box<T> {

    ArrayList<T> listOfFruits = new ArrayList<>();

    public Box(ArrayList<T> listOfFruits) {
        this.listOfFruits = listOfFruits;
    }


    public int getWeight(){
        return listOfFruits.size()*100;
    }

    public boolean compare(Box<?> another){
            return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void poorOver(){
        //todo
    }


}
