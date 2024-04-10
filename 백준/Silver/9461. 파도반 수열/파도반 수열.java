import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[101];
        int t = Integer.parseInt(br.readLine());

        dp[1] = dp[2] = dp[3] = 1;
        for(int i=4; i<=100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for(int i=0; i<t; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }
}
