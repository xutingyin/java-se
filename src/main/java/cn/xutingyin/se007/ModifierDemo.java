package cn.xutingyin.se007;

class A {
    /**
     * public方法在任何地方都能访问
     */
    public void publicMethod() {

    }

    /**
     * protected方法只能在子类中进行访问
     */
    protected void protectedMethod() {

    }

    /**
     * private方法只能在本类进行访问
     */
    private void privateMethod() {

    }
}

/**
 * @description: 修饰符
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-26 20:36
 **/
public class ModifierDemo {
    public static void main(String[] args) {
        A a = new A();
        a.publicMethod();
        a.protectedMethod();
        // 'privateMethod()' has private access in 'cn.xutingyin.se007.A'
        // a.privateMethod();
    }

}
