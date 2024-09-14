import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[10001][4];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for(int idx=4; idx<=10000; idx++) {
            dp[idx][1] = dp[idx-1][1];
            dp[idx][2] = dp[idx-2][1] + dp[idx-2][2];
            dp[idx][3] = dp[idx-3][1] + dp[idx-3][2] + dp[idx-3][3];
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append('\n');
        }
        System.out.print(sb);
    }
}