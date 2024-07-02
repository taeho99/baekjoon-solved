import java.util.Scanner;

public class Main {
    static final double PI = 3.141593;
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.printf("%.6f\n", n * n * Math.PI);
        System.out.printf("%.6f", (double)(2*n * n));
    }
}
