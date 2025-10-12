import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, edgeSize, result = Integer.MAX_VALUE;
	static boolean[][][][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		colSize = Integer.parseInt(st.nextToken());
		edgeSize = Integer.parseInt(st.nextToken());
		rowSize = Integer.parseInt(st.nextToken());

		graph = new boolean[rowSize+1][colSize+1][rowSize+1][colSize+1];
		while(edgeSize-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			graph[row][col][row][col+1] = graph[row][col+1][row][col] = true;
		}

		for(int row=1; row<=rowSize-1; row++) {
			for(int col=1; col<colSize; col++) {
				graph[row][col][row+1][col] = true;
			}
		}

		dfs(0, 1, 1);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	static boolean canPlace(int r, int c) {
		if (graph[r][c][r][c + 1]) return false;                // 자기 자리 점유
		if (c > 1 && graph[r][c - 1][r][c]) return false;       // 왼쪽 인접
		if (c + 1 < colSize && graph[r][c + 1][r][c + 2]) return false; // 오른쪽 인접
		return true;
	}

	private static void dfs(int depth, int sr, int sc) {
		if(depth == 4) return;

		if(isOk()) {
			result = Math.min(depth, result);
			return;
		}

		for(int row=sr; row<=rowSize; row++) {
			int colStart = (row == sr ? sc : 1);
			for(int col=colStart; col<=colSize-1; col++) {
				if (!canPlace(row, col)) continue;
				graph[row][col][row][col+1] = graph[row][col+1][row][col] = true;
				dfs(depth+1, row, col+1);
				graph[row][col][row][col+1] = graph[row][col+1][row][col] = false;
			}
		}
	}

	static boolean isOk() {
		for (int start = 1; start <= colSize; start++) {
			int c = start;
			for (int r = 1; r <= rowSize; r++) {
				if (c < colSize && graph[r][c][r][c + 1]) c++;
				else if (c > 1 && graph[r][c - 1][r][c]) c--;
			}
			if (c != start) return false;
		}
		return true;
	}
}
