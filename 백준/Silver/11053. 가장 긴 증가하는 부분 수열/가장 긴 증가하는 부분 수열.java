import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[] dp;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new Integer[n];
        seq = new int[n];
        for(int i=0; i<n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++) {
            LIS(i);
        }
        int max = dp[0];
        for(int i=1; i<n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int LIS(int N) {
        if(dp[N] == null) {
            dp[N] = 1;

            for(int i=N-1; i>=0; i--) {
                if(seq[i] < seq[N]) {
                    dp[N] = Math.max(dp[N], LIS(i)+1);
                }
            }
        }
        return dp[N];
    }
}
