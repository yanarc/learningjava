package lc5;

public class Solution5 {
    public static void main(String[] args) {
        String s = "basddsa";
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
        }

        System.out.println("abcdef".substring(0,1));
    }
}
