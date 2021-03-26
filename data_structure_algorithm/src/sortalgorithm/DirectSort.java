package sortalgorithm;

import java.util.Arrays;

public class DirectSort {
    public static void main(String[] args) {
        int[] array = {9,4,5,6,2,1,0,8,3,7};
        DirectSort ds = new DirectSort();
        int[] ans = ds.directSort(array); // 建议用类名.静态方法
        System.out.println(Arrays.toString(ans));
    }

    public int[] directSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            // 要插入的数字
            int insertvalue = arr[i];
            // 被插入的位置
            int index = i - 1;
            while (index >= 0 && insertvalue < arr[index]){

                // 将arr[index]后移，
                arr[index+1] = arr[index];

                // 让index前移
                index--;
            }

            // 前面进行了index--，发现不满足条件，所以这里需要将index+1再进行赋值
            arr[index+1] = insertvalue;
        }

        return arr;
    }
}
