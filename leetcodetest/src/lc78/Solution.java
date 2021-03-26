package lc78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,6,7};
        List<List<Integer>> list = s.subsets(nums);
        list.forEach(System.out::println);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        //
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            //做出选择
            tempList.add(nums[i]);
            // 递归
            backtrack(list,tempList, nums, i+1);
            // 撤销选择
            tempList.remove(tempList.size()-1);
        }
    }
}
