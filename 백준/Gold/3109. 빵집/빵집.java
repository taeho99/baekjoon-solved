import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  BOJ.3109 빵집 
 *
 *  1. 맵의 크기와 맵의 데이터(피해야 하는 건물 위치)를 입력받는다.
 *  2. 최적의 해는 윗쪽 가스관부터 연결해 나가는 것이다. row=0부터 (rowSize-1)까지 모두 연결을 시도한다.
 *  	2-1. row에서 시작한 파이프가 끝까지 연결되었으면 true를 반환하고 result값을 1 증가시킨다.
 *  3. [기저조건] 파이프까지 내 빵집까지 연결되었으면 true를 반환하고 종료한다.
 *  4. 3방향으로 다음 파이프 위치를 정한다. 다음 파이프의 위치는 위에서부터 위치를 정하되, 범위를 벗어나거나 이미 방문했거나 건물이 있는 경우 제외
 *  	4-1. 다음 파이프 위치 방문 처리
 *  5. 내 빵집까지 끝까지 간 경우 true를 main() 까지 연달아서 반환한다. 만약 3방향을 모두 탐색했는데 끝까지 못간 경우 false를 반환한다.
 *  6. 한 파이프라인이 끝까지 연결되면 result를 1 증가시킨다. 즉, 파이프라인의 최대 개수는 result가 된다. result를 출력한다.
 */
public class Main {
	static int rowSize, colSize, result = 0;
	static char[][] map;
	static boolean[][] visited;
	static int[] dRow = {-1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 맵의 크기와 맵의 데이터(피해야 하는 건물 위치)를 입력받는다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		map = new char[rowSize][colSize];
		visited = new boolean[rowSize][colSize];
		
		for(int row=0; row<rowSize; row++) {
			String tmp = br.readLine();
			for(int col=0; col<colSize; col++) {
				map[row][col] = tmp.charAt(col);
			}
		}
		
		// 2. 최적의 해는 윗쪽 가스관부터 연결해 나가는 것이다. row=0부터 (rowSize-1)까지 모두 연결을 시도한다.
		for(int row=0; row<rowSize; row++) {
			visited[row][0] = true;
			// 2-1. row에서 시작한 파이프가 끝까지 연결되었으면 true를 반환하고 result값을 1 증가시킨다.
			if(backtrack(row, 0)) result++;
		}
		
		// 6. 한 파이프라인이 끝까지 연결되면 result를 1 증가시킨다. 즉, 파이프라인의 최대 개수는 result가 된다. result를 출력한다.
		System.out.println(result);
	}
	private static boolean backtrack(int row, int col) {
		// 3. [기저조건] 파이프까지 내 빵집까지 연결되었으면 true를 반환하고 종료한다.
		if(col == colSize - 1) return true;
		
		// 4. 3방향으로 다음 파이프 위치를 정한다. 다음 파이프의 위치는 위에서부터 위치를 정하되, 범위를 벗어나거나 이미 방문했거나 건물이 있는 경우 제외
		for(int dir=0; dir<3; dir++) {
			int nRow = row + dRow[dir];
			int nCol = col + 1;
			
			if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
			if(!visited[nRow][nCol] && map[nRow][nCol] == '.') {
				// 4-1. 다음 파이프 위치 방문 처리
				visited[nRow][nCol] = true;
				
				// 5. 내 빵집까지 끝까지 간 경우 true를 main() 까지 연달아서 반환한다. 만약 3방향을 모두 탐색했는데 끝까지 못간 경우 false를 반환한다.
				if(backtrack(nRow, nCol)) return true;
			}
		}
		return false;
	}
}
