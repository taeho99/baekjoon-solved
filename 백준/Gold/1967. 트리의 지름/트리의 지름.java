import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<int[]>> graph;
	static boolean[] visited;
	static int n, max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine().trim());
		graph = new ArrayList<>();
		
		for(int idx = 0; idx <= n; idx++) {
			graph.add(new ArrayList<>());
		}
		
		for(int idx = 0; idx < n-1; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph.get(node1).add(new int[] {node2, weight});
			graph.get(node2).add(new int[] {node1, weight});
		}
		
		for(int node = 1; node <= n; node++) {
			visited = new boolean[n+1];
			dfs(node, 0);
		}
		
		System.out.println(max);
	}

	private static void dfs(int start, int sum) {
		visited[start] = true;
		max = Math.max(max,  sum);
		
		/*for(int weight : graph.get(node)) {
			if(!visited[i]) {
				
			}
		}*/
		for(int[] node : graph.get(start)) {
			if(!visited[node[0]]) {
				dfs(node[0], sum + node[1]);
			}
		}
	}

}
