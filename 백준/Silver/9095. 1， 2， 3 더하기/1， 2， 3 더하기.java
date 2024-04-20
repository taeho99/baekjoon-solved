import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i=0; i<t; i++) {
            int n = input.nextInt();
            int[] dp = new int[n+4];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int j=4; j<=n; j++) {
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            System.out.println(dp[n]);
        }
    }
}
