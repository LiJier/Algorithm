package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static int[] getArray() {
        Random random = new Random();
        int length = random.nextInt(20);
        int max = random.nextInt(1000);
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

}