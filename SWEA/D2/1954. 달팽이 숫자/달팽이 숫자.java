import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * SWEA.1954.달팽이 숫자 
 *
 * 1. N을 입력받고 N*N 크기의 배열을 선언한다.
 * 2. (0,0)에서 시작하는 달팽이 배열이 시작한다.
 * 3. 달팽이 숫자가 될 수 있는 것은 1~N*N 까지이다. 즉, for문으로 1~N*N 돌려준다.
 * 3-1. map[row][col]에 num을 채워준다.
 * 3-2. 우->하->좌->상 순서로 델타 배열을 이용해 nextRow, nextCol을 구한다.
 * 3-3. nextRow, nextCol이 이미 채워졌거나 배열 범위를 초과하면 방향을 전환해서 nextRow, nextCol을 다시  구한다.
 * 4. row와 col에 nextRow와 nextCol을 업데이트 해준다.
 */
public class Solution {

	// 우->하->좌->상 순서 델타배열
	static int[] dRow = {0, 1, 0, -1};
	static int[] dCol = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append('\n');
			int N = Integer.parseInt(br.readLine().trim());
			
			// 1. N을 입력받고 N*N 크기의 배열을 선언한다.
			int[][] map = new int[N][N];
			int dir = 0; // 방향: 0~3 (우->하->좌->상)
			
			// 2. (0,0)에서 시작하는 달팽이 배열이 시작한다.
			int row = 0, col = 0;
			
			// 3. 달팽이 숫자가 될 수 있는 것은 1~N*N 까지이다. 즉, for문으로 1~N*N 돌려준다.
			for(int num=1; num<=N*N; num++) {
				// 3-1. map[row][col]에 num을 채워준다.
				map[row][col] = num;
				
				// 3-2. 우->하->좌->상 순서로 델타 배열을 이용해 nextRow, nextCol을 구한다.
				int nextRow = row + dRow[dir];
				int nextCol = col + dCol[dir];
				
				// 3-3. nextRow, nextCol이 이미 채워졌거나 배열 범위를 초과하면 방향을 전환해서 nextRow, nextCol을 다시  구한다.
				if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N || map[nextRow][nextCol] != 0) {
					dir = (dir + 1) % 4;
					nextRow = row + dRow[dir];
					nextCol = col + dCol[dir];
				}
				
				// 4. row와 col에 nextRow와 nextCol을 업데이트 해준다.
				row = nextRow;
				col = nextCol;
			}
			
			for(row=0; row<N; row++) {
				for(col=0; col<N; col++) {
					sb.append(map[row][col]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}

}
