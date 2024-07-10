import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[][] adj = new int[n+1][n+1];
		int[] dist = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x][y] = adj[y][x] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(a);
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for(int i=1; i<=n; i++) {
				if(adj[poll][i] == 1 && dist[i] == 0) {
					queue.add(i);
					dist[i] = dist[poll] + 1;
				}
			}
		}
		
		System.out.println(dist[b] == 0 ? -1 : dist[b]);
	}
}
