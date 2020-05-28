package cn.xutingyin.se009;

/**
 * @description: 集合
 * @author: Tingyin.Xu
 * @email : sunshinexuty@163.com
 * @create: 2020-05-28 21:31
 **/
public class CollectionDemo implements B {
    @Override
    public void out() {

    }

    public static void main(String[] args) {
        new CollectionDemo().outDefault();
    }

}

interface B {
    /**
     * 阿里巴巴代码规范中接口中的方法定义格式： 返回类型 方法名(可选参数)
     */
    void out();

    /**
     * 为什么要在接口中实现方法的方法体呢？ 有这样的业务场景：符接口中
     */
    default void outDefault() {
        System.out.println("interface default method.");
    }
}