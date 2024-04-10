import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp = new long[91];
    public static void main(String[] args) throws IOException {
        dp[1] = dp[2] = 1;
        for(int i=3; i<=90; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())]);
    }
}
