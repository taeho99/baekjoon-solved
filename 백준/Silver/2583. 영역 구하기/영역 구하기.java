import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(map[i], true);
		}
		visited = new boolean[n][m];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = n - Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = n - Integer.parseInt(st.nextToken());
			
			for(int row=y2; row<=y1; row++) {
				for(int col=x1; col<=x2; col++) {
					map[row][col] = false;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int n : result) {
			System.out.print(n + " ");
		}
	}
	
	static void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		visited[y][x] = true;
		
		int count = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			count++;
			
			for(int i=0; i<4; i++) {
				int ny = poll[0] + dy[i];
				int nx = poll[1] + dx[i];

				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

				if(!visited[ny][nx] && map[ny][nx]) {
					queue.add(new int[] {ny, nx});
					visited[ny][nx] = true;
				}
			}
		}
		result.add(count);
	}

}
