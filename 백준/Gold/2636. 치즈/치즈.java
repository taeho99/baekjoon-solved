import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, time, lastCheeseCnt;
	static int[][] map;
	static Queue<int[]> cheeses = new ArrayDeque<>();
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		map = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == 1) cheeses.add(new int[] {row, col});
			}
		}
		
		simulation();
		System.out.println(time);
		System.out.println(lastCheeseCnt);
	}
	
	static void simulation() {
		while(!cheeses.isEmpty()) {
			// 외부 공기 2로 칠하기
			Queue<int[]> queue = new ArrayDeque<>();
			boolean[][] visited = new boolean[rowSize][colSize];
			
			queue.add(new int[] {0, 0});
			visited[0][0] = true;
			
			while(!queue.isEmpty()) {
				int[] poll = queue.poll();
				map[poll[0]][poll[1]] = 2;
				
				for(int dir=0; dir<4; dir++) {
					int nRow = poll[0] + dRow[dir];
					int nCol = poll[1] + dCol[dir];
					
					if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize 
							|| visited[nRow][nCol] || map[nRow][nCol] == 1) continue;
					
					visited[nRow][nCol] = true;
					queue.add(new int[] {nRow, nCol});
				}
			}
			
			lastCheeseCnt = cheeses.size();
			
			for(int idx=0; idx<lastCheeseCnt; idx++) {
				int[] poll = cheeses.poll();
				
				if(!isAttach(poll)) cheeses.add(poll); 
			}
			time++;
		}
	}

	static boolean isAttach(int[] poll) {
		for(int dir=0; dir<4; dir++) {
			int nRow = poll[0] + dRow[dir];
			int nCol = poll[1] + dCol[dir];
			
			if(map[nRow][nCol] == 2) {
				map[poll[0]][poll[1]] = 0;
				return true;
			}
		}
		return false;
	}

}