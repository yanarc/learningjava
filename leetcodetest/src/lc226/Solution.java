package lc226;


public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left =null;
        treeNode1.right =null;

        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.left =null;
        treeNode3.right =null;

        TreeNode treeNode6 = new TreeNode(6);
        treeNode6.left =null;
        treeNode6.right =null;

        TreeNode treeNode9 = new TreeNode(9);
        treeNode9.left =null;
        treeNode9.right =null;

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        TreeNode treeNode7 = new TreeNode(7);
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;

        TreeNode treeNode4 = new TreeNode(4);
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode2;


        Solution s = new Solution();
        TreeNode list = s.invertTree(treeNode4);
        System.out.println(list);
    }

    public TreeNode invertTree(TreeNode root) {

        if(root==null || (root.left ==null && root.right ==null)){
            return root;
        }

        //翻转左子树
        TreeNode left = invertTree(root.left);
        //翻转右子树
        TreeNode right = invertTree(root.right);

        //左右子树交换位置~
        root.left = right;
        root.right = left;
        return root;
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
