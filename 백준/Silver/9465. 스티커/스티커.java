import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(n == 1) {
                sb.append(Math.max(dp[0][0], dp[1][0])).append('\n');
                continue;
            }

            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];
            int answer = Math.max(dp[0][1], dp[1][1]);
            for(int j=2; j<n; j++) {
                for(int i=0; i<2; i++) {
                    int max = dp[0][j-2];
                    max = Math.max(max, dp[1][j-2]);
                    if(i != 0)
                        max = Math.max(max, dp[0][j-1]);
                    else
                        max = Math.max(max, dp[1][j-1]);
                    dp[i][j] += max;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
