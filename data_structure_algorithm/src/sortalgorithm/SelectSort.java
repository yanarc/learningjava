package sortalgorithm;

import java.util.Arrays;

/**
 * 它的基本思想是：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，第三次从arr[2]~arr[n-1]
 * 中选取最小值，与arr[2]交换，…，第i次从arr[i-1]~arr[n-1]中选取最小值，
 * 与arr[i-1]交换，…, 第n-1次从arr[n-2]~arr[n-1]中选取最小值，
 * 与arr[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 1, 9, 0, 8, 4, 5, 2};
        SelectSort select = new SelectSort();
        select.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            int min = arr[i];
            int min_idex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(min > arr[j]){
                    min  = arr[j];
                    min_idex = j;
                }
            }

            arr[min_idex] = arr[i];
            arr[i] = min;
        }
    }
}
