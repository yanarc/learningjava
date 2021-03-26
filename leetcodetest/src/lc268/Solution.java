package lc268;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,2};
        s.missingNumber(nums);
    }
    public int missingNumber(int[] nums) {
        int ans = 0;
        float sum = 0;
        float len = nums.length;
        float max = nums[0];
        for(int i = 0; i < len;i++){
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        float count = max * len / 2;
        if(sum == count){// 如果丢失的是最大值
            ans = (int)max + 1;
        }else if(sum < count){
            count = max * (len+1) / 2;
            ans = (int)(count - sum);
        }
        return ans;
    }
}
