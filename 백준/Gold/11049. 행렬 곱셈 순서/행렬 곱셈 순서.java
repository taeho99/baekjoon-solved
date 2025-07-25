import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size = Integer.parseInt(br.readLine());

		int[][] matrixSize = new int[size][2];
		int[][] dp = new int[size][size];

		for(int idx=0; idx<size; idx++) {
			st = new StringTokenizer(br.readLine());
			matrixSize[idx][0] = Integer.parseInt(st.nextToken());
			matrixSize[idx][1] = Integer.parseInt(st.nextToken());
		}

		for(int len=2; len<=size; len++) {
			for(int i=0; i<=size-len; i++) {
				int j = i + len - 1;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k=i; k<j; k++) {
					int cost = dp[i][k] + dp[k+1][j] + matrixSize[i][0] * matrixSize[k][1] * matrixSize[j][1];
					dp[i][j] = Math.min(dp[i][j], cost);
				}
			}
		}

		System.out.println(dp[0][size-1]);
	}
}
