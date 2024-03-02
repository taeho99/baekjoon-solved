import java.util.*;

public class Main {
    static int[] dp = new int[1001];
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        System.out.print(dp[n]);
    }
}
