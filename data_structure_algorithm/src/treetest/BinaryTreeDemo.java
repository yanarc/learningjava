package treetest;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();

        // 创建树的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 先手动创建二叉树，后面接着可以用递归的方式来创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);


//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//
//        System.out.println("中序遍历");
//        binaryTree.omfixOrder();
//
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//
//        // 前续遍历，遍历次数应该为4
//        System.out.println("前序遍历查找：");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到了，信息为val=%d, name = %s", resNode.getVal(), resNode.getName());
//            System.out.println();
//        }else {
//            System.out.printf("没有找到val = %d 的英雄", 5);
//            System.out.println();
//        }
//
//
//        // 中序遍历，遍历次数应该为4
//        System.out.println("中序遍历查找：");
//        resNode = binaryTree.infixOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到了，信息为val=%d, name = %s", resNode.getVal(), resNode.getName());
//            System.out.println();
//        }else {
//            System.out.printf("没有找到val = %d 的英雄", 5);
//            System.out.println();
//        }
//
//
//        // 后序遍历，遍历次数应该为4
//        System.out.println("后序遍历查找：");
//        resNode = binaryTree.postOrderSearch(5);
//        if (resNode != null){
//            System.out.printf("找到了，信息为val=%d, name = %s", resNode.getVal(), resNode.getName());
//        }else {
//            System.out.printf("没有找到val = %d 的英雄", 5);
//        }

        // 删除测试
        System.out.println("删除前，前序遍历");
        binaryTree.preOrder(); // 12354
        binaryTree.delNode(4);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder(); // 1234

    }
}

// 定义二叉树
class BinaryTree{
    private HeroNode root;


    public BinaryTree() {

    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    // 删除节点
    public void delNode(int val){
        if (root != null){
            if(root.getVal() == val){
                root = null;
            }else {
                // 递归删除
                root.delNode(val);
            }
        }
    }
    // 前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    // 中序遍历
    public void omfixOrder(){
        if(this.root != null){
            this.root.omfixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    // 后序遍历
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    // 前序遍历查找节点

    /**
     *
     * @return
     */
    public HeroNode preOrderSearch(int val){
        if(root != null){
            return root.preOrderSearch(val);
        }else {
            return null;
        }
    }

    // 中序遍历查找节点
    public HeroNode infixOrderSearch(int val){
        if (root != null){
            return root.infixOrderSearch(val);
        }else {
            return null;
        }
    }

    // 后序遍历查找节点
    public HeroNode postOrderSearch(int val){
        if (root != null){
            return root.postOrderSearch(val);
        }else {
            return null;
        }
    }


}

// 先创建树节点
class HeroNode{
    private int val;
    private String name;
    private HeroNode left;
    private HeroNode right;

    // get和set方法

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 构造器
    public HeroNode(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public String toString() {  // String 的toString 方法已经改写了Object类的toSgtringfangfa1de1
        return "HeroNode{" +
                "val=" + val +
                ", name='" + name + '\'' +
                '}';
    }

    // 递归删除节点
    // 1. 如果删除的节点是叶子节点，则直接删除该节点
    // 2. 如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int val){

        if(this.left != null && this.left.val == val){
            this.left = null;
            return;
        }

        if(this.right != null && this.right.val == val){
            this.right = null;
            return;
        }

        // 需要向左子树进行递归删除
        if (this.left != null){
            this.left.delNode(val);
        }

        // 需要向右子树进行递归删除
        if (this.right != null){
            this.right.delNode(val);
        }

    }

    // 编写前序遍历的方法
    public void preOrder(){
        // 输出父节点
        System.out.println(this);
        // 递归向左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
        }

    }

    // 中序遍历
    public void omfixOrder(){
        // 递归向左子树前序遍历
        if(this.left != null){
            this.left.omfixOrder();
        }
        // 输出父节点
        System.out.println(this);

        // 递归向右子树前序遍历
        if(this.right != null){
            this.right.omfixOrder();
        }

    }

    // 后序遍历
    public void postOrder(){

        // 递归向左子树前序遍历
        if(this.left != null){
            this.left.postOrder();
        }
        // 递归向右子树前序遍历
        if(this.right != null){
            this.right.postOrder();
        }

        // 输出父节点
        System.out.println(this);

    }

    // 前序遍历查找
    /*
    * @param val 查找val
    * @param return 如果找到就返回该Node, 如果没有找到就返回Null
    *
    * */
    public HeroNode preOrderSearch(int val){
        System.out.println("进入前序遍历~~");
        // 比较当前节点是否是要查找的节点
        if (this.val == val){
            return this;
        }
        // 1. 判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        // 2. 如果左递归前序查找，找到节点，则返回
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(val);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.left != null){
            resNode = this.right.preOrderSearch(val);
        }
        return resNode;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int val){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(val);
        }

        if (resNode != null){
            return resNode;
        }
        System.out.println("进入中序遍历查找~~");
        // 如果找到，则返回，如果没有找到，就和当前节点比较，并且如果当前节点的值就是要找的，返回当前的值
        if(this.val == val){
            return this;
        }

        // 继续向右递归中序查找
        if(this.right != null){
            resNode = this.right.infixOrderSearch(val);
        }
        return resNode;
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int val){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(val);
        }
        if (resNode != null){ // 说明在左子树找到
            return resNode;
        }

        // 如果左子没找到，则向右子树递归查找
        if (this.right != null){
            resNode = this.right.postOrderSearch(val);
        }

        if (resNode != null){ // 说明在右子树找到
            return resNode;
        }
        System.out.println("进入后序遍历查找~~");
        // 若果左右子树都没找到，就比较当前节点

        if (this.val == val){
            return this;
        }
        return resNode;
    }

}
