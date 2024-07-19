import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] y = br.readLine().toCharArray();
		char[] x = br.readLine().toCharArray();
		
		int[][] dp = new int[y.length + 1][x.length + 1];
		
		for(int i=1; i<=y.length; i++) {
			for(int j=1; j<=x.length; j++) {
				if(y[i-1] != x[j-1]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				} else {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
			}
		}
		System.out.println(dp[y.length][x.length]);
	}
}
