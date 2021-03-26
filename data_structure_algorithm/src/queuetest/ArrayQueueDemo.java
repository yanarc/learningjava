package queuetest;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        ArrayQueue queue = new ArrayQueue(3);
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

// 数组模拟队列
class ArrayQueue{
    private int maxSize; // 数组最大值，也就是队列的最大值
    private int front; // 队列头部
    private int rear;  // 队列尾部
    private int[] arr; // 存放队列数据的数组（模拟的队列）

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;  //
        this.front = -1; // front指向头部的前一个位置
        this.rear = -1;
        arr = new int[maxSize];
    }

    // 判断队列是否满的
    public boolean isFull(){
        return rear == maxSize-1;
    }
    // 判断队列是否为空
    public boolean ifEmpty(){
        return front == rear;
    }

    // 添加数据到队列中
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能再加入数据！！！！");

        }else {
            rear++;
            arr[rear] = n;
        }
    }

    // 获取队列的数据，出队列
    public int getQueue(){
        // 如果空的
        if (ifEmpty()){
            throw new RuntimeException("队列为空，不能取数据！！！");
        }
        front++; // 必须先加1后取出数据
        return arr[front];
    }

    // 显示所有数据
    public void showQueue(){
        if(ifEmpty()){
            System.out.println("队列是空的，没有数据~~");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }
    // 显示队列头数据
    public int headQueue(){
        if(ifEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }

}

