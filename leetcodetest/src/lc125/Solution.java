package lc125;

// Ascll 码 0-9 对应 48-57
// A-Z 对应 65-90
// a-z 对应 97-122

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "ac,a";
        boolean palindrome = s.isPalindrome(str);
        System.out.println(palindrome);
    }
    static boolean flag = true;

    public boolean isPalindrome(String s) {
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        char[] stoc = s.toCharArray();
        String temp1 = "";
        for(int i  = 0; i< stoc.length; i++){
            if((48 <= stoc[i] && stoc[i] <= 57) || (97 <= stoc[i] && stoc[i] <= 122)){
                temp1 += stoc[i];
            }
        }
        if(temp1.equals("")) return true;
        if(temp1.length() == 1) return true;
        char[] temp = temp1.toCharArray();

        for(int i = 0; i < temp.length/2; i++){

            if(temp[i] != temp[temp.length - 1 - i]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
