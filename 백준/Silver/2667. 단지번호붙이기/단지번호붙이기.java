import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int size;
	static char[][] map;
	static boolean[][] visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static Queue<int[]> queue = new LinkedList<>();
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		size = Integer.parseInt(br.readLine());
		map = new char[size][size];
		visited = new boolean[size][size];
		for(int row=0; row<size; row++) {
			map[row] = br.readLine().toCharArray();
		}

		for(int row=0; row<size; row++) {
			for(int col=0; col<size; col++) {
				if (map[row][col] == '1' && !visited[row][col]) {
					bfs(row, col);
				}
			}
		}

		Collections.sort(result);
		sb.append(result.size()).append('\n');
		for (int i : result) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);
	}

	private static void bfs(int startRow, int startCol) {
		visited[startRow][startCol] = true;
		queue.add(new int[] {startRow, startCol});
		int count = 0;

		while(!queue.isEmpty()) {
			count++;
			int[] poll = queue.poll();

			for(int dir=0; dir<4; dir++) {
				int nRow = poll[0] + dRow[dir];
				int nCol = poll[1] + dCol[dir];

				if (nRow < 0 || nRow >= size || nCol < 0 || nCol >= size || map[nRow][nCol] == '0' || visited[nRow][nCol])
					continue;

				queue.add(new int[] {nRow, nCol});
				visited[nRow][nCol] = true;
			}
		}

		result.add(count);
	}
}