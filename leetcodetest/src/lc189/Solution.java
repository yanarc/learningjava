package lc189;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        k %= nums.length;

        Solution.inverse(0, nums.length - 1, nums);
        Solution.inverse(0, k - 1, nums);
        Solution.inverse(k , nums.length - 1, nums);

        System.out.println(Arrays.toString(nums));
    }


    public static void inverse(int start, int end, int[] arr){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
