import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, edgeSize, answer = 4;
	static boolean[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		colSize = Integer.parseInt(st.nextToken());
		edgeSize = Integer.parseInt(st.nextToken());
		rowSize = Integer.parseInt(st.nextToken());

		graph = new boolean[rowSize+1][colSize+1];
		while(edgeSize-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			graph[row][col] = true; // row 행에 (col)-(col+1) 연결
		}

		for(int limit=0; limit<=3; limit++) {
			if (dfs(0, 1, 1, limit)) {
				answer = limit;
				break;
			}
		}
		System.out.println(answer == 4 ? -1 : answer);
	}

	private static boolean dfs(int depth, int sr, int sc, int limit) {
		if(depth == limit) {
			return isOk();
		}

		for(int row = sr; row<=rowSize; row++) {
			int colStart = (row == sr ? sc : 1);
			for(int col = colStart; col<=colSize-1; col++) {
				if(!canPlace(row, col)) continue;

				graph[row][col] = true;
				if(dfs(depth+1, row, col+1, limit)) return true;
				graph[row][col] = false;
			}
		}
		return false;
	}

	private static boolean canPlace(int row, int col) {
		if(graph[row][col]) return false;
		if(col >= 2 && graph[row][col-1]) return false;
		if(col+2 <= colSize && graph[row][col+1]) return false;
		return true;
	}

	static boolean isOk() {
		for (int startCol = 1; startCol <= colSize; startCol++) {
			int col = startCol;
			for(int row=1; row<=rowSize; row++) {
				if(col+1 <= colSize && graph[row][col]) col++;
				else if(col >= 2 && graph[row][col-1]) col--;
			}
			if(startCol != col) return false;
		}
		return true;
	}
}
