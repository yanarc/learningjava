package offer46;

// https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.translateNum(123);
        System.out.println(i);
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if(len == 1) return 1;
        int[] dp = new int[len+1];
        dp[1] = 1;
        if(judge(s, 2)){
            dp[2] = 3;
        }else{
            dp[2] = 2;
        }
        for(int i = 3; i <= len; i++){
            if(judge(s, i)){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len];

    }

    // i 表示以1为起点，第i位及第i-1位组合成的数字
    boolean judge(String s, int i){
        int temp = s.charAt(i-1) - 48 + (s.charAt(i-2)-48)  * 10 ;
        if(temp <= 25) return true;
        return false;
    }

}
