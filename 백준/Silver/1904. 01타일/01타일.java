import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] dp = new int[1000001];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Arrays.fill(dp, -1);
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        System.out.println(recur(n));
    }

    private static int recur(int n) {
        if(dp[n] == -1) {
            dp[n] = ((recur(n-1) + recur(n-2))) % 15746;
        }
        return dp[n];
    }
}
