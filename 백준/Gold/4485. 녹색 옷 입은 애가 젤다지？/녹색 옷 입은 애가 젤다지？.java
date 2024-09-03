import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
			
			map = new int[size][size];
			
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(getMinDistance()).append('\n');
		}
		System.out.print(sb);
	}
	
	static int getMinDistance() {
		boolean[][] visited = new boolean[size][size];
		int[][] minDistance = new int[size][size];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		
		for(int row=0; row<size; row++) {
			Arrays.fill(minDistance[row], INF);
		}
		
		minDistance[0][0] = map[0][0];
		pq.offer(new int[] {0, 0, minDistance[0][0]});
		
		while(!pq.isEmpty()) {
			// step1
			int[] stopOver = pq.poll();
			int row = stopOver[0];
			int col = stopOver[1];
			int time = stopOver[2];
			
			if(visited[row][col]) continue;
			visited[row][col] = true;
			if(row == size-1 && col == size-1) 
				return minDistance[row][col]; //return minDistance[endRow][endCol];
			
			for(int dir=0; dir<4; dir++) {
				int nRow = row + dRow[dir];
				int nCol = col + dCol[dir];
				if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;
				
				if(!visited[nRow][nCol] && minDistance[nRow][nCol] > time + map[nRow][nCol]) {
					minDistance[nRow][nCol] = time + map[nRow][nCol];
					pq.offer(new int[] {nRow, nCol, minDistance[nRow][nCol]});
				}
			}
		}
		return -1;
	}
}