package cn.xutingyin.ref;

/**
 * @description: 传递引用类型
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-05 23:14
 **/
public class RefDemo2 {
    public static void main(String[] args) {
        Person person = new Person(20, "susan");
        System.out.println("修改前：" + person);
        call(person);
        System.out.println("修改后：" + person);
    }

    static void call(Person person) {
        person.setAge(18);
        person.setName("lily");
    }
}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
