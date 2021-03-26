package lc64;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,2,3},{4,5,6}};
        solution.minPathSum(grid);
        System.out.println(grid);

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // base case
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
            System.out.println(dp[i][0]);
        }

        for(int i = 1; i < m; i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
            System.out.println(dp[0][i]);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
                System.out.println(dp[i][j]);
            }
        }

        return dp[m-1][n-1];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
