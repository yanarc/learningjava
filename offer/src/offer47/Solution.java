package offer47;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] gird = {{1,2,5},{3,2,1}};
        s.maxValue(gird);
    }
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1) return grid[0][0];
        // 如果只有1行
        if(m == 1 && n > 1){
            int res = 0;
            for(int num : grid[0]){
                res += num;
            }
            return res;
        }

        // 如果只有1列
        if(n == 1 && m > 1){
            int res = 0;
            for(int i = 0; i < m; i++){
                res += grid[i][0];
            }
            return res;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        dp[0][1] = dp[0][0] + grid[0][1];
        dp[1][0] = dp[0][0] + grid[1][0];

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
                System.out.println("dp[" + i + "]["+j+"]: " + dp[i][j]);
            }
        }

        return dp[m-1][n-1];

    }
}
