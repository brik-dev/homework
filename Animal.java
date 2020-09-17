package com.company.brik;

public abstract class Animal
{
    protected String name;
    protected int value;
    //можно было бы объявить переменные для каждой дисциплины отдельно и инициализировать их при создании каждого объекта каждого животного
    //runDistance
    //jumpHeight
    //swimDistance
    protected int runLimit;
    protected float jumpLimit;
    protected int swimLimit;

    Animal(String name, int value, int runLimit, float jumpLimit, int swimLimit)
    {
        this.name = name;
        this.value = value;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }

    void run() {
        if (value > runLimit) {
            System.out.println(name + " cannot run more than" + runLimit + " meters.");
        } else
            System.out.println(name + " runs " + value + " meters.");
    }

    abstract void swim();

    void jump()
    {
        if (value > jumpLimit) {
            System.out.println(name + " cannot jump higher than "+ jumpLimit + " m.");
        } else
            System.out.println(name + " jumps as high as " + value + " m.");
    }
}
