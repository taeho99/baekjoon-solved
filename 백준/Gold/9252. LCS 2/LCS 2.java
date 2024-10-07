import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] dp = new int[a.length+1][b.length+1];
        for(int row=1; row<=a.length; row++) {
            for(int col=1; col<=b.length; col++) {
                if(a[row-1] == b[col-1]) {
                    dp[row][col] = dp[row-1][col-1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }

        System.out.println(dp[a.length][b.length]);
        if(dp[a.length][b.length] == 0) return;

        StringBuilder sb = new StringBuilder();
        int row = a.length, col = b.length;
        while(dp[row][col] != 0) {
            if(dp[row][col] == dp[row-1][col]) {
                row--;
            } else if (dp[row][col] == dp[row][col-1]) {
                col--;
            } else {
                sb.append(a[row-1]);
                row--; col--;
            }
        }

        System.out.println(sb.reverse());
    }
}