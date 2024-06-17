import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());

        BigInteger sum = new BigInteger("1");
        BigInteger f1 = new BigInteger("0");
        BigInteger f2 = new BigInteger("1");

        for(int i=1; i<n.intValue(); i++) {
            sum = f1.add(f2);
            f1 = f2;
            f2 = sum;
        }

        if(n.intValue() == 0)
            System.out.println("0");
        else
            System.out.println(sum);
    }
}
