import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int size, resultRoom, resultMove;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			resultMove = 0;
			resultRoom = Integer.MAX_VALUE;
			for(int row=0; row<size; row++) {
				for(int col=0; col<size; col++) {
					dfs(row, col, 1);
				}
			}
			sb.append(resultRoom).append(' ').append(resultMove).append('\n');
		}
		System.out.print(sb);
	}
	
	static void dfs(int row, int col, int depth) {

		if(depth > resultMove) {
			resultMove = depth;
			resultRoom = map[row][col] - depth + 1;
		} else if (depth == resultMove) {
			resultRoom = Math.min(resultRoom, map[row][col] - depth + 1);
		}
		
		for(int dir=0; dir<4; dir++) {
			int nRow = row + dRow[dir];
			int nCol = col + dCol[dir];
			if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;
			if(map[nRow][nCol] == map[row][col] + 1) {
				dfs(nRow, nCol, depth + 1);
			}
		}
	}
	
}
