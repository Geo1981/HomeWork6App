import Modules.Animal;
import Modules.Cat;
import Modules.Dog;

public class HomeWork6 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.run(20);
        dog.swim(35);
        cat.run(50);
        cat.swim(20);
        System.out.println("Всего животных: " + Animal.count_Animal + ". Из них кошек " + Cat.count_Cat + ", собак " + Dog.count_Dog + ".");
    }
}