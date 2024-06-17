import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        System.out.print(fibo(n));
    }

    private static long fibo(int n) {
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibo(n-1) + fibo(n-2);
    }
}
