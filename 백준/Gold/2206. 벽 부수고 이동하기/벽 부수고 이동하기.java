import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int rowSize, colSize, minResult = Integer.MAX_VALUE;
	static boolean[][] map;
	static List<int[]> wallList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new boolean[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			char[] input = br.readLine().toCharArray();
			for(int col=0; col<colSize; col++) {
				map[row][col] = input[col] == '1';
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[2][rowSize][colSize];

		queue.add(new int[] {0, 0, 1, 0});
		visited[0][0][0] = true;

		while(!queue.isEmpty()) {
			int[] poll = queue.poll();

			if(poll[0] == rowSize - 1 && poll[1] == colSize - 1) {
				return poll[2];
			}

			for(int dir=0; dir<4; dir++) {
				int nRow = poll[0] + dRow[dir];
				int nCol = poll[1] + dCol[dir];

				if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize)
					continue;

				if (!map[nRow][nCol] && !visited[poll[3]][nRow][nCol]) {
					queue.add(new int[] {nRow, nCol, poll[2] + 1, poll[3]});
					visited[poll[3]][nRow][nCol] = true;
				} else if (map[nRow][nCol] && poll[3] == 0 && !visited[1][nRow][nCol]) {
					queue.add(new int[] {nRow, nCol, poll[2] + 1, 1});
					visited[1][nRow][nCol] = true;
				}
			}
		}
		return -1;
	}
}
