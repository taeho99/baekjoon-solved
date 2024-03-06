import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            int[][] dp = new int[a+1][b+1];
            for(int i=1; i<=b; i++) {
                dp[0][i] = i;
            }
            for(int i=1; i<=a; i++) {
                for(int j=1; j<=b; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            System.out.println(dp[a][b]);
        }
    }
}
