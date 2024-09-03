import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	SWEA.1953 탈주범검거 
 *
 *	0. 터널 종류에 따라 이동할 방향을 미리 static 멤버로 초기화한다. (상,하,좌,우)
 *	1. 맵의 크기와 맨홀 위치, 경과 시간, 맵의 정보를 입력받는다.
 *	2. 맨홀 위치에서 이동 가능한 터널 위치로 BFS 탐색하기. 반환 값이 정답이므로 출력하기!
 *	3. 맨홀 위치에서 탐색 시작을 위해 방문체크 하고 큐에 넣어준다.
 *		3-1. 현재 시간이 총 경과 시간을 초과한 경우 종료
 *		3-2. 탈주범이 위치할 수 있는 장소 개수 증가
 *		3-3. 4방향으로 탈주범이 이동할 수 있는지 확인
 *			3-3-1. 해당 방향으로 이동 불가하면 제외
 *			3-3-2. 맵의 범위를 벗어나면 제외
 *			3-3-3. 이미 방문했거나 터널이 없는 칸이면 제외
 *			3-3-4. 직전 터널이랑 다음 터널이랑 물리적으로 연결될 수 없으면 제외
 *			3-3-5. 이동 가능한 터널을 큐에 넣고 방문체크 해주기!!
 *		3-4. 탈주범이 위치할 수 있는 장소 개수를 반환하기!
 */
public class Solution {
	static int rowSize, colSize, startRow, startCol, totalTime;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	// 0. 터널 종류에 따라 이동할 방향을 미리 static 멤버로 초기화한다. (상,하,좌,우)
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
			
			// 1. 맵의 크기와 맨홀 위치, 경과 시간, 맵의 정보를 입력받는다.
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
			
			// 2. 맨홀 위치에서 이동 가능한 터널 위치로 BFS 탐색하기. 반환 값이 정답이므로 출력하기!
			sb.append(bfs()).append('\n');
		}
		System.out.print(sb);
	}

	static int bfs() {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[rowSize][colSize];
		
		// 3. 맨홀 위치에서 탐색 시작을 위해 방문체크 하고 큐에 넣어준다.
		queue.add(new int[] {startRow, startCol, 1});
		visited[startRow][startCol] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			int row = poll[0];
			int col = poll[1];
			int time = poll[2];
			boolean[] prevTunnel = tunnelType[map[row][col]];
			
			// 3-1. 현재 시간이 총 경과 시간을 초과한 경우 종료
			if(time > totalTime) {
				return cnt;
			}
			
			// 3-2. 탈주범이 위치할 수 있는 장소 개수 증가
			cnt++;
			// 3-3. 4방향으로 탈주범이 이동할 수 있는지 확인
			for(int dir=0; dir<4; dir++) {
				// 3-3-1. 해당 방향으로 이동 불가하면 제외
				if(!prevTunnel[dir]) continue;
				
				int nRow = row + dRow[dir];
				int nCol = col + dCol[dir];
				
				// 3-3-2. 맵의 범위를 벗어나면 제외
				if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
				// 3-3-3. 이미 방문했거나 터널이 없는 칸이면 제외
				if(visited[nRow][nCol] || map[nRow][nCol] == 0) continue;
				
				boolean[] nextTunnel = tunnelType[map[nRow][nCol]];
				// 3-3-4. 직전 터널이랑 다음 터널이랑 물리적으로 연결될 수 없으면 제외
				if((dir == 0 && !nextTunnel[1]) || (dir == 1 && !nextTunnel[0]) || 
					(dir == 2 && !nextTunnel[3]) || (dir == 3 && !nextTunnel[2]) 
				) continue;
				
				// 3-3-5. 이동 가능한 터널을 큐에 넣고 방문체크 해주기!!
				queue.add(new int[] {nRow, nCol, time+1});
				visited[nRow][nCol] = true;
			}
		}
		// 3-4. 탈주범이 위치할 수 있는 장소 개수를 반환하기!
		return cnt;
	}
}