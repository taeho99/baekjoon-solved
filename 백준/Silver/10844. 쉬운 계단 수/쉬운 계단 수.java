import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[][] dp = new long[n+1][10];
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }
        for(int i=2; i<=n; i++) {
            for(int j=0; j<=9; j++) {
                if(j == 0) {
                    dp[i][0] = dp[i-1][1];
                } else if (j == 9) {
                    dp[i][9] = dp[i-1][8];
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
                dp[i][j] = dp[i][j] % 1000000000;
            }
        }
        long sum = 0;
        for(int i=0; i<10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 1000000000);
    }
}
