package Modules;

public class Cat extends Animal {
    public static int count_Cat = 0;
    protected int runLimitCat = 200;

    public Cat() {
    }

    @Override
    public void run(int distance) {
        if (distance >= runLimitCat) {
            System.out.println("Кошка пробежала " + runLimitCat);
        } else {
            System.out.println("Кошка пробежала " + distance);
        }
        count_Cat++;
    }

    @Override
    public void swim(int distance) {
        //super.swim();
        System.out.println("Кошка не захотела плавать");
        count_Cat++;
    }
}