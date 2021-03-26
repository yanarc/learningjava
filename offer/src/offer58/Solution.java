package offer58;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.reverseWords("  hello world!  ");
        System.out.println(ans);
    }
    public String reverseWords(String s) {
        // 先去掉首尾空格
        s = s.trim();
        List<String> list = new ArrayList();
        int start = 0, end = 0;

        while(end < s.length()){
            if(s.charAt(end) == ' '){
                list.add(s.substring(start, end));
                start = end + 1;
            }
            end++;
        }
        String res = "";
        int len = list.size();
        for(int i = len-1; i > 0; i--){
            res += list.get(i);
            res += " ";
        }
        res += list.get(0);
        return res;
    }
}