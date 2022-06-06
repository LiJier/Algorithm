
package leetcode;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class LeetCode6 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        char[] charArr = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];
        int sbIndex = 0;
        boolean indexP = true;
        for (int i = 0; i < charArr.length; i++) {
            StringBuilder sb = sbs[sbIndex];
            if (sb == null) {
                sb = new StringBuilder();
                sbs[sbIndex] = sb;
            }
            sb.append(charArr[i]);
            if (indexP) {
                sbIndex++;
                if (sbIndex >= sbs.length - 1) {
                    sbIndex = sbs.length - 1;
                    indexP = false;
                }
            } else {
                sbIndex--;
                if (sbIndex <= 0) {
                    sbIndex = 0;
                    indexP = true;
                }
            }
        }
        StringBuilder allSb = new StringBuilder();
        for (StringBuilder sb : sbs) {
            if (sb != null) {
                allSb.append(sb);
            }
        }
        return allSb.toString();
    }

}