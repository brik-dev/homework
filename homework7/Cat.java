package com.company.brik.homework7;

public class Cat
{
        private String name;
        private int appetite;
        private int satiation = 0;

        public Cat(String name, int appetite)
        {
            this.name = name;
            this.appetite = appetite;
        }

        public void eat(Plate p)
        {
            if(food < appetite){

            }
            p.decreaseFood(appetite);
        }

        /*public boolean isSated()
        {

        }*/
}
