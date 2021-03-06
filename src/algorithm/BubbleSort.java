package algorithm;

import algorithm.Utils.ProcessListener;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        Utils.textProcess(new ProcessListener() {

            @Override
            public void process(int[] arr) {
                bubbleSort(arr);
            }

        });
    }

    public static void bubbleSort(int[] arr) {
        int N = arr.length - 1;
        for (int i = N; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);
                }
            }
        }
    }

}
