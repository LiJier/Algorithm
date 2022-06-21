package leetcode;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * 
 * https://leetcode.cn/problems/excel-sheet-column-number/
 */
public class LeetCode171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZZA"));
    }

    public static int titleToNumber(String columnTitle) {
        char[] charArr = columnTitle.toCharArray();
        int ans = 0;
        int temp = 1;
        int N = charArr.length - 1;
        for (int i = N; i >= 0; i--) {
            char c = charArr[i];
            ans += (c - 'A' + 1) * temp;
            temp *= 26;
        }
        return ans;
    }

}
