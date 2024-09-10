import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited = new boolean[26];
	static int rowSize, colSize, result;
	static char[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		map = new char[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			map[row] = br.readLine().toCharArray();
		}
		
		visited[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(result);
	}

	private static void dfs(int row, int col, int depth) {
		result = Math.max(result, depth);
		
		for(int dir=0; dir<4; dir++) {
			int nRow = row + dRow[dir];
			int nCol = col + dCol[dir];

			if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
			
			if(visited[map[nRow][nCol]-'A']) continue;
			visited[map[nRow][nCol]-'A'] = true;
			dfs(nRow, nCol, depth+1);
			visited[map[nRow][nCol]-'A'] = false;
		}
		
	}
}