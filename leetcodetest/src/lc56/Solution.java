package lc56;

// Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]); 假设传来两个值，v1 与 v2，那么他们的先/后顺序以 v1[0] 比 v2[0] 的结果为准，即：若 v1[0] < v2[0] 则 v1 < v2，若 = 则 =，若 > 则 >

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = {1, 10};  // new int[]{1, 10} 实质上就是添加两个整数元素进入到集合当中去
        System.out.println(Arrays.toString(ints));
    }
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();

        if (intervals.length == 0 || intervals == null) {
            return new int[0][0];
        }

        // 先按照区间起始位置对区间进行从小到大排序
        // Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        // 非lambda表达式
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 对于已经排好序的数组，如果有重叠，循环判断, 如果第(i+1)个区间的左端点比第i个区间的右端点要小的话
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]); // 第i个区间的右端点和
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }

}
