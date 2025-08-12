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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		startVertex = Integer.parseInt(st.nextToken());
		endVertex = Integer.parseInt(st.nextToken());

		int[] bestMax = new int[vertexCnt + 1];
		Arrays.fill(bestMax, -1);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.weight, o1.weight));

		bestMax[startVertex] = Integer.MAX_VALUE;
		pq.add(new Node(startVertex, Integer.MAX_VALUE));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			if(cur.end == endVertex) {
				System.out.println(bestMax[endVertex]);
				break;
			}
			if(bestMax[cur.end] > cur.weight) continue;

			for (Node next : graph[cur.end]) {
				if (bestMax[next.end] < Math.min(cur.weight, next.weight)) {
					bestMax[next.end] = Math.min(cur.weight, next.weight);
					pq.add(new Node(next.end, bestMax[next.end]));
				}
			}
		}
	}

	static class Node {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}
