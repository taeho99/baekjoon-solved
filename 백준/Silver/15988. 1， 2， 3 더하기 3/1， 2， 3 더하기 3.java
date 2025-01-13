import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int idx=4; idx<=1_000_000; idx++) {
            dp[idx] = (dp[idx-1] + dp[idx-2] + dp[idx-3]) % 1_000_000_009;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }
}