package leetcode.offer;

/**
 * 在一个 n * m
 * 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
public class LeetCode4 {

    public static void main(String[] args) {
        // int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3,
        // 6, 9, 16, 22 },
        // { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        int[][] matrix = new int[][] { {  } };
        System.out.println(findNumberIn2DArray(matrix, 3));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length < 1) {
                return false;
            } else if (matrix[i].length < 2) {
                if (matrix[i][0] == target) {
                    return true;
                } else {
                    continue;
                }
            } else {
                int L = 0;
                int R = matrix[i].length - 1;
                while (L <= R) {
                    int mid = L + ((R - L) >> 1);
                    if (matrix[i][mid] > target) {
                        R = mid - 1;
                    } else if (matrix[i][mid] < target) {
                        L = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
