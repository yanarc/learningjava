package lc322;

//public class Solution {
//
//    public int coinChange(int[] coins, int amount) {
//        // # 定义：要凑出金额 n，至少要 dp(n) 个硬币
//
//        if (amount <= 0) {
//            return amount == 0 ? 0 : -1; // 使用三元运算符好一些
//        }
//
//        // 要求最小值，先初始化为题目规定的最大值
//        int res = (int) Math.pow(10, 4);
//
//        // 加强for循环
//        for (int coin : coins) {
//            int subproblem = coinChange(coins, amount - coin);
//            if (subproblem == -1) continue;
//
//            // # 做选择，选择需要硬币最少的那个结果
//            res = Math.min(res, 1 + subproblem);
//        }
//
//        if (res != Math.pow(10, 4)) {
//            return res;
//        }
//
//        return -1;
//    }
//
//}

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.coinChange(new int[]{1, 2, 5},11);
        System.out.println(ans);
    }

    public int coinChange(int[] coins, int amount) {
        // 初始条件检查
        if (amount < 1) return 0;
        // 动态规划入口
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     * 自上而下的动态规划方法
     * coins:硬币面额
     * rem:余额
     * count:存储中间计算结果，空间换时间
     */
    private int coinChange(int[] coins, int rem, int[] count) {
        // 结束条件：此路径不通
        if (rem < 0) return -1;
        // 结束条件：余额为0，成功结束
        if (rem == 0) return 0;
        // 之前已经计算过这种情况，直接返回结果，避免重复计算
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        // 遍历当前递归子树的每一种情况
        for (int coin : coins) {
            // 用一下coin这个面值的硬币会怎样？res是这个方法的最优情况
            int res = coinChange(coins, rem - coin, count);
            // res<0 即为 res=-1,此法失败，res>min不是最优情况，舍去
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        // count[rem - 1]存储着给定金额amount的解
        // 若为Integer.MAX_VALUE则该情况无解
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

}