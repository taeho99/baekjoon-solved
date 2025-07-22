import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size = Integer.parseInt(br.readLine());
		int[][] map = new int[size][size];
		for(int row=0; row<size; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<size; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[size][size];
		dp[0][0] = 1;
		for(int row=0; row<size; row++) {
			for(int col=0; col<size; col++) {
				if (map[row][col] == 0) continue;
				if (row + map[row][col] < size) dp[row + map[row][col]][col] += dp[row][col];
				if (col + map[row][col] < size) dp[row][col + map[row][col]] += dp[row][col];
			}
		}
		System.out.println(dp[size-1][size-1]);
	}
}
