import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combi(m, n)).append('\n');
        }
        System.out.print(sb);
    }

    static int combi(int n, int r) {
        if(dp[n][r] > 0) return dp[n][r];
        if(n == r || r == 0) return dp[n][r] = 1;
        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
