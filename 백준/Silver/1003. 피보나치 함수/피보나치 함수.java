import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+2];
            dp[0] = 0; dp[1] = 1;
            for(int i=2; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            if (n==0) {
                sb.append(1).append(' ').append(0).append('\n');
            } else {
                sb.append(dp[n - 1]).append(' ').append(dp[n]).append('\n');
            }
        }
        System.out.print(sb);
    }
}
