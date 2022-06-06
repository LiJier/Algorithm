package algorithm;

public class Bit {

    public static void main(String[] args) {
        printBit(Integer.MIN_VALUE-1);
        System.out.println();
        System.out.println(-Integer.MIN_VALUE-1);
    }

    public static void printBit(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

}