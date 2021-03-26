import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class PrivateTest {
    public static void main(String[] args) {
        Queue<Integer> stack = new LinkedList<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack.remove());
    }
}

class Car{
    private static int price;

    private Car run(){
        System.out.println("I am a car and I can run!");
        Car car = new Car();
        return car;
    }
    Car car = new Car();

}
