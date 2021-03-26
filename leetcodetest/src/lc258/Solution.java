package lc258;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.addDigits(38);
    }
    public int addDigits(int num) {
        int temp = 0;
        while(num/10 != 0){
            temp += num%10;
            num = num/10;
            if(num >=0 && num <=9){
                temp += num;
                num = temp;
            }
        }
        return num;
    }
}
