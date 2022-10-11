package reflection;

import oop.*;

public class Cat extends Class2 implements MyInterface {
    public String name = "Кузя";
    public int age = 5;
    public String color = "Серый";
    public boolean isHungry = true;

    public void run(){
        System.out.println("Бежать!");
    }

    public void eat(){
        System.out.println("Кушать!");
        isHungry = false;
    }

    public void jump(){
        System.out.println("Прыгать!");
    }

    public String getName() {
        return name;
    }
}

