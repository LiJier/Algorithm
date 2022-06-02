package algorithm;
import java.util.Arrays;

/**
 * 归并排序
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] arr1 = Utils.getArray();
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        boolean b = true;
        for (int i = 0; i < 500000; i++) {
            process(arr1, 0, arr1.length - 1);
            Utils.sort(arr2);
            if (!Utils.arrEquals(arr1, arr2)) {
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        // 求L与R的中点
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
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
