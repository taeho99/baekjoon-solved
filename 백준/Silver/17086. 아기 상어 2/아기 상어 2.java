import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize;
	static int[][] map;
	static int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
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
			}
		}

		int result = 0;
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if (map[row][col] == 1) continue;
				result = Math.max(bfs(row, col), result);
			}
		}

		System.out.println(result);
	}

	private static int bfs(int startRow, int startCol) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rowSize][colSize];

		queue.add(new int[] {startRow, startCol, 0});
		visited[startRow][startCol] = true;

		while(!queue.isEmpty()) {
			int[] poll = queue.poll();

			for (int dir=0; dir<8; dir++) {
				int nRow = poll[0] + dRow[dir];
				int nCol = poll[1] + dCol[dir];

				if (nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
				if (visited[nRow][nCol]) continue;

				if (map[nRow][nCol] == 1) {
					return poll[2] + 1;
				}

				queue.add(new int[] {nRow, nCol, poll[2] + 1});
				visited[nRow][nCol] = true;
			}
		}
		return 0;
	}
}