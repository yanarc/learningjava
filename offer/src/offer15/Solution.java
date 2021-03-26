package offer15;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int a = (int)Math.pow(2,31) + 10;
        int a = 2;
        int b = 1;
        int  c = a & b;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        s.hammingWeight(a);

    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int ans = 0;
        int temp = 0;
        if(n <= Math.pow(2,31) - 1){
            while(count < 32){
                temp = n;
                n = n << 1;
                if(n < temp){ // 左移一位，变小意味着左边去掉了1，右边补回了0
                    ans++;  // 左移一位，变大或者不变意味着左边去掉了0，右边补回了0
                }
                count++;
            }
        }else if(n > Math.pow(2,31) - 1 && n < Math.pow(2,31) - 1){
            while(count < 32){
                temp = n;
                n = n << 1;
                if(n < temp){ // 左移一位，变小意味着左边去掉了1，右边补回了0
                    ans++;  // 左移一位，变大或者不变意味着左边去掉了0，右边补回了0
                }
                count++;
            }
            ans++;
        }
        return ans;
    }
}
