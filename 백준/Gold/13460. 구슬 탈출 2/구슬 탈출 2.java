import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][][][] visited;
	static int redRow, redCol, blueRow, blueCol;
	static int[] dRow = {-1, 0, 1, 0};
	static int[] dCol = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());
		map = new char[rowSize][colSize];
		visited = new boolean[rowSize][colSize][rowSize][colSize];

		for(int row=0; row<rowSize; row++) {
			String inputLine = br.readLine();
			for(int col=0; col<colSize; col++) {
				map[row][col] = inputLine.charAt(col);
				if(map[row][col] == 'R') {
					redRow = row; redCol = col;
				} else if(map[row][col] == 'B') {
					blueRow = row; blueCol = col;
				}
			}
		}
		System.out.print(bfs());
	}

	static int bfs() {
		Queue<Bead> queue = new LinkedList<>();
		queue.add(new Bead(redRow, redCol, blueRow, blueCol, 1));
		visited[redRow][redCol][blueRow][blueCol] = true;

		while(!queue.isEmpty()) {
			Bead poll = queue.poll();

			if (poll.cnt > 10) {
				return -1;
			}

			for(int dir=0; dir<4; dir++) {
				int nextRedRow = poll.redRow;
				int nextRedCol = poll.redCol;
				int nextBlueRow = poll.blueRow;
				int nextBlueCol = poll.blueCol;

				// 빨간 구슬 이동
				while(map[nextRedRow + dRow[dir]][nextRedCol + dCol[dir]] != '#') {
					nextRedRow += dRow[dir];
					nextRedCol += dCol[dir];
					if(map[nextRedRow][nextRedCol] == 'O') break;
				}

				// 파란 구슬 이동
				while(map[nextBlueRow + dRow[dir]][nextBlueCol + dCol[dir]] != '#') {
					nextBlueRow += dRow[dir];
					nextBlueCol += dCol[dir];
					if(map[nextBlueRow][nextBlueCol] == 'O') break;
				}

				if(map[nextBlueRow][nextBlueCol] == 'O') continue;
				if(map[nextRedRow][nextRedCol] == 'O') return poll.cnt;

				if(nextRedRow == nextBlueRow && nextRedCol == nextBlueCol) {
					int redMoveDist = Math.abs(nextRedRow - poll.redRow) + Math.abs(nextRedCol - poll.redCol);
					int blueMoveDist = Math.abs(nextBlueRow - poll.blueRow) + Math.abs(nextBlueCol - poll.blueCol);
					if(redMoveDist > blueMoveDist) {
						nextRedRow -= dRow[dir];
						nextRedCol -= dCol[dir];
					} else {
						nextBlueRow -= dRow[dir];
						nextBlueCol -= dCol[dir];
					}
				}

				if(visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol]) continue;
				visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol] = true;
				queue.add(new Bead(nextRedRow, nextRedCol, nextBlueRow, nextBlueCol, poll.cnt + 1));
			}
		}
		return -1;
	}

	static class Bead {
		int redRow, redCol, blueRow, blueCol, cnt;

		public Bead(int redRow, int redCol, int blueRow, int blueCol, int cnt) {
			this.redRow = redRow;
			this.redCol = redCol;
			this.blueRow = blueRow;
			this.blueCol = blueCol;
			this.cnt = cnt;
		}
	}
}
