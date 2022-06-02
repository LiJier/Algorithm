package algorithm;
import java.util.Arrays;

/**
 * 快速排序
 */
public class Sort2 {

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
        if (L < R) {
            Utils.swap(arr, L + (int) Math.random() * (R - L + 1), R);
            int[] p = partition(arr, L, R);
            process(arr, L, p[0] - 1);
            process(arr, p[1] + 1, R);
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
