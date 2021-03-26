package lc17;

public class Solution {
    public static void main(String[] args) {
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("最大字节数为"+ max + "约等于" + max/(double)1024/1024); // double在这里表示精度
        System.out.println("最大字节数为"+ total + "约等于" + total/(double)1024/1024);
    }

//    String[][] sb = {{"a", "b", "c"},
//            {"d", "e", "r"},{"g", "h", "i"},
//            {"j", "k", "l"},{"m", "n", "o"},
//            {"p", "q", "r", "s"},{"t", "u", "v"},
//            {"x", "w", "y", "z"}};


}
