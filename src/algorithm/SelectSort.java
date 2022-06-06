package algorithm;

import algorithm.Utils.ProcessListener;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = Utils.getArray();
        Utils.textProcess(arr, new ProcessListener() {

            @Override
            public void process() {
                selectSort(arr);
            }

        });
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i; j < arr.length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
                if (minValueIndex != i) {
                    Utils.swap(arr, i, minValueIndex);
                }
            }
        }
    }

}
