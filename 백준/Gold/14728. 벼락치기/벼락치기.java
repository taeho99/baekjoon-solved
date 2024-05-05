import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer[][] dp;
    static int[] w, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        w = new int[n];
        v = new int[n];
        dp = new Integer[n][k+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(ns(n-1, k));
    }

    private static int ns(int i, int k) {
        if(i < 0)
            return 0;
        if(dp[i][k] == null) {
            if(w[i] <= k) {
                dp[i][k] = Math.max(ns(i-1, k), ns(i-1, k-w[i]) + v[i]);
            } else {
                dp[i][k] = ns(i-1, k);
            }
        }
        return dp[i][k];
    }
}
