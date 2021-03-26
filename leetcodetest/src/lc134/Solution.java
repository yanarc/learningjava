package lc134;

public class Solution {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Solution s = new Solution();
        int i = s.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(sum(gas) < sum(cost)) return -1;
        int ans = 0;
        for(int i = 0; i < gas.length; i++){
            if(gas[i] > cost[i]){
                ans = i;
                int rest = gas[i]; // 从第i个站出发的汽油为rest
                int k = i;
                while(rest >= cost[k]){
                    if(k+1 == gas.length){
                        rest = rest - cost[k] + gas[0]; // 从第i+1个站出发的汽油为rest
                    }else{
                        rest = gas[k] - cost[k] + gas[k+1]; // 从第i+1个站出发的汽油为rest
                    }

                    k = (k+1) % gas.length;

                    if(k == ans){
                        return ans;
                    }
                }
            }
        }
        return -1;
    }

    public static int sum(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }
}
