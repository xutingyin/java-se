## 反射
反射，是为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法。
每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来。注意：这里的Class类型是一个名叫Class的class。它长这样：

    public final class Class {
         private Class() {} 
    }

例如JVM加载了将String类，它首先读取String.class文件到内存，然后，为String类创建一个Class实例并关联起来：
    
    Class cls = new Class(String);