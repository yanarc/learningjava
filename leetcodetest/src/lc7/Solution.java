package lc7;


public class Solution {
    public void reversetest() {
        int x = 231;
        StringBuffer s = new StringBuffer(x);
        String afterReverse = s.reverse().toString();
        int ans = 0;
        if (afterReverse.equals("")){
            ans = Integer.parseInt(afterReverse);
        }
    }
}


