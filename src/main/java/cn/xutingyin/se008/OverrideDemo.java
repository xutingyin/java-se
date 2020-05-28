package cn.xutingyin.se008;

public class OverrideDemo {
    public static void main(String[] args) {
        // 父类的引用[cat] 指向子类的对象[new Cat()]
        Animal cat = new Cat();
        cat.eat();

        Animal dog = new Dog();
        dog.eat();

        Animal rabbit = new Rabbit();
        rabbit.eat();
    }
}
