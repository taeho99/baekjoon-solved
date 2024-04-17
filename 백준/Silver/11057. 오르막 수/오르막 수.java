import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] dp = new int[n+1][10];

        for(int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                int sum = 0;
                for(int k=0; k<=j; k++) {
                    sum += dp[i-1][k] % 10007;
                }
                dp[i][j] = sum % 10007;
            }
        }

        int answer = 0;
        for(int i=0; i<10; i++) {
            answer += dp[n][i];
        }
        System.out.println(answer % 10007);
    }
}
