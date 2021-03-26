package lc39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = s.combinationSum(candidates, target);
        System.out.println(ans);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 回溯为什么要先做一个排序？
        Arrays.sort(candidates);
        backtrace(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void backtrace(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int target, int sum){
        if(sum <= target){
            if(sum == target){
                res.add(new ArrayList<>(tempList));
                return;
            }
        }else {
            return;
        }

        // candidates.length是最多的选择数量, 就算全都是1, 也最多是选择candidates.length个
        for(int i = 0; i < candidates.length; i++){
            //做出选择
            tempList.add(candidates[i]);
            sum += candidates[i];
            // 递归
            backtrace(res, tempList, candidates, target, sum);
            //撤销选择
            tempList.remove(tempList.size() - 1);
            sum -= candidates[i];
        }
    }

}