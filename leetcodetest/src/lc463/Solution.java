package lc463;

public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{1}};
        Solution solution = new Solution();
        solution.islandPerimeter(grid);
    }


    public int islandPerimeter(int[][] grid) {
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    // 题目限制只有一个岛屿，计算一个就可以了
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;

    }

    public int dfs(int[][] grid, int r, int c){

        // // 如果坐标不合法，直接返回
        // if(!(r >= 0 && r < grid.length && c >= 0 && c+1 < grid[0].length)){
        //     return;
        // }

        // 下面的代码是由上面的改编而来
        // 如果从岛屿方格走向网格边界，周长加1
        if(!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)){
            return 1;
        }

        // 从一个岛屿方格走向水域方格，周长加1
        if(grid[r][c] == 0){
            return 1;
        }

        // 如果方格不是岛屿
        if(grid[r][c] != 1){
            return 0;
        }

        grid[r][c] = 2; // 将方格标记为“已经遍历过”

        // dfs(grid, r-1, c); // 上边相邻
        // dfs(grid, r+1, c);  // 下边相邻
        // dfs(grid, r, c-1); // 左边相邻
        // dfs(grid, r, c+1); // 右边相邻

        return dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
    }

}
