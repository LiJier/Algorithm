package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static int[] getArray() {
        Random random = new Random();
        int length = random.nextInt(10);
        int max = 10;
        return random.ints(length, -max, max).toArray();
    }

    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean arrEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void textProcess(ProcessListener process) {
        for (int i = 0; i < 10000; i++) {
            int[] arr1 = getArray();
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] temp = Arrays.copyOf(arr1, arr1.length);
            process.process(arr1);
            Utils.sort(arr2);
            if (!Utils.arrEquals(arr1, arr2)) {
                System.out.println("测试失败");
                System.out.println(Arrays.toString(temp));
                break;
            }
        }
        System.out.println("测试成功");
    }

    public static interface ProcessListener {
        void process(int[] arr);
    }

}