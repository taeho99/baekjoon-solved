import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *	BOJ.17069 파이프옮기기2
 *
 *	1. 맵 크기와 맵 정보 입력
 *	2. dp[row][col][dir] 배열 선언 : (row,col) 위치의 dir 방향에서 경우의 수 저장
 *	3. (1,2)의 가로 방향 경우의 수 1로 초기화
 *	4. row=1~size, col=3~size dp 배열 채워넣기
 *		4-1. 현재 위치에 벽이 있으면 제외
 *		4-2. 가로 방향 경우의 수 구하기
 *		4-3. 세로 방향 경우의 수 구하기
 *		4-4. 대각선 방향의 경우 왼쪽 칸, 윗쪽 칸에 벽이 있는 경우 제외
 *		4-5. 대각선 방향 경우의 수 구하기
 *	5. (size, size)의 모든 방향의 경우의 수 더해서 출력
 */
public class Main {
	static int size;
	static int[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 맵 크기와 맵 정보 입력
		size = Integer.parseInt(br.readLine());
		map = new int[size+1][size+1];
		for(int row=1; row<=size; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=1; col<=size; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 2. dp[row][col][dir] 배열 선언 : (row,col) 위치의 dir 방향에서 경우의 수 저장
		dp = new long[size+1][size+1][3];
		// 3. (1,2)의 가로 방향 경우의 수 1로 초기화
		dp[1][2][0] = 1;
		
		// 4. row=1~size, col=3~size dp 배열 채워넣기
		for(int row=1; row<=size; row++) {
			for(int col=3; col<=size; col++) {
				// 4-1. 현재 위치에 벽이 있으면 제외
				if(map[row][col] == 1) continue;
				// 4-2. 가로 방향 경우의 수 구하기
				dp[row][col][0] = dp[row][col-1][0] + dp[row][col-1][2];
				// 4-3. 세로 방향 경우의 수 구하기
				dp[row][col][1] = dp[row-1][col][1] + dp[row-1][col][2];
				
				// 4-4. 대각선 방향의 경우 왼쪽 칸, 윗쪽 칸에 벽이 있는 경우 제외
				if(map[row-1][col] == 1 || map[row][col-1] == 1) continue;
				// 4-5. 대각선 방향 경우의 수 구하기
				dp[row][col][2] = dp[row-1][col-1][0] + dp[row-1][col-1][1] + dp[row-1][col-1][2];
			}
		}
		
		// 5. (size, size)의 모든 방향의 경우의 수 더해서 출력
		System.out.println(dp[size][size][0] + dp[size][size][1] + dp[size][size][2]);
	}
}