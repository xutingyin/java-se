#垃圾收集GC
##对象的创建方式
```yaml
1、new 创建对象
2、反射创建对象
    .调用java.lang.Class 或者 java.lang.reflect.Construtor类似的newInstance()实例方法
3、调用对象的clone()方法
4、反序列化创建对象
    .调用java.io.ObjectInputStream对象的readObject()方法
```

## 对象如何没的：
Java自动对无用的对象进行垃圾回收、收集（Garbage Collection）释放占用的内存。

## 如何去判断一个对象是垃圾的方法
### 引用计数法（Reference Count）
实际垃圾收集器中没有被采用，因为无法解决循环引用问题

### 根搜索算法(Root Searching)[也称可达性分析算法]
从GCRoot出发，有引用的对象都是吧“不可回收的”其它可标记后再回收，是JVM默认算法。

## 垃圾回收算法
### Mark-Sweep 标记清除算法
标记-清除算法分为两个阶段：标记阶段和清除阶段。标记阶段的任务是标记出所有需要被回收的对象，清除阶段就是回收被标记的对象所占用的空间。具体过程如下图所示：
![](../../images/jvm-gc-mark-sweep.png)

从图中可以很容易看出标记-清除算法实现起来比较容易，但是有一个比较严重的问题就是容易产生内存碎片，碎片太多可能会导致后续过程中需要为大对象分配空间时无法找到足够的空间而提前触发新的一次垃圾收集动作。
### Copying 复制算法
　为了解决Mark-Sweep算法的缺陷，Copying算法就被提了出来。它将可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这一块的内存用完了，就将还存活着的对象复制到另外一块上面，然后再把已使用的内存空间一次清理掉，这样一来就不容易出现内存碎片的问题。具体过程如下图所示：
![](../../images/jvm-gc-copy.png)
这种算法虽然实现简单，运行高效且不容易产生内存碎片，但是却对内存空间的使用做出了高昂的代价，因为能够使用的内存缩减到原来的一半。很显然，Copying算法的效率跟存活对象的数目多少有很大的关系，如果存活对象很多，那么Copying算法的效率将会大大降低。
### Mark-Compact 标记压缩算法
为了解决Copying算法的缺陷，充分利用内存空间，提出了Mark-Compact算法。该算法标记阶段和Mark-Sweep一样，但是在完成标记之后，它不是直接清理可回收对象，而是将存活对象都向一端移动，然后清理掉端边界以外的内存。具体过程如下图所示：
![](../../images/jvm-gc-mark-compact.png)

## 垃圾收集器
分代回收分类：
### 年轻代收集器
#### Serial 
![](../../images/jvm-gc-serial.png)
#### ParNew
![](../../images/jvm-gc-parnew.png)
#### Parallel Scavenge【JDK1.8年轻代默认】
![](../../images/jvm-gc-parallel%20scavenge.png)
### 老年代收集器
#### Serial Old【JDK1.8老年代默认】
![](../../images/jvm-gc-serial%20old.png)
#### Parallel Old
![](../../images/jvm-gc-parallel%20old.png)
#### CMS
![](../../images/jvm-gc-cms.png)

不分代回收分类：
#### G1
![](../../images/jvm-gc-G1.png)
G1逻辑上年轻代收集
![](../../images/jvm-gc-G1-MGC.png)

#### ZGC 
低延时收集器【stw小于10s的收集器】
![](../../images/jvm-gc-低延迟收集器.png)

![](../../images/jvm-gc-ZGC.png)
内部原理使用染色指针进行对象引用

![](../../images/jvm-gc-Shenandoah.png)
内部原理使用读屏障和转发指针实现对象动态引用

## JVM 调优建议
大多数情况JVM生产环境考虑调整以下三个方面：
```yaml
1、最大堆和最小堆
2、GC收集器
3、新生代(年轻代)大小
```
在没有全面监控，收集性能数据之前，调优都是徒劳的。

99%的情况下都是代码出现了问题，而不是JVM参数设置得有问题[JVM内置默认的参数基本上考虑到了大多数的应用场景]

![](../../images/jvm-gc-optimize.png)

### JVM 选项规则
java -version 标准选项，任何版本JVM/任何平台都支持。
java -Xms12m 非标准选项，部分版本识别
java -XX:+PrintGCDetails 不稳定参数，不同JVM有差异，随时可能被移除。

+ 代表开启，- 代表关闭

### JVM监控命令
![](../../images/jvm-gc-monitor-command.png)

![](../../images/jvm-gc-jstat-param.png)

## 实际生产OOM问题定位
1、jps
2、jinfo、jstat辅助命令
3、arthas-阿里巴巴提供的Java诊断工具-可以实时的分析各个内存空间的分配情况
4、生成dump 文件
5、利用 visualVM本地离线分析具体每个对象的内存分配情况，定位到出问题的代码。





































 