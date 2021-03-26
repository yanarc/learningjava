package sortalgorithm;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待
 * 排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐
 * 从前移向后部，就象水底下的气泡一样逐渐向上冒。
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 1, 9, 0, 8, 4, 5, 2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            // 优化器,如果在某一次循环没有交换，说明可以退出循环了
            boolean flag = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j+1] < arr[j]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }
}
