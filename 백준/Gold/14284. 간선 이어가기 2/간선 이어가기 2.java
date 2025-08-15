import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int vertexCnt, edgeCnt, startVertex, endVertex;
	static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		vertexCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());

		graph = new ArrayList[vertexCnt + 1];
		for(int idx=1; idx<=vertexCnt; idx++) {
			graph[idx] = new ArrayList<>();
		}

		while(edgeCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
			graph[v].add(new Node(u, w));
		}

		st = new StringTokenizer(br.readLine());
		startVertex = Integer.parseInt(st.nextToken());
		endVertex = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		int[] best = new int[vertexCnt + 1];
		Arrays.fill(best, Integer.MAX_VALUE);

		best[startVertex] = 0;
		pq.add(new Node(startVertex, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if (best[cur.end] < cur.weight) continue;
			for (Node next : graph[cur.end]) {
				if (best[next.end] > cur.weight + next.weight) {
					best[next.end] = cur.weight + next.weight;
					pq.add(new Node(next.end, best[next.end]));
				}
			}
		}

		System.out.println(best[endVertex]);
	}

	static class Node {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}
