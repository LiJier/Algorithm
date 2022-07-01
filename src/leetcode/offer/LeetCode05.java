package leetcode.offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
public class LeetCode05 {

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }

}
