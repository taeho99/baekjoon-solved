import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());
		int trashSize = Integer.parseInt(st.nextToken());

		int[][] map = new int[rowSize][colSize];
		while(trashSize-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			map[row][col] = 1;
		}

		int maxTrash = 0;
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if (map[row][col] != 1) continue;
				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] {row, col});
				map[row][col] = 2;

				int cnt = 0;
				while(!queue.isEmpty()) {
					int[] poll = queue.poll();
					cnt++;

					for(int dir=0; dir<4; dir++) {
						int nRow = poll[0] + dRow[dir];
						int nCol = poll[1] + dCol[dir];

						if (nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
						if (map[nRow][nCol] != 1) continue;

						queue.add(new int[] {nRow, nCol});
						map[nRow][nCol] = 2;
					}
				}

				maxTrash = Math.max(maxTrash, cnt);
			}
		}

		System.out.println(maxTrash);
	}
}