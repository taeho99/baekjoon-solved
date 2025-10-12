import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int vertexSize, edgeSize, result;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		vertexSize = Integer.parseInt(st.nextToken());
		edgeSize = Integer.parseInt(st.nextToken());

		graph = new ArrayList[vertexSize];
		for(int idx=0; idx<vertexSize; idx++) {
			graph[idx] = new ArrayList<>();
		}

		while(edgeSize-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		boolean[] visited = new boolean[vertexSize];
		for(int start=0; start<vertexSize; start++) {
			visited[start] = true;
			dfs(start, 0, visited);
			visited[start] = false;
			if(result == 1) break;
		}
		System.out.println(result);
	}

	private static void dfs(int now, int depth, boolean[] visited) {
		if(result == 1) return;
		if(depth == 4) {
			result = 1;
			return;
		}

		for (int next : graph[now]) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next, depth+1, visited);
			visited[next] = false;
		}
	}
}
