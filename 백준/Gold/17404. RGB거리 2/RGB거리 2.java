import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int homeCnt = Integer.parseInt(br.readLine());
        int[][] cost = new int[homeCnt][3];

        for(int idx=0; idx<homeCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            cost[idx][0] = Integer.parseInt(st.nextToken());
            cost[idx][1] = Integer.parseInt(st.nextToken());
            cost[idx][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[homeCnt][3];
        int result = Integer.MAX_VALUE;
        for(int firstHomeColor=0; firstHomeColor<3; firstHomeColor++) {
            for(int lastHomeColor=0; lastHomeColor<3; lastHomeColor++) {
                if(firstHomeColor == lastHomeColor) {
                    dp[homeCnt - 1][lastHomeColor] = 1000001;
                } else {
                    dp[homeCnt - 1][lastHomeColor] = cost[homeCnt - 1][lastHomeColor];
                }
            }

            for(int idx=homeCnt-2; idx>=0; idx--) {
                dp[idx][0] = Math.min(dp[idx+1][1], dp[idx+1][2]) + cost[idx][0];
                dp[idx][1] = Math.min(dp[idx+1][0], dp[idx+1][2]) + cost[idx][1];
                dp[idx][2] = Math.min(dp[idx+1][0], dp[idx+1][1]) + cost[idx][2];
            }

            for(int lastHomeColor=0; lastHomeColor<3; lastHomeColor++) {
                if(firstHomeColor == lastHomeColor) continue;
                result = Math.min(result, dp[0][firstHomeColor]);
            }
        }

        System.out.println(result);
    }
}