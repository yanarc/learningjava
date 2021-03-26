import java.util.*;

public class xianfanshu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            process(num);
        }

    }

    public static void process(int num){
        int temp = num;
        // 去掉末尾所有的0
        while(temp != 0 && (temp%10 == 0)){
            temp /= 10;
        }

        int res = 0;
        // 只要余数或者商不为0就继续进行
        while(temp/10 != 0 ||(temp % 10 != 0)){
            res = res * 10 + temp%10;
            temp /= 10;
        }
        System.out.println(res+num);
    }
}
