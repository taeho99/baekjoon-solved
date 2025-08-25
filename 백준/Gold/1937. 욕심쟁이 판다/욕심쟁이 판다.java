import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int size;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		dp = new int[size][size];

		for(int row=0; row<size; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<size; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for(int row=0; row<size; row++) {
			for(int col=0; col<size; col++) {
				answer = Math.max(answer, dfs(row, col));
			}
		}
		System.out.println(answer);
	}

	static int dfs(int row, int col) {
		if(dp[row][col] != 0) {
			return dp[row][col];
		}

		dp[row][col] = 1;

		for(int dir=0; dir<4; dir++) {
			int nRow = row + dRow[dir];
			int nCol = col + dCol[dir];

			if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;

			if(map[nRow][nCol] > map[row][col]) {
				dp[row][col] = Math.max(dp[row][col], dfs(nRow, nCol) + 1);
				dfs(nRow, nCol);
			}
		}

		return dp[row][col];
	}
}
