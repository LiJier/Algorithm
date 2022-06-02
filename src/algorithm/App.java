package algorithm;
public class App {
    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() {
        int a = 101;
        int b = 111;
        System.out.printf("a^b = %d\n", a ^ b);
        a = a ^ b;
        System.out.printf("a = %d ", a);
        System.out.printf("b = %d\n", b);
        b = a ^ b;
        System.out.printf("a = %d ", a);
        System.out.printf("b = %d\n", b);
        a = a ^ b;
        System.out.printf("a = %d ", a);
        System.out.printf("b = %d\n", b);
    }

}