package lc14;


public class Solution {
    public void longestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};
        int n = strs.length;
        int m = 1;
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n-1; i++){
            m = Math.min(strs[i].length(), strs[i+1].length());
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n-1; j++){
                if(strs[j].charAt(i) == strs[j+1].charAt(i)){
                    count++;
                }
            }
            if (count == n-1){
                sb.append(strs[0].charAt(i));
            }
            count = 0;

        }
        System.out.println(sb.toString());
//        return sb.toString();
    }
}
