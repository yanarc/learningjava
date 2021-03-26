package arraystacktest;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
//         测试一把
        ArrayStack arrayStack = new ArrayStack(10);
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show：显示栈！");
            System.out.println("exit：退出程序！");
            System.out.println("push：添加数据到栈中！");
            System.out.println("pop：出栈！");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入要入栈的数据：");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("出栈的数据是%d：", res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~");
//        ArrayStack arrayStack = new ArrayStack(10);
//        arrayStack.push(1);
//        arrayStack.push(2);
//        arrayStack.push(3);
//        arrayStack.list();
//        arrayStack.pop();
//        arrayStack.list();

    }
}

class ArrayStack{
    private final int maxSize; // 栈的大小
    private int[] stack; // 栈本身
    private int top = -1; // 栈顶，默认为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 判断栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈-push
    public void push(int value){
        if (isFull()){
            System.out.println("栈已满，无法再进行添加数据!");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈-pop
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    // 遍历栈的情况
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据");
        }
        for (int i = top; i >=0 ; i--) {
            int temp = stack[i];
            System.out.printf("stack[%d]=%d \n", i, temp);
        }
//        while (top != -1){
//            int temp = stack[top];
//            System.out.printf("stack[%d]=%d \n", top, temp);
//            top--;
//        }

    }

}
