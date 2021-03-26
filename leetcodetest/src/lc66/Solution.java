package lc66;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] digital = {9};
        Solution solution = new Solution();
        int[] ans = Solution.plusOne(digital);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int sum = 1;
        for( int i = 0; i<len; i++){
            sum += digits[i] * Math.pow(10, len-1-i);
        }
        sum = sum % (int)Math.pow(10, len);

        int bit = 0;
        for(int i = 0; i< len; i++){
            bit = sum / (int)Math.pow(10, len-1-i);
            sum = sum - bit * (int)Math.pow(10, len-1-i);
            digits[i] = bit;

        }
        return digits;
    }
}