package algorithm;

import algorithm.Utils.ProcessListener;

/**
 * 快速排序
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = Utils.getArray();
        Utils.textProcess(arr, new ProcessListener() {

            @Override
            public void process() {
                fastSort(arr, 0, arr.length - 1);
            }

        });
    }

    public static void fastSort(int[] arr, int L, int R) {
        if (L < R) {
            Utils.swap(arr, L + (int) Math.random() * (R - L + 1), R);
            int[] p = partition(arr, L, R);
            fastSort(arr, L, p[0] - 1);
            fastSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int l = L - 1;
        int r = R;
        while (L < r) {
            if (arr[L] < arr[R]) {
                Utils.swap(arr, ++l, L++);
            } else if (arr[L] > arr[R]) {
                Utils.swap(arr, --r, L);
            } else {
                L++;
            }
        }
        Utils.swap(arr, r, R);
        return new int[] { l + 1, r };
    }

}
