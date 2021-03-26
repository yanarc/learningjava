import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapTest<K, V> {

    // 哈希表结点个数(包括了数组和链表上的节点)
    private int size;

    // 桶元素定义（数组），数组上是链表，当数组长度大于64而且链表上的元素大于8时，链表应该转变为红黑树
    LinkedList<ListNode>[] target;

    // 哈希表的容量
    private int capacity;

    // 构造器
    public MapTest(int capacity) {
        this.capacity = capacity;
        this.target = new LinkedList[8];  // 存放了8条链表的数组

        // 桶元素每个索引的赋值
        for (int i = 0; i < target.length; i++) {
            target[i] = new LinkedList<ListNode>();
        }
    }

    public void put(K key, V value) {

        if(key == null){
            // 直接放在第一个桶元素的头结点
            LinkedList<ListNode> listNodes = target[0];
            if(listNodes.isEmpty()){
                listNodes.add(new ListNode(key,value));
                size++;
            }else{
                ListNode listNode = listNodes.peek();  // 将链表的第一个节点值改为value即可，岂不是变成了修改链表操作？
                listNode.value = value;

                  // 在target[0]链表中查找key为null的元素，如果找到，则将value重新赋值给这个元素的value，并返回原来的value
//                ListNode listNode = listNodes.peek();
//                if (listNode.key == null){
//                    listNode.value = value;
//                }else {
//                    // 如果没找到则将这个元素添加到talbe[0]链表的表头
//                    listNodes.addFirst(new ListNode(key, value));
//                }

            }
            return;
        }

        // 1、哈希
        int hash = key.hashCode();

        // 2、取模
//        int index = hash % target.length;
        int index = hash & (target.length-1); // 用与运算取代模运算，效率更高
        LinkedList<ListNode> result = target[index];

        // 3、放入桶元素
        if (result.isEmpty()) {
            result.add(new ListNode(key, value));
            size++;
        } else {
            // 比较equals()方法
            for (ListNode listNode : result) {
                if (listNode.key.equals(key)) {
                    // 替换当前结点的value
                    listNode.value = value;
                    return;
                }
            }

            // 当前链表中没有该结点，jdk1.8中是插入的是链表尾部
            result.add(new ListNode(key,value));
            size++;
        }
    }

    public V get(K key) {
        if(key == null){
//            return target[0].peek().key == null ? (target[0].peek().value == null ? null : (V)target[0].peek().value) : null;
            return target[0].peek().key == null ? (V)target[0].peek().value : null;
        }
        // 1、哈希
        int hash = key.hashCode();
        // 2、获取桶元素下标
        LinkedList<ListNode> result = target[hash & (target.length - 1)];
        // 3、获取value
        if (result.isEmpty()) {
            return null;
        } else {
            for (ListNode listNode : result) {
                if (listNode.key.equals(key)) {
                    return (V) listNode.value;
                }
            }
            return null;
        }


    }

    // 自定义链表
    static class ListNode<K, V> {
        final K key;
        V value;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        MapTest<String, Integer> map = new MapTest<String, Integer>(16);
        System.out.println("0".hashCode() & 7);
        map.put("0", 0);
        map.put(null, null);
        map.put(null, 1);
        System.out.println(map.get("0"));
        System.out.println(map.get(null));
    }
}
