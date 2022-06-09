package leetcode;

public class LeetCode28 {

    public static void main(String[] args) {
        System.out.println(strStr("aba", "a"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int startIndex = 0;
        while (startIndex < haystack.length() - needle.length()) {
            if (haystack.substring(startIndex, startIndex).equals(needle.substring(0, 0))) {
                if (startIndex + needle.length() <= haystack.length()) {
                    String sub = haystack.substring(startIndex, startIndex + needle.length());
                    if (sub.equals(needle)) {
                        return startIndex;
                    }
                }
            }
            startIndex++;
        }
        return -1;
    }

}
