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
		int colSize = Integer.parseInt(st.nextToken());
		int rowSize = Integer.parseInt(st.nextToken());

		char[][] map = new char[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			map[row] = br.readLine().toCharArray();
		}

		char now;
		int wResult = 0, bResult = 0;
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if (map[row][col] != 'W' && map[row][col] != 'B') continue;
				now = map[row][col];

				Queue<int[]> queue = new LinkedList<>();
				map[row][col] = 'X';
				queue.add(new int[] {row, col});
				int cnt = 0;

				while(!queue.isEmpty()) {
					int[] poll = queue.poll();
					cnt++;

					for(int dir=0; dir<4; dir++) {
						int nRow = poll[0] + dRow[dir];
						int nCol = poll[1] + dCol[dir];

						if (nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize)
							continue;
						if (map[nRow][nCol] != now)
							continue;

						queue.add(new int[] {nRow, nCol});
						map[nRow][nCol] = 'X';
					}
				}

				if (now == 'W') {
					wResult += cnt * cnt;
				} else {
					bResult += cnt * cnt;
				}
			}
		}
		System.out.println(wResult + " " + bResult);
	}
}