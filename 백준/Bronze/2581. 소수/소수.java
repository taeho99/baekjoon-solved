import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int min = 0, sum = 0;
        for(int i=b; i>=a; i--) {
            if(isPrime(i)) {
                min = i;
                sum += i;
            }
        }
        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
    static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i == 0)
                return false;
        return true;
    }
}
