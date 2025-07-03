import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger b1 = new BigInteger(input.next());
        BigInteger b2 = new BigInteger(input.next());
        System.out.println(b1.subtract(b2).abs());
    }
}
