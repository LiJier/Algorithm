package algorithm;

import algorithm.Utils.ProcessListener;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = Utils.getArray();
        Utils.textProcess(arr, new ProcessListener() {

            @Override
            public void process() {
                insertSort(arr);
            }

        });
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                Utils.swap(arr, j, j + 1);
            }
        }
    }

}
