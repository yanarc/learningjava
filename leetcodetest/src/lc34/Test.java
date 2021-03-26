package lc34;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        Test t = new Test();
        int[] ans = t.searchRange(nums,8);
        System.out.println(ans.toString());
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int mid = (r-l)/2;
            if(nums[mid-1] == nums[mid] && nums[mid] == target){
                ans[0] = mid-1;
                ans[1] = mid;
            }else if(nums[mid+1] == nums[mid] && nums[mid] == target){
                ans[0] = mid;
                ans[1] = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid+1;
            }
        }
        return ans;
    }
}
