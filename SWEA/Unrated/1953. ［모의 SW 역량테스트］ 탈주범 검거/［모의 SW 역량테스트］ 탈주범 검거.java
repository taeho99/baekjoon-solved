import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	SWEA.1953 탈주범검거 
 *
 *	1. 맵의 크기와 맨홀 위치, 경과 시간, 맵의 정보를 입력받는다.
 *	2. 이동할 방향을 터널 종류에 따라 7개로 미리 구해논다. 상,하,좌,우 boolean 배열
 *	3. 현재 터널 종류에 따라 해당 위치로만 bfs 탐색한다.
 */
public class Solution {
	static int rowSize, colSize, startRow, startCol, totalTime;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static boolean[][] tunnelType = {
			{false, false, false, false},
			{true, true, true, true},
			{true, true, false, false},
			{false, false, true, true},
			{true, false, false, true},
			{false, true, false, true},
			{false, true, true, false},
			{true, false, true, false},
	};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			rowSize = Integer.parseInt(st.nextToken());
			colSize = Integer.parseInt(st.nextToken());
			startRow = Integer.parseInt(st.nextToken());
			startCol = Integer.parseInt(st.nextToken());
			totalTime = Integer.parseInt(st.nextToken());
			
			map = new int[rowSize][colSize];
			for(int row=0; row<rowSize; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<colSize; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(bfs()).append('\n');
		}
		System.out.print(sb);
	}

	static int bfs() {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[rowSize][colSize];
		
		queue.add(new int[] {startRow, startCol, 1});
		visited[startRow][startCol] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			int row = poll[0];
			int col = poll[1];
			int time = poll[2];
			boolean[] prevTunnel = tunnelType[map[row][col]];
			
			if(time == totalTime + 1) {
				return cnt;
			}
			
			cnt++;
			for(int dir=0; dir<4; dir++) {
				if(!prevTunnel[dir]) continue;
				
				int nRow = row + dRow[dir];
				int nCol = col + dCol[dir];
				
				if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
				if(visited[nRow][nCol] || map[nRow][nCol] == 0) continue;
				
				boolean[] nextTunnel = tunnelType[map[nRow][nCol]];
				if((dir == 0 && !nextTunnel[1]) || (dir == 1 && !nextTunnel[0]) || 
					(dir == 2 && !nextTunnel[3]) || (dir == 3 && !nextTunnel[2]) 
				) continue;
				
				queue.add(new int[] {nRow, nCol, time+1});
				visited[nRow][nCol] = true;
			}
		}
		return cnt;
	}
}