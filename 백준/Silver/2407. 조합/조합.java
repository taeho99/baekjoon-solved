import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        if(m > n/2) {
            m = n-m;
        }

        BigInteger ja = new BigInteger("1");
        BigInteger mo = new BigInteger("1");
        int idx = 1;

        for(int i = n; i>n-m; i--) {
            ja = ja.multiply(new BigInteger(String.valueOf(i)));
            mo = mo.multiply(new BigInteger(String.valueOf(idx++)));
        }

        System.out.println(ja.divide(mo));
    }
}
