package sortalgorithm;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {10,2,3,41,5,6,32,9};
        int[] temp = new int[arr.length];
        mergeSort.sort(arr,0,arr.length-1,temp);
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp){
        int i = 0;
        int j = low, k = mid + 1;
        while (j <= mid && k <= high){
            if(arr[j] < arr[k]) {
                temp[i++] = arr[j];
            }else {
                temp[i++] = arr[j];
            }
        }
        // 若左边序列还有剩余，则将其全部拷贝进temp[]中
        while (j <= mid) temp[i++] = arr[j++];
        while (k <= high) temp[i++] = arr[k++];

        for(int t = 0; t < i; t++){
            arr[low+t] = temp[t]; // 之前的排序好的结果只是临时存储在temp数组中，现在要把这一部分复制到原来的arr[]数组中
        }

    }

    public static void sort(int[] arr, int low, int high, int[] temp){
        if(low < high){
            int mid = (low+high)/2;
            sort(arr, low, mid, temp);
            sort(arr,mid+1, high,temp);
            merge(arr,low,mid,high,temp);
        }
    }


}
