package lc152;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-2,0,-1};
        int ans = s.maxProduct(nums);
        System.out.println(ans);
    }
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for(int i = 0; i <= nums.length -1; i++){
            for(int j = nums.length -1; j >= i; j--){
                int multi = 1;
                for(int k = j; k >= i; k--){
                    multi *= nums[k];
                }
                max = Math.max(max, multi);
            }
        }
        return max;
    }
}
