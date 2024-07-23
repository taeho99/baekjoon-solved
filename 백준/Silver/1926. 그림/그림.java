import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int count = 0, maxArea = 0, n, m;
	static boolean[][] visited;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue;
				count++;
				bfs(new int[] {i, j});
			}
		}
		
		System.out.println(count);
		System.out.println(maxArea);
	}

	static void bfs(int[] start) {
		Queue<int[]> queue = new LinkedList<>();
		visited[start[0]][start[1]] = true;
		queue.add(new int[] {start[0], start[1]});
		int area = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			area++;
			
			for(int i=0; i<4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];
				
				if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
				
				if(!visited[ny][nx] && map[ny][nx] == 1) {
					visited[ny][nx] = true;
					queue.add(new int[] {ny, nx});
				}
			}
		}
		maxArea = Math.max(maxArea, area);
	}

}
