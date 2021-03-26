package lc695;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,1}};
        Solution solution = new Solution();
        int a = solution.maxAreaOfIsland(grid);
        System.out.println(a);
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int temp = dfs(grid, i, j);
                ans = Math.max(ans, temp);
            }
        }
        return ans;

    }

    public int dfs(int[][] grid, int r, int c){

        // 走向边界或者走向水域都是0;
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1){
            return 0;
        }

        // 走向另外一个岛屿面积加1
        if(grid[r][c] == 1){
            return 1;
        }

        // 将已经遍历过的岛屿记录为水域
        grid[r][c] = 0;

        return dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
    }
}
