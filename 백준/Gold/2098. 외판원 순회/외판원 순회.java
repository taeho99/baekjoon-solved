import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] weight;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		weight = new int[n][n];
		dp = new int[n][1<<n];

		for(int row=0; row<n; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<n; col++) {
				weight[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for(int row=0; row<n; row++) {
			Arrays.fill(dp[row], -1);
		}

		System.out.println(tsp(0, 1));

	}

	static int tsp(int cur, int visited) {
		if(visited == (1<<n) - 1) {
			if(weight[cur][0] == 0) return 999_999_999;
			return weight[cur][0];
		}

		if(dp[cur][visited] != -1) {
			return dp[cur][visited];
		}

		dp[cur][visited] = 999_999_999;

		for(int next=0; next<n; next++) {
			if((visited & (1<<next)) != 0) continue; // 이미 방문한 경우
			if(weight[cur][next] == 0) continue; // 경로가 없는 경우
			dp[cur][visited] = Math.min(dp[cur][visited], tsp(next, visited | (1<<next)) + weight[cur][next]);
		}
		return dp[cur][visited];
	}
}
