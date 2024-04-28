import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][][] dp = new int[n][m][3];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0) {
                    for(int k=0; k<3; k++)
                        dp[i][j][k] = arr[i][j];
                }
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<3; k++) {
                    if((j == 0 && k == 0) || (j == m-1 && k == 2)) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                        continue;
                    }

                    if(k == 0)
                        dp[i][j][k] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                    else if(k == 1)
                        dp[i][j][k] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    else
                        dp[i][j][k] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int min = Math.min(dp[n - 1][j][0], Math.min(dp[n - 1][j][1], dp[n - 1][j][2]));
            result = Math.min(min, result);
        }
        System.out.println(result);
    }

}

