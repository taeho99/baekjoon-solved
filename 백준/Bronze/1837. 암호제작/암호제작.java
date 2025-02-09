import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] a) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger P = new BigInteger(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());
        BigInteger i = BigInteger.ONE;

        while(true) {
            if (i.compareTo(K) >= 0) {
                System.out.print("GOOD");
                return;
            }

            i = i.add(BigInteger.ONE);

            if(P.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(K) < 0) {
                System.out.println("BAD " + i);
                return;
            }
        }
    }
}