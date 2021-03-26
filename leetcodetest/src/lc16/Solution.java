package lc16;

import java.util.Arrays;

public class Solution {
    public void threeSumClosest() {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        Arrays.sort(nums);
        int ans = 10000;
        for (int k = 0; k < nums.length-2; k++){    // f(++i) 表示先自身＋1运算再进行函数f的运算
            int i = k + 1;
            int j = nums.length - 1;
            while(i<j){
                int tmp = nums[k] + nums[i] + nums[j];
                if(Math.abs(tmp-target) <= Math.abs(ans-target)){
                    ans = tmp;
                }
                if (tmp < target){
                    i++;
                }else if(tmp > target){
                    j--;
                }else{
                    System.out.println(ans);
                }
            }
        }
        System.out.println(ans);
    }
}
