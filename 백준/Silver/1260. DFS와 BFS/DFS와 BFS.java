import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int vertexCnt, edgeCnt, start;
	static ArrayList<Integer>[] graph;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		vertexCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		graph = new ArrayList[vertexCnt + 1];
		for(int idx=1; idx<=vertexCnt; idx++) {
			graph[idx] = new ArrayList<>();
		}

		while(edgeCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		for(int idx=1; idx<=vertexCnt; idx++) {
			Collections.sort(graph[idx]);
		}

		boolean[] visited = new boolean[vertexCnt + 1];
		dfs(start, visited);
		sb.append('\n');
		bfs();

		System.out.print(sb);
	}

	private static void dfs(int now, boolean[] visited) {
		visited[now] = true;
		sb.append(now).append(' ');

		for (int next : graph[now]) {
			if (visited[next]) continue;
			dfs(next, visited);
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[vertexCnt + 1];

		queue.add(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int poll = queue.poll();
			sb.append(poll).append(' ');

			for (int next : graph[poll]) {
				if (visited[next]) continue;
				queue.add(next);
				visited[next] = true;
			}
		}
	}
}