import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *	BOJ.4485 녹색옷입은애가젤다지
 *
 *	1. 맵의 크기와 맵의 정보(도둑 루피의 크기)를 입력 받는다.
 *	2. 도착점까지 최소 경로를 출력한다.
 *	3. 다익스트라 알고리즘으로 최단 경로를 찾는다.
 *		3-1. 방문체크 배열, 최단경로 배열, 우선순위 큐를 초기화
 *		3-2. 최단경로 배열을 무한대 값으로 초기화한다.
 *		3-3. (0, 0) 정점에서 시작한다. ((0,0)에도 도둑 루피가 있을 수 있음)
 *			3-3-1. 현재 정점을 방문한 경우 제외
 *			3-3-2. 도착 정점에 도달한 경우, 도착 정점까지 최단 경로를 반환
 *			3-3-3. 현재 정점에서 4방향 모두 확인
 *				3-3-3-1. 인접 정점이 배열 범위를 벗어난 경우 제외
 *				3-3-3-2. (기존 최단경로 > 시작정점->현재정점->다음정점 경로)인 경우 기존 최단 경로를 갱신하고 큐에 삽입
 *		3-4. 도착 정점까지 가지 못하면 -1 반환
 */
public class Main {
	static int tc = 1;
	static int size;
	static final int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while((size = Integer.parseInt(br.readLine())) != 0) {
			sb.append("Problem ").append(tc++).append(": ");
			
			// 1. 맵의 크기와 맵의 정보(도둑 루피의 크기)를 입력 받는다.
			map = new int[size][size];
			
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 2. 도착점까지 최소 경로를 출력한다.
			sb.append(getMinDistance()).append('\n');
		}
		System.out.print(sb);
	}
	
	// 3. 다익스트라 알고리즘으로 최단 경로를 찾는다.
	static int getMinDistance() {
		// 3-1. 방문체크 배열, 최단경로 배열, 우선순위 큐를 초기화
		boolean[][] visited = new boolean[size][size];
		int[][] minDistance = new int[size][size]; // 출발 정점에서 해당 정점까지 최소 경로
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		
		// 3-2. 최단경로 배열을 무한대 값으로 초기화한다.
		for(int row=0; row<size; row++) {
			Arrays.fill(minDistance[row], INF);
		}
		
		// 3-3. (0, 0) 정점에서 시작한다. ((0,0)에도 도둑 루피가 있을 수 있음)
		minDistance[0][0] = map[0][0];
		pq.offer(new int[] {0, 0, minDistance[0][0]});
		
		while(!pq.isEmpty()) {
			// step1
			int[] stopOver = pq.poll();
			int row = stopOver[0];
			int col = stopOver[1];
			int time = stopOver[2];
			
			// 3-3-1. 현재 정점을 방문한 경우 제외
			if(visited[row][col]) continue;
			
			visited[row][col] = true; // 현재 정점 방문 체크
			
			// 3-3-2. 도착 정점에 도달한 경우, 도착 정점까지 최단 경로를 반환
			if(row == size-1 && col == size-1) 
				return minDistance[row][col]; //return minDistance[endRow][endCol];
			
			// 3-3-3. 현재 정점에서 4방향 모두 확인
			for(int dir=0; dir<4; dir++) {
				int nRow = row + dRow[dir];
				int nCol = col + dCol[dir];
				// 3-3-3-1. 인접 정점이 배열 범위를 벗어난 경우 제외
				if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;
				
				// 3-3-3-2. (기존 최단경로 > 시작정점->현재정점->다음정점 경로)인 경우 기존 최단 경로를 갱신하고 큐에 삽입
				if(!visited[nRow][nCol] && minDistance[nRow][nCol] > time + map[nRow][nCol]) {
					minDistance[nRow][nCol] = time + map[nRow][nCol];
					pq.offer(new int[] {nRow, nCol, minDistance[nRow][nCol]});
				}
			}
		}
		// 3-4. 도착 정점까지 가지 못하면 -1 반환
		return -1;
	}
}