import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize;
	static char[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static Queue<int[]> waterQueue = new LinkedList<>();
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		map = new char[rowSize][colSize];

		for(int row=0; row<rowSize; row++) {
			map[row] = br.readLine().toCharArray();
			for(int col=0; col<colSize; col++) {
				if(map[row][col] == 'S') {
					queue.add(new int[] {row, col, 0});
				} else if (map[row][col] == '*') {
					waterQueue.add(new int[] {row, col});
				}
			}
		}

		System.out.println(bfs());
	}

	private static String bfs() {

		while(!queue.isEmpty()) {
			int waterSize = waterQueue.size();
			while(waterSize-- > 0) {
				int[] poll = waterQueue.poll();

				for(int dir=0; dir<4; dir++) {
					int nRow = poll[0] + dRow[dir];
					int nCol = poll[1] + dCol[dir];

					if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
					if(map[nRow][nCol] != '.') continue;

					map[nRow][nCol] = '*';
					waterQueue.add(new int[] {nRow, nCol});
				}
			}

			int queueSize = queue.size();
			while(queueSize-- > 0) {
				int[] poll = queue.poll();

				for(int dir=0; dir<4; dir++) {
					int nRow = poll[0] + dRow[dir];
					int nCol = poll[1] + dCol[dir];

					if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;

					if(map[nRow][nCol] == 'D') {
						return String.valueOf(poll[2] + 1);
					}

					if(map[nRow][nCol] != '.') continue;

					map[nRow][nCol] = 'S';
					queue.add(new int[] {nRow, nCol, poll[2] + 1});
				}
			}
		}

		return "KAKTUS";
	}
}
