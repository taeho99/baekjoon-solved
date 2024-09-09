import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *	BOJ.17069 파이프옮기기2
 *
 *	1. 맵 크기와 맵 정보 입력
 *	2. (0, 1)
 */
public class Main {
	static int size;
	static int[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		map = new int[size+1][size+1];
		for(int row=1; row<=size; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=1; col<=size; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new long[size+1][size+1][3];
		dp[1][2][0] = 1;
		for(int row=1; row<=size; row++) {
			for(int col=3; col<=size; col++) {
				if(map[row][col] == 1) continue;
				dp[row][col][0] = dp[row][col-1][0] + dp[row][col-1][2];
				dp[row][col][1] = dp[row-1][col][1] + dp[row-1][col][2];
				
				if(map[row-1][col] == 1 || map[row][col-1] == 1) continue;
				dp[row][col][2] = dp[row-1][col-1][0] + dp[row-1][col-1][1] + dp[row-1][col-1][2];
			}
		}
		
		
		System.out.println(dp[size][size][0] + dp[size][size][1] + dp[size][size][2]);
	}
}