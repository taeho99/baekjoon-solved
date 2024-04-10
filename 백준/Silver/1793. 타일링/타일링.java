import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger[] dp = new BigInteger[251];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for(int i=3; i<=250; i++) {
            dp[i] = dp[i-1].add(dp[i-2].add(dp[i-2]));
        }

        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            System.out.println(dp[n]);
        }
    }
}
