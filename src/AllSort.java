/**
 * @Author xiongwei
 * @WriteTime 2020-12-10 14:43
 */

public class AllSort {

    static int  len;

    //冒泡排序
    public static void  bubbleSort(int[] arr){
        int length = arr.length;
        for (int i = 0 ; i < length - 1 ; i++){
            for (int j = 0 ; j < length - 1 ; j++){
                if (arr[j] > arr[j + 1]){
                    int k = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = k;
                }
            }
        }
    }

    //选择排序
    public static void selectionSort(int[] arr){
        int len = arr.length;
        int minIndex,temp;
        for (int i = 0 ; i < len  ; i++){
            minIndex = i;
            for (int j = i + 1; j < len ; j++){
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    //插入排序
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        int waitNum;
        for (int i = 1 ; i < len ; i++){
            int preIndex = i - 1;
            waitNum = arr[i];
            while (preIndex >= 0 && waitNum < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = waitNum;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int temp;
        //增量gap逐渐减少gap
        for (int gap = len / 2 ; gap > 0 ; gap /= 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap ; i < len ; i++){
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]){
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = current;
            }
        }
    }

    //堆排序
    public static void heapSort(int[] arr){
        //建立大顶堆
        buildMaxHeap(arr);

        for (int i = len - 1 ; i > 0 ; i--){
            swap(arr,0,i);
            len--;
            heapify(arr,0);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        len = arr.length;
        for (int i = len / 2 ; i >= 0; i--){
            heapify(arr,i);
        }
    }

    //堆调整
    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int large = i;
        if (left < len && arr[left] > arr[large]){
            large = left;
        }
        if (right < len && arr[right] > arr[large]){
            large = right;
        }
        if (large != i){
            swap(arr,large,i);
            heapify(arr, large);
        }
    }

    private static void swap(int[] arr, int large, int i) {
        int temp = arr[i];
        arr[i] = arr[large];
        arr[large] = temp;
    }
}
