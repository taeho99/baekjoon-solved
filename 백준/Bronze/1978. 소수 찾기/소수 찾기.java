import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int count = 0;
        for(int i=0; i<t; i++) {
            int n = input.nextInt();
            if(n != 1 && isPrime(n)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
