package lc670;


class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int num = 14;
        int ans = s.maximumSwap(num);
        System.out.println(ans);

    }
    public int maximumSwap(int num) {
        String s = num + "";
        char[] c = s.toCharArray();
        int len = c.length;
        char max = '0';
        int index = 0;
        for(int i = 0; i < len; i++){
//            System.out.println((c[i]-48));
            if (c[i] > max){
                max = c[i];
                index = i;
            }
        }

        if(index == 0){
            return num;
        }else if(index != 0){
            c[index] = c[0];
            c[0] = max;
        }


        num = num + ((c[0]-48) * (int)Math.pow(10, len - 1) + (c[index]-48) *(int) Math.pow(10, len - 1 -index) - (c[index]-48) * (int)Math.pow(10, len - 1) - (c[0]-48) * (int)Math.pow(10, len - 1 -index));
        return num;
    }
}
