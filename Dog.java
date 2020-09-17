package com.company.brik;

public class Dog extends Animal
{
    Dog(String name, int value, int runLimit, float jumpLimit, int swimLimit)
    {
        super(name, value, runLimit, jumpLimit, swimLimit);
    }

    @Override
    void swim()
    {
        if (value > swimLimit)
        {
            System.out.println(name + " cannot swim more than " + swimLimit + " m.");
        } else
            System.out.println(name + " swims " + value + " m.");
    }

}