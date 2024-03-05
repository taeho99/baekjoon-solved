import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<3; j++) {
                int min = Integer.MAX_VALUE;
                for(int k=0; k<3; k++) {
                    if (j != k && min > dp[i-1][k]) {
                        min = dp[i-1][k];
                    }
                }
                dp[i][j] += min;
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) {
            if (answer > dp[n-1][i]) answer = dp[n-1][i];
        }
        System.out.print(answer);
    }
}
