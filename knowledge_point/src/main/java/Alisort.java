import java.util.*;

public class Alisort {
    public static void main(String[] args) {
        String str = "alibabab";
        Alisort alisort = new Alisort();
        String[] permutation = alisort.permutation(str);
        Arrays.sort(permutation);
        for(String s : permutation){
            System.out.println(s);
        }
    }

    List<String> list = new ArrayList<String>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[0]);
    }

    void dfs(int k){
        if(k == c.length-1){
            list.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<Character>();
        // 开始固定第k位
        for(int i = k; i < c.length; i++){
            // 剪枝
            if (set.contains(c[i])) continue;

            set.add(c[i]);
            swap(i, k);
            dfs(k+1);
            swap(i,k);
        }
    }

    void swap(int a, int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    @Override
    public String toString() {
        return "Alisort{" +
                "list=" + list +
                ", c=" + Arrays.toString(c) +
                '}';
    }
}
