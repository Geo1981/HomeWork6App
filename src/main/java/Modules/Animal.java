package Modules;

public class Animal {
    public static int count_Animal = 0;

    public Animal() {
    }

    public void run() {
        count_Animal++;
    }

    public void swim() {
        count_Animal++;
    }

    public void run(int distance) {
        System.out.println("Животное бежит.");
    }

    public void swim(int distance) {
        System.out.println("Животное плавает.");

    }

}