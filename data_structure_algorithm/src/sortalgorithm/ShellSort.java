package sortalgorithm;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 1, 9, 0, 8, 4, 5, 2};
        ShellSort shell = new ShellSort();
        shell.shellsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 希尔排序
    public void shellsort(int[] arr){
        int temp;
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素，共gap组，每组有length/gap个元素，步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

}
