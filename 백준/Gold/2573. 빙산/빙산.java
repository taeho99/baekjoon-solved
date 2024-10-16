import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 	BOJ.2573 빙산
 * 
 * 	1. BFS 2번
 * 	2. 1번째 BFS : 빙산 개수 파악하기
 * 	3. 2번째 BFS : 빙산 녹이기
 */
public class Main {
	static int rowSize, colSize, result;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int[][] map;
	static List<int[]> iceList = new ArrayList<>();
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
				if(map[row][col] != 0) {
					iceList.add(new int[] {row, col});
				}
			}
		}
		while(true) {
			
			int iceCnt = getIceCnt();
			
			if(iceList.size() == 0) {
				System.out.println("0");
				break;
			}
			
			if(iceCnt >= 2) {
				System.out.println(result);
				break;
			}
			
			meltIce();
			result++;
			
		}
	}
	
	private static void meltIce() {
		List<int[]> removeIceIdxList = new ArrayList<>();
		for(int idx=0; idx<iceList.size(); idx++) {
			int[] ice = iceList.get(idx);
			int airCnt = 0;
			
			for(int dir=0; dir<4; dir++) {
				int nRow = ice[0] + dRow[dir];
				int nCol = ice[1] + dCol[dir];
				
				if(map[nRow][nCol] == 0) airCnt++;
			}
			
			removeIceIdxList.add(new int[] {idx, airCnt});
		}
		
		for(int idx=removeIceIdxList.size()-1; idx>=0; idx--) {
			int[] removeIce = removeIceIdxList.get(idx);
			int[] ice = iceList.get(removeIce[0]);
			int airCnt = removeIce[1];
			
			map[ice[0]][ice[1]] -= airCnt;
			if(map[ice[0]][ice[1]] <= 0) {
				iceList.remove(removeIce[0]);
				map[ice[0]][ice[1]] = 0;
			}
		}
	}

	private static int getIceCnt() {
		int iceCnt = 0;
		boolean[][] visited = new boolean[rowSize][colSize];

		for(int idx=0; idx<iceList.size(); idx++) {
			int[] ice = iceList.get(idx);
			if(visited[ice[0]][ice[1]]) continue;
			
			Queue<int[]> queue = new ArrayDeque<>();
			queue.add(new int[] {ice[0], ice[1]});
			visited[ice[0]][ice[1]] = true;
			
			while(!queue.isEmpty()) {
				int[] poll = queue.poll();
				
				for(int dir=0; dir<4; dir++) {
					int nRow = poll[0] + dRow[dir];
					int nCol = poll[1] + dCol[dir];
					
					if(visited[nRow][nCol] || map[nRow][nCol] == 0) continue;
					
					queue.add(new int[] {nRow, nCol});
					visited[nRow][nCol] = true;
				}
			}
			
			iceCnt++;
		}
		return iceCnt;
	}
}