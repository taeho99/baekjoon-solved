import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        int[] t = new int[n+1];
        int[] p = new int[n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            if(t[i] + i <= n+1) {
                dp[t[i]+i] = Math.max(dp[t[i]+i], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        System.out.println(dp[n+1]);
    }
}