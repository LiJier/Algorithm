package algorithm;

import algorithm.Utils.ProcessListener;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        Utils.textProcess(new ProcessListener() {

            @Override
            public void process(int[] arr) {
                selectSort(arr);
            }

        });
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
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
