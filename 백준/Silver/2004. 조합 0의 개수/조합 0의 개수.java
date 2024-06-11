import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int five = five(n) - five(n-m) - five(m);
        int two = two(n) - two(n-m) - two(m);
        System.out.print(Math.min(five, two));
    }
    static int five(int n) {
        int count = 0;
        while(n >= 5) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    static int two(int n) {
        int count =0 ;
        while(n >= 2) {
            count += n/2;
            n /= 2;
        }
        return count;
    }
}
