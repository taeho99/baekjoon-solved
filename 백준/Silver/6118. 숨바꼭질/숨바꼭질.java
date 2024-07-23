import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			adj[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 0});
		visited[1] = true;
		int dist = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			dist = Math.max(dist, poll[1]);
			
			for(int node : adj[poll[0]]) {
				if(!visited[node]) {
					visited[node] = true;
					queue.add(new int[] {node, poll[1] + 1});
				}
			}
		}
		
		visited = new boolean[n+1];
		queue.add(new int[] {1, 0});
		visited[1] = true;
		int num = 20001, count = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			if(poll[1] == dist) {
				count++;
				num = Math.min(num, poll[0]);
			}
			
			for(int node : adj[poll[0]]) {
				if(!visited[node]) {
					visited[node] = true;
					queue.add(new int[] {node, poll[1] + 1});
				}
			}
		}
		
		System.out.println(num + " " + dist + " " + count);
		
	}

}
