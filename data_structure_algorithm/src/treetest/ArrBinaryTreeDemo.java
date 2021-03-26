package treetest;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);

    }
}

// 编写一个ArrayBinaryTree,实现顺序存储二叉树遍历
class ArrayBinaryTree{
    private int[] arr;

    // 构造器
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("该数组为空，不可以转化");
        }

        // 输出当前元素
        System.out.println(arr[index]);

        // 左递归输出元素
        if(2*index+1 < arr.length){
            preOrder(2*index+1);
        }


        // 右递归输出元素
        if(2*index+2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }

}
