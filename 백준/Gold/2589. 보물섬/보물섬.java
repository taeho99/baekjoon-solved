import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static char[][] map;
	static int rowSize, colSize, maxResult = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new char[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			map[row] = br.readLine().toCharArray();
		}

		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if(map[row][col] == 'L') {
					maxResult = Math.max(maxResult, bfs(row, col));
				}
			}
		}
		System.out.println(maxResult);
	}

	private static int bfs(int startRow, int startCol) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rowSize][colSize];

		queue.add(new int[] {startRow, startCol, 0});
		visited[startRow][startCol] = true;

		int[] poll = {0, 0, 0};
		while(!queue.isEmpty()) {
			poll = queue.poll();

			for(int dir=0; dir<4; dir++) {
				int nRow = poll[0] + dRow[dir];
				int nCol = poll[1] + dCol[dir];

				if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize)
					continue;
				if(map[nRow][nCol] == 'W' || visited[nRow][nCol])
					continue;

				queue.add(new int[] {nRow, nCol, poll[2] + 1});
				visited[nRow][nCol] = true;
			}
		}
		return poll[2];
	}
}
