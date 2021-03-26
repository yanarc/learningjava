package sortalgorithm;

import java.util.Arrays;

/**
 * 参考： https://blog.csdn.net/qichangjian/article/details/87699215
 * a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆; （升序对应大顶堆）
 * b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 1, 9, 0, 8, 4, 5, 2};
        HeapSort heap = new HeapSort();
        heap.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 堆排序的前提条件是完全二叉树,只有完全二叉树才满足以下性质
    // 1. 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
    // 2. 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
    public static void heapSort(int[] arr) {
        //1.构建初始大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {   //  i = arr.length / 2 - 1 表示第一个非叶子节点的值
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }
        //2.调整堆结构 + 交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);//重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr    待调整的数组
     * @param i      表示要对哪一个节点进行堆调整
     * @param length 表示对多少数组进行继续调整，length逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 先假设arr[i] 是最大的节点
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 找出左右子节点最大的节点，并记录为arr[k]
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 不超出所有元素的索引，如果当前非叶子节点的左子节点比右子节点要小，那么k就指向右子节点
                k++; //
            }

            if (arr[k] > temp) { //arr[k] 已经是左右子节点最大的一个了
                arr[i] = arr[k]; // 将较大值赋值给当前节点i
                i = k; // i指向k(左右子节点), 继续循环
            } else {
                break;  // 因为之前已经建立了初始堆，只要当前arr[i]比左右子节点大，那么在i之后肯定会有大顶堆成立
            }

        }

        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
