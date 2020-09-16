# HashMap 源码分析
前言：使用的JDK1.8
参考：HashMap 常见面试问题:https://zhuanlan.zhihu.com/p/163283988
## 属性
```shell
/**
 * The default initial capacity - MUST be a power of two.
 *  默认初始化容量-必须是2的幂
 */
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

/**
 * The maximum capacity, used if a higher value is implicitly specified
 * by either of the constructors with arguments.
 * MUST be a power of two <= 1<<30.
 * 最大容量-必须是2的幂
 * 这里为什么是30?呢，看另一篇小文分析【为什么HashMap的最大容量为MAXIMUM_CAPACITY = 1 << 30】
 */
static final int MAXIMUM_CAPACITY = 1 << 30;

/**
 * The load factor used when none specified in constructor.
 * 加载因子
 */
static final float DEFAULT_LOAD_FACTOR = 0.75f;

/**
 * The bin count threshold for using a tree rather than list for a
 * bin.  Bins are converted to trees when adding an element to a
 * bin with at least this many nodes. The value must be greater
 * than 2 and should be at least 8 to mesh with assumptions in
 * tree removal about conversion back to plain bins upon
 * shrinkage.
 * 树化阈值
 */
static final int TREEIFY_THRESHOLD = 8;

/**
 * The bin count threshold for untreeifying a (split) bin during a
 * resize operation. Should be less than TREEIFY_THRESHOLD, and at
 * most 6 to mesh with shrinkage detection under removal.
 * 树退化阈值
 */
static final int UNTREEIFY_THRESHOLD = 6;

/**
 * 最小树化容量
 */
static final int MIN_TREEIFY_CAPACITY = 64;
```

## 构造方法
```shell
/**
 * 无参构造函数，默认初始化容量为16，加载因子为0.75
 */
public HashMap() {
    this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
}
/**
 * 指定初始化容量，加载因子为默认的0.75
 */
public HashMap(int initialCapacity) {
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}

/**
 * 指定初始化容量和加载因子
 *
 */
public HashMap(int initialCapacity, float loadFactor) {
    if (initialCapacity < 0)
        throw new IllegalArgumentException("Illegal initial capacity: " +
                                           initialCapacity);
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException("Illegal load factor: " +
                                           loadFactor);
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);
}
/**
* 构造一个指定Map集合的容器
*
*/
public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    putMapEntries(m, false);
}
```

## 常用核心方法
```shell
/**
* 存放指定 key 和 value
*/
public V put(K key, V value) {
     return putVal(hash(key), key, value, false, true);
}

// 紧接着我们看看 hash()这个方法
static final int hash(Object key) {
    int h;
    // >>> 表示无符号右移 16位，即增加高16位
    // 这里(h >>> 16)得到key的hoshcode的高16位与hashCode()进行^运算,这样做的目的是为了让得到的下标更加散列
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

/**
*  如果插入的key 已存在，则不插入，反之，插入
*/
public V putIfAbsent(K key, V value) {
    return putVal(hash(key), key, value, true, true);
}

/**
*  将指定集合m 添加到当前集合中
*/
public void putAll(Map<? extends K, ? extends V> m) {
    putMapEntries(m, true);
}
/**
*  获取指定key 的value
*/
public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}
/**
*  删除指定key 的 元素
*/
public V remove(Object key) {
    Node<K,V> e;
    return (e = removeNode(hash(key), key, null, false, true)) == null ?
        null : e.value;
}
/**
*  删除指定key 和 value 的元素
*/
public boolean remove(Object key, Object value) {
    return removeNode(hash(key), key, value, true, true) != null;
}

/**
* 删除所有元素
*/
public void clear() {
    Node<K,V>[] tab;
    modCount++;
    if ((tab = table) != null && size > 0) {
        size = 0;
        for (int i = 0; i < tab.length; ++i)
            tab[i] = null;
    }
}
```
