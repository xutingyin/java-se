package cn.xutingyin.se009;

/**
 * @description: 继承，重载
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-28 20:41
 **/
public class Hello extends A {
    /**
     * 子类复写父类方法的时候，权限修饰符只能放大，不能缩小，如这里改为protected、private等都会提示报错；不能使用static修饰复写方法;子类抛出的异常必须为父类异常的子类
     */
    @Override
    public void out() {
        System.out.println("i am Hello out method");
    }
}

class A {
    public void out() throws Exception {
        System.out.println("i amd A out method");
    }
}