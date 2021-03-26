package queuetest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.scene.shape.Circle;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class CircleArrayDemo {
    public static void main(String[] args) {
        System.out.println("测试环形队列");
        CircleQueue queue = new CircleQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        char key = ' ';
        while(flag){
            System.out.println("s(show): 显示队列！");
            System.out.println("e(exit): 退出程序！");
            System.out.println("a(add): 添加数据到队列！");
            System.out.println("g(get): 从队列取出数据！");
            System.out.println("h(head): 查看队列头数据！");

            key = scanner.next().charAt(0); // scanner.next() 得到的字符串
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.printf("队列的头数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                default:
                    break;

            }

        }
        System.out.println("退出程序！！！");
    }
}

class CircleQueue{
    private int maxSize; // 数组最大值，也就是队列的最大值
    private int front; // 队列头部
    private int rear;  // 队列尾部
    private int[] arr; // 存放队列数据的数组（模拟的队列）

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;  //
        this.front = 0; // front指向头部的前一个位置
        this.rear = 0;
        arr = new int[maxSize];
    }

    // 判断队列是否满的
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    // 判断队列是否为空
    public boolean isEmpty(){
        return front == rear;
    }

    // 添加数据到队列中
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能再加入数据！！！！");

        }else {
            arr[rear] = n;
            rear = (rear+1)/maxSize;
        }
    }

    // 获取队列的数据，出队列
    public int getQueue(){
        // 如果空的
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据！！！");
        }
        // 这里需要分析出front是指向队列的第一个元素
        // 1. 先把front对应的值保留到一个临时变量
        // 2. 将front后移，并取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列是空的，没有数据~~");
            return;
        }
        for (int i = front; i < size(); i++) {
            System.out.printf("arr[%d] = %d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    //求出当前队列的有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }


    // 显示队列头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}