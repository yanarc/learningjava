package lc202;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.isHappy(19);
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n!=1){
            n=bitSquareSum(n);
            if(!set.add(n)){   // 当添加失败的时候，会返回flase, 说明已经进入循环了
                return false;
            }
        }
        return true;
    }

    public static int bitSquareSum(int x){
        int sum=0, cur = 0;
        while(x>0){
            cur = x%10;
            sum += cur*cur;
            x=x/10;
        }
        return sum;
    }
}
