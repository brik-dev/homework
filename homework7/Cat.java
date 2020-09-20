package com.company.brik.homework7;

public class Cat
{
    private String name;
    private int appetite;
    private int stillAppetite;
    private int satiation;

    public Cat(String name, int appetite)
    {
        this.name = name;
        this.appetite = appetite;
    }


    /** Метод, помогающий осуществить задание 2. и вывести информацию о сытости котов
     * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
     *
     */
    public void eat(Plate p) {
        satiation = 0;
        if (p.getFood() < appetite)
        {
            stillAppetite = appetite - p.getFood();
            appetite = p.getFood();
            p.decreaseFood(appetite);
            satiation += appetite;
            System.out.println(name + " is still hungry. Food is not enough.");
            System.out.println(name + ": Level of appetite - " + stillAppetite + " Level of satiation - " + satiation);
        } else
        {
            p.decreaseFood(appetite);
            satiation += appetite;
            appetite -= satiation;
            System.out.println(name + "has eaten.");
            System.out.println(name + ": Level of appetite - " + appetite + " Level of satiation - " + satiation);
        }
    }

    /**
     * 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
     * @param p
     * @return
     */

     public boolean eatWhenFoodEnough(Plate p) {
        satiation = 0;
        if (p.getFood() < appetite)
        {
            //System.out.println(name + " is still hungry. Food is not enough.");
            //System.out.println(name + ": Level of appetite - " + stillAppetite + " Level of satiation - " + satiation);
            //stillAppetite = appetite - p.getFood();
            //appetite = p.getFood();
            //p.decreaseFood(appetite);
            return false;
        } else
        {
            p.decreaseFood(appetite);
            satiation += appetite;
            //System.out.println(name + " has eaten.");
            //System.out.println(name + ": Level of appetite - " + appetite + " Level of satiation - " + satiation);
            return true;
        }
     }

     public String getName()
     {
        return name;
     }

     public int getSatiation()
     {
        return satiation;
     }
}


