import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, iceAreaCnt;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> result;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		iceAreaCnt = Integer.parseInt(st.nextToken());
		
		map = new int[rowSize][colSize];
		result = new ArrayList<>();
		
		// 1. 맵 1로 채우기(1: 땅, 0: 얼음)
		for(int row=0; row<rowSize; row++) {
			Arrays.fill(map[row], 1);
		}
		
		// 2. 얼어붙은 영역 0으로 색칠해주기
		while(iceAreaCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int startCol = Integer.parseInt(st.nextToken());
			int startRow = Integer.parseInt(st.nextToken());
			int endCol = Integer.parseInt(st.nextToken());
			int endRow = Integer.parseInt(st.nextToken());
			
			for(int row=endRow-1; row>=startRow; row--) {
				for(int col=startCol; col<endCol; col++) {
					map[rowSize - 1 - row][col] = 0;
				}
			}
		}
		
		visited = new boolean[rowSize][colSize];
		
		// 3. 방문하지 않았으면서 땅인 영역 bfs 돌기
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if(map[row][col] == 1 && !visited[row][col]) {
					// 3-1. bfs 결과값이 영역의 크기이므로 result에 추가해주기
					result.add(bfs(row, col));
				}
			}
		}
		
		// 4. 결과값 오름차순으로 정렬하기
		Collections.sort(result);
		
		// 5. 영역의 개수와 영역의 각 넓이 출력하기
		System.out.println(result.size());
		for (int r : result) {
			System.out.print(r + " ");
		}
	}
	
	private static int bfs(int row, int col) {
		int area = 0; // 영역의 크기
		Queue<int[]> queue = new ArrayDeque<>();
		
		visited[row][col] = true;
		queue.add(new int[] {row, col});
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			area++;
			
			for(int dir=0; dir<4; dir++) {
				int nRow = poll[0] + dRow[dir];
				int nCol = poll[1] + dCol[dir];
				
				if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
				
				if(visited[nRow][nCol] || map[nRow][nCol] == 0) continue;
				
				visited[nRow][nCol] = true;
				queue.add(new int[] {nRow, nCol});
			}
		}
		
		return area;
	}

}
