package offer10_1;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.fib(45);
        System.out.println(a);
    }
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int pre = 1, cur = 1;
        int sum = 0;
        for(int i = 3; i <= n; i++){
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
