import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 0: 내부공기, 1: 치즈, 2: 외부공기
		int[][] map = new int[n][m];
		ArrayList<int[]> cheese = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cheese.add(new int[] {i, j});
				}
			}
		}
		
		int time = 0, result = 0;
		while(cheese.size() != 0) {
			time++;
			//bfs 외부 공기 2로 바꾸기
			Queue<int[]> queue = new LinkedList<>();
			boolean[][] visited = new boolean[n][m];
			visited[0][0] = true;
			map[0][0] = 2;
			queue.add(new int[] {0, 0});
			
			while(!queue.isEmpty()) {
				int[] poll = queue.poll();
				for(int i=0; i<4; i++) {
					int ny = poll[0] + dy[i];
					int nx = poll[1] + dx[i];
					if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
					if(!visited[ny][nx] && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						map[ny][nx] = 2;
						queue.add(new int[] {ny, nx});
					}
				}
			}
			
			result = cheese.size();
			
			for(int i=0; i<cheese.size(); i++) {
				boolean isAttachAir = false;
				int[] poll = cheese.get(i);
				for(int j=0; j<4; j++) {
					int ny = poll[0] + dy[j];
					int nx = poll[1] + dx[j];
					if(map[ny][nx] == 2) {
						isAttachAir = true;
						break;
					}
				}
				
				if(isAttachAir) {
					map[poll[0]][poll[1]] = 0;
					cheese.remove(i--);
				}
			}
		}
		System.out.println(time);
		System.out.println(result);
		
	}

}
