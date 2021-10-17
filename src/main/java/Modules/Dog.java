package Modules;

public class Dog extends Animal {
    public static int count_Dog = 0;
    protected int runLimitDog = 500;
    protected int swimLimitDog = 10;

    public Dog() {
    }

    @Override
    public void run(int distance) {
        super.run();
        if (distance >= runLimitDog) {
            System.out.println("Собака пробежала " + runLimitDog);
            count_Dog++;
        } else {
            System.out.println("Собака пробежала " + distance);
            count_Dog++;
        }
    }

    @Override
    public void swim(int distance) {
        super.swim();
        if (distance >= swimLimitDog) {
            System.out.println("Собака проплыла " + swimLimitDog);
            count_Dog++;
        } else {
            System.out.println("Собака проплыла " + distance);
            count_Dog++;
        }

    }
}