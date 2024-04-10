import java.util.*;

public class Main {
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=1000; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        int n = input.nextInt();
        System.out.println(dp[n]);
    }
}
