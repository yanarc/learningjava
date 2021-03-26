package offer13;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        boolean ans = s.judge_k(35, 37, 18);
//        System.out.println(ans);
        int res = s.movingCount(1,2,1);
        System.out.println(res);
    }

    public int movingCount(int m, int n, int k) {
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = dfs(m, n, i, j, k);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public int dfs(int m, int n, int r, int c, int k){

        // 边界条件
        if(r < 0 || c < 0 || r >= m || c >= n || judge_k(r, c, k)){
            return 0;
        }

        return dfs(m, n, r-1, c, k) + dfs(m, n, r+1, c, k) + dfs(m, n, r, c-1, k) + dfs(m, n, r, c+1, k) +  1;
    }

    public boolean judge_k(int c, int r, int k){
        int temp = 0;
        while(c/10 != 0){
            temp += c/10;
            c = c%10;
        }
        temp += c;

        while(r/10 != 0){
            temp += r/10;
            r = r%10;
        }
        temp += r;

        return temp > k;
    }
}
