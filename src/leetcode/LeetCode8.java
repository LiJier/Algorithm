package leetcode;

public class LeetCode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
    }

    public static int myAtoi(String s) {
        char[] charArr = s.toCharArray();
        char symbol = ' ';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if ((Character.isLetter(c) || c == '.') && symbol == ' ') {
                break;
            } else if ((c == '-' || c == '+') && symbol == ' ' && sb.length() == 0) {
                symbol = c;
            } else if (Character.isDigit(c) && sb.length() == 0 && symbol == ' ') {
                symbol = '+';
                sb.append(c);
            } else if (symbol != ' ' && sb.length() == 0 && !Character.isDigit(c)) {
                break;
            } else if (!Character.isDigit(c) && sb.length() > 0) {
                break;
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        String sNum = symbol == '-' ? "-" + sb.toString() : sb.toString();
        int num;
        try {
            num = Integer.parseInt(sNum);
        } catch (NumberFormatException e) {
            num = symbol == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return num;
    }

}
