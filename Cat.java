package com.company.brik;

public class Cat extends Animal
{
    Cat(String name, int value, int runLimit, int jumpLimit, int swimLimit)
    {
        super(name, value, runLimit, jumpLimit, swimLimit);
    }

    @Override
    void swim()
    {
        if (value > swimLimit)
        {
            System.out.println(name + " cannot swim at all.");
        } else
            System.out.println(name + " swims " + value + " m.");
    }

}
