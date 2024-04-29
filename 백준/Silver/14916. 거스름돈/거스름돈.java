import java.util.Scanner;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] dp = new int[n+1+6];
        dp[0] = INF;
        dp[1] = INF;
        dp[2] = 1;
        dp[3] = INF;
        dp[4] = 2;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
        }
        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}
