import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 	BOJ.6593 상범빌딩
 */
public class Main {
	static int heiSize, rowSize, colSize;
	static int[] dHei = {-1, 1, 0, 0, 0, 0};
	static int[] dRow = {0, 0, -1, 1, 0, 0};
	static int[] dCol = {0, 0, 0, 0, -1, 1};
	static char[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input;
		while(!(input = br.readLine()).equals("0 0 0")) {
			st = new StringTokenizer(input);
			
			heiSize = Integer.parseInt(st.nextToken());
			rowSize = Integer.parseInt(st.nextToken());
			colSize = Integer.parseInt(st.nextToken());

			int startHei = 0, startRow = 0, startCol = 0;
			map = new char[heiSize][rowSize][colSize];
			for(int hei=0; hei<heiSize; hei++) {
				for(int row=0; row<rowSize; row++) {
					String tmp = br.readLine();
					for(int col=0; col<colSize; col++) {
						map[hei][row][col] = tmp.charAt(col);
						if(map[hei][row][col] == 'S') {
							startHei = hei;
							startRow = row;
							startCol = col;
						}
					}
				}
				br.readLine();
			}
			
			int result = bfs(startHei, startRow, startCol);
			sb.append(result == -1 ? "Trapped!" :  "Escaped in " + result + " minute(s).").append('\n');
		}
		System.out.print(sb);
	}
	
	private static int bfs(int startHei, int startRow, int startCol) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[heiSize][rowSize][colSize];
		
		queue.add(new int[] {startHei, startRow, startCol, 0});
		visited[startHei][startRow][startCol] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			if(map[poll[0]][poll[1]][poll[2]] == 'E') {
				return poll[3];
			}
			
			for(int dir=0; dir<6; dir++) {
				int nHei = poll[0] + dHei[dir];
				int nRow = poll[1] + dRow[dir];
				int nCol = poll[2] + dCol[dir];
				
				if(nHei < 0 || nHei >= heiSize || nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
				if(visited[nHei][nRow][nCol] || map[nHei][nRow][nCol] == '#') continue;
				
				queue.add(new int[] {nHei, nRow, nCol, poll[3]+1});
				visited[nHei][nRow][nCol] = true;
			}
		}
		
		return -1;
	}
}