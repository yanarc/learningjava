package treetest.threadedbinarytree;

import sun.applet.AppletResourceLoader;

import java.net.HttpRetryException;

/**
 * 线索化二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        // 测试一把
        HeroNode root = new HeroNode(1, "tom");
        HeroNode heroNode2 = new HeroNode(3, "jack");
        HeroNode heroNode3 = new HeroNode(6, "smith");
        HeroNode heroNode4 = new HeroNode(8, "mary");
        HeroNode heroNode5 = new HeroNode(10, "king");
        HeroNode heroNode6 = new HeroNode(14, "dim");

        // 二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        // 测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();

        // 怎样测试：10号节点
        HeroNode left = heroNode5.getLeft();
        HeroNode right = heroNode5.getRight();
        System.out.println("10号节点的前驱结点是："+ left);
        System.out.println("10号节点的后继结点是："+ right);

    }



}

class ThreadedBinaryTree{
    // 树先初始化一个根节点
    private HeroNode root;

    //为了线索化，需要创建指向当前节点前驱结点的指针
    // 在递归线索化,pre总是保留前一个节点
    private HeroNode pre = null;

    public ThreadedBinaryTree() {

    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 对下面函数在进行重载
    public void threadedNode(){
        this.threadedNode(root);
    }

    // 遍历线索二叉树的方法

    /**
     *
     * @param node
     */
    public void threadedNode(HeroNode node){
        // 如果node==null，就是不能线索化
        if (node == null){
            return;
        }

        // 先线索化左子树
        threadedNode(node.getLeft());

        // 线索化当前节点
        // 1 处理当前节点的前驱结点
        if(node.getLeft() == null){
            // 让当前节点的左指针指向前驱结点
            node.setLeft(pre);
            // 修改当前左指针的类型，表示指向前驱结点
            node.setLeftType(1);
        }
        // 2 处理后继节点
        if(pre != null && pre.getRight() != null){
            // 让当前节点的前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改当前节点的前驱节点的右指针类型
            pre.setLeftType(1);
        }
        // 每处理一个节点，让当前节点变为下一个节点的前驱节点
        pre = node;

        // 线索化右子树
        threadedNode(node.getRight());
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


class HeroNode{
    private int val;
    private String name;
    private HeroNode left;
    private HeroNode right;

    // 如果leftType == 0, 表示该节点左指针指向左子树， ==1表示该节点左指针指向前驱节点
    // 如果leftType == 0, 表示该节点左指针指向左子树， ==1表示该节点左指针指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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