import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=0; t<3; t++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger result = BigInteger.ZERO;
            while(n-- > 0) {
                result = result.add(new BigInteger(br.readLine()));
            }
            int compare = result.compareTo(BigInteger.ZERO);
            System.out.println(compare == 0 ? "0" : (compare > 0 ? "+" : "-"));
        }
    }
}