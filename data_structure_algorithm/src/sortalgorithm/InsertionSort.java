package sortalgorithm;

import java.util.Arrays;

/**
 * 把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，
 * 无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，
 * 使之成为新的有序表。
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        InsertionSort insertion = new InsertionSort();
        insertion.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insertVal <  arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
    }
}
