package sortalgorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        int[] ans = qs.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(ans));
    }

    // 函数输入一个整数数组，以及指定的起始位置和终结位置的子数组，需要对子数组进行排序
    public int[] quickSort(int[] arr, int low, int high){

        // 能够进行排序的前提条件是左边界小于右边界
        if(low < high){
            // 初始化工作
            int i = low;
            int j = high;
            int key = arr[i];  // 一般选取第一个位置作为关键字进行比较

            // 一次比较就是得到了关键字的位置，在其左边的比key小，在key右边的比key大
            while (j > i){

                //从后往前比较,直到找到第一个符合 arr[j]<key的arr[j]
                while (j > i && arr[j] >= key){
                    //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                    j--;
                }
                // 如果上面的arr[j] >= key不成立并且j > i，就意味着找到了一个小于key的arr值
                if (j > i){
                    arr[i] = arr[j];
                    i++;
                }

                //从前往后比较，直到找到第一个符合 arr[i]>=key的arr[i]
                while (j > i && arr[i] < key){
                    // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                    i++;
                }
                if (j > i){
                    arr[j] = arr[i];
                    j--;
                }
            }

            // 当i和j第一次相遇时i==j，该轮排序结束，并且把key的值赋给arr[i]
            arr[i] = key;
            System.out.println("i = " + i + "j = " +j); // 为什么第一次相遇时会出现i ！= j的情况？？？？？、

            // 巧妙的递归
            if(low < j-1) quickSort(arr, low, j-1);
            if(i+1< high) quickSort(arr, i+1, high);

        }
        return arr;
    }

}
