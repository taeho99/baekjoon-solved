import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(startY, startX));
			visited[startY][startX] = true;
			
			while(!queue.isEmpty()) {
				Point poll = queue.poll();
				for(int i=0; i<8; i++) {
					int ny = poll.y + dy[i];
					int nx = poll.x + dx[i];
					if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
					
					if(!visited[ny][nx]) {
						queue.add(new Point(ny, nx));
						visited[ny][nx] = true;
						map[ny][nx] = map[poll.y][poll.x] + 1;
					}
				}
			}
			sb.append(map[endY][endX]).append('\n');
		}
		System.out.print(sb);
	}
	
	static class Point {
		int y, x;
		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
