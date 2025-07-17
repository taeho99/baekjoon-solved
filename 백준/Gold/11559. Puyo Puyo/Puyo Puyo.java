import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int rowSize = 12, colSize = 6;
	static char[][] map = new char[rowSize][colSize];
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int row=0; row<rowSize; row++) {
			map[row] = br.readLine().toCharArray();
		}

		int cnt = 0;
		while(existPangAndPang()) {
			cnt++;

			// 내리기
			for(int col=0; col<colSize; col++) {
				Queue<Character> queue = new LinkedList<>();
				for(int row=rowSize-1; row>=0; row--) {
					if (map[row][col] == '.') continue;
					queue.add(map[row][col]);
				}

				for(int row=0; row<rowSize; row++) {
					map[row][col] = '.';
				}

				int row=rowSize-1;
				while(!queue.isEmpty()) {
					map[row--][col] = queue.poll();
				}
			}
		}

		System.out.println(cnt);
	}

	private static boolean existPangAndPang() {
		boolean flag = false;
		boolean[][] visited = new boolean[rowSize][colSize];

		for(int row=rowSize-1; row>=0; row--) {
			for(int col=0; col<colSize; col++) {
				if (visited[row][col] || map[row][col] == '.') continue;

				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] {row, col});
				visited[row][col] = true;

				ArrayList<int[]> list = new ArrayList<>();
				while(!queue.isEmpty()) {
					int[] poll = queue.poll();
					list.add(new int[] {poll[0], poll[1]});

					for(int dir=0; dir<4; dir++) {
						int nRow = poll[0] + dRow[dir];
						int nCol = poll[1] + dCol[dir];

						if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
						if(map[poll[0]][poll[1]] != map[nRow][nCol] || visited[nRow][nCol]) continue;

						queue.add(new int[] {nRow, nCol});
						visited[nRow][nCol] = true;
					}
				}

				if (list.size() >= 4) {
					for (int[] pos : list) {
						map[pos[0]][pos[1]] = '.';
					}
					flag = true;
				}
			}
		}

		return flag;
	}
}
