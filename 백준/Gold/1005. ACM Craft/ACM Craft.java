import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static int vertexCnt, edgeCnt, target;
	static int[] time, indegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			vertexCnt = Integer.parseInt(st.nextToken());
			edgeCnt = Integer.parseInt(st.nextToken());

			time = new int[vertexCnt + 1];
			graph = new ArrayList[vertexCnt + 1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=vertexCnt; idx++) {
				graph[idx] = new ArrayList<>();
				time[idx] = Integer.parseInt(st.nextToken());
			}

			indegree = new int[vertexCnt + 1];
			while(edgeCnt-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				graph[v1].add(v2);
				indegree[v2]++;
			}

			target = Integer.parseInt(br.readLine());

			sb.append(topologicalSort()).append('\n');
		}
		System.out.print(sb);
	}

	private static int topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[vertexCnt + 1];

		for(int idx=1; idx<=vertexCnt; idx++) {
			if(indegree[idx] == 0) {
				result[idx] = time[idx];
				queue.add(idx);
			}
		}

		while(!queue.isEmpty()) {
			int prev = queue.poll();
			for (int next : graph[prev]) {
				result[next] = Math.max(result[next], result[prev] + time[next]);
				indegree[next]--;
				if(indegree[next] == 0) queue.add(next);
			}
		}
		return result[target];
	}
}
