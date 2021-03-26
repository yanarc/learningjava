package offer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = null;
        node1.right = null;
        node2.left = node3;
        node2.right = node4;

        node3.left = null;
        node3.right = null;

        node4.left = null;
        node4.right = null;

        Solution s = new Solution();
        List<List<Integer>> res = s.levelOrder(root);
        System.out.println("hahahhah"+res.get(1).get(1));


    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 初始化
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        if(root != null) queue.add(root);

        // 循环体
        while(!queue.isEmpty()){
            List temp = new ArrayList();
            int size = queue.size();
            for(int i = 0; i < size; i++){  //for(int i = queue.size(); i > 0; i--){
                // 出队
                TreeNode node = queue.poll();

                // 打印
                temp.add(node.val);

                // 左右子树入队
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }

        for(int i = 1; i < res.size(); i += 2){
            int len = res.get(i).size();
            Integer temp;
            for(int j = 0; j < len/2; j++){
                temp = res.get(i).get(j);
//                res.get(i).get(j) = res.get(i).get(len - 1 - j);
//                res.get(i).get(len - 1 - j) = temp;  // res.get(i).get(len - 1 - j) 得到的是一个数，而不是可以修改该位置下的值
            }

        }

        return res;


    }
}
