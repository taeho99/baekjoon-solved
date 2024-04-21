import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n+2];
        int[] pay = new int[n+2];
        int[] dp = new int[n+2];
        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for(int i=1; i<=n+1; i++) {
            max = Math.max(max, dp[i]);

            int end = i + time[i];
            if(end <= n+1)
                dp[end] = Math.max(dp[end], max + pay[i]);
        }
        System.out.println(dp[n+1]);
    }
}
