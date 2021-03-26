package lc200;

public class Solution {
    public static void main(String[] args) {
        char[][] gird = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution solution = new Solution();
        int ans = solution.numIslands(gird);
        System.out.println(ans);
    }
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == '1'){
                    ++numIslands;
                    dfs(grid,r,c);
                }
            }
        }
        return numIslands;
    }

    public void dfs(char[][] grid, int r, int c){

        if (r < 0 || r >= grid.length || c < 0 || c >= grid.length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}
