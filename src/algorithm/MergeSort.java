package algorithm;

import algorithm.Utils.ProcessListener;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        Utils.textProcess( new ProcessListener() {

            @Override
            public void process(int[] arr) {
                MergeSort.mergeSort(arr);
            }

        });
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        // 求L与R的中点
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

}
