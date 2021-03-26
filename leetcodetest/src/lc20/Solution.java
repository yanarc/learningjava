package lc20;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String s = "()[]{}";

        Set<String> set = new HashSet();
        set.add("()");
        set.add("[]");
        set.add("{}");

        if(((s.toCharArray()).length % 2) != 0){
            System.out.println(false);
        }
        for(int i = 0; i<(s.toCharArray()).length/2; i++){
            System.out.println((s.charAt(i)+"") + s.charAt((s.toCharArray()).length - 1 - i)+"");
            if(!set.contains((s.charAt(i)) + s.charAt((s.toCharArray()).length - 1 - i))){
                System.out.println(false);
            }
        }
    }

}
