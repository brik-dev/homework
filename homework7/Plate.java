package com.company.brik.homework7;

public class Plate
{
    private int food;
    public Plate(int food)
    {
        this.food = food;
    }

    public void decreaseFood(int n)
    {
        food -= n;
    }

    public void info()
    {
        System.out.println("plate: " + food);
    }

    public int getFood()
    {
        return food;
    }

    // 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void putFood(int n)
    {
        food += n;
        System.out.println("Plate is full again.");
    }

}
