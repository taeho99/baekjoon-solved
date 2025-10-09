import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static char[][] map = new char[5][5];
	static int[][] elementList = new int[25][2];
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int row=0; row<5; row++) {
			map[row] = br.readLine().toCharArray();
			for(int col=0; col<5; col++) {
				elementList[row*5 + col][0] = row;
				elementList[row*5 + col][1] = col;
			}
		}
		combination(0, 0, 0, 0);
		System.out.println(result);
	}

	private static void combination(int depth, int at, int sCnt, int yCnt) {
		if(sCnt + (7 - depth) < 4) {
			return;
		}

		if(depth == 7) {
			for(int row=0; row<5; row++) {
				for(int col=0; col<5; col++) {
					if (Character.isLowerCase(map[row][col])) {
						int cnt = 0;
						Queue<int[]> queue = new LinkedList<>();
						boolean[][] visited = new boolean[5][5];

						queue.add(new int[] {row, col});
						visited[row][col] = true;

						while(!queue.isEmpty()) {
							int[] poll = queue.poll();

							cnt++;

							for(int dir=0; dir<4; dir++) {
								int nRow = poll[0] + dRow[dir];
								int nCol = poll[1] + dCol[dir];

								if(nRow < 0 || nRow >= 5 || nCol < 0 || nCol >= 5)
									continue;
								if(visited[nRow][nCol]) continue;
								if(Character.isUpperCase(map[nRow][nCol])) continue;

								visited[nRow][nCol] = true;
								queue.add(new int[] {nRow, nCol});
							}
						}
						if(cnt == 7) {
							result++;
						}
						return;
					}
				}
			}
			return;
		}

		for(int idx=at; idx<25; idx++) {
			if (Character.isLowerCase(map[elementList[idx][0]][elementList[idx][1]])) {
				continue;
			}

			map[elementList[idx][0]][elementList[idx][1]] += 32;
			if(map[elementList[idx][0]][elementList[idx][1]] == 's') {
				combination(depth + 1, idx + 1, sCnt+1, yCnt);
			} else {
				combination(depth + 1, idx + 1, sCnt, yCnt+1);
			}
			map[elementList[idx][0]][elementList[idx][1]] -= 32;
		}
	}
}
