package treetest;

import java.util.Arrays;
// 堆排序的
public class HeapSort {

    public static void main(String[] args) {
        //对数组进行升序排列
        int[] arr = {4,6,7,8,9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序！");

//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次调整得到的结果："+ Arrays.toString(arr));
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次调整得到的结果："+ Arrays.toString(arr));

        for (int i = arr.length/2 -1; i>=0; i--){ //i = arr.length/2-1 表示非叶子节点的个数
            adjustHeap(arr, i, arr.length);
        }
//        adjustHeap(arr, 0, arr.length);
        System.out.println("数组为："+Arrays.toString(arr));

        for (int j = arr.length-1; j>0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }


        System.out.println("数组为："+Arrays.toString(arr));


    }
    // 如果要将数组（二叉树）升序排序的话，就调整称为一个大顶堆（降序排序小顶堆）

    /**
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少数组进行继续调整，length逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i]; // i 表示当前元素的索引

        // k = i * 2 + 1 表示k是节点i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 不超出所有元素的索引，
                k++; // 如果当前非叶子节点的左子节点比右子节点要小，那么k就指向右子节点
            }
            if (arr[k] > temp) { //arr[k] 已经是左右子节点最大的一个了
                arr[i] = arr[k]; // 将较大值赋值给当前节点
                i = k; // i指向k, 继续循环
            } else {
                break; // for循环本身就是希望往下走，但是这里这是比较了一下就已经break了
            }
        }
        // 当for循环结束的时候，已经将i为父节点的树最大值放到了顶点了
        arr[i] = temp;
    }
}


