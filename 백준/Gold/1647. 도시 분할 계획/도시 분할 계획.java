import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int vertexCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());

		List<Edge> edges = new ArrayList<>();
		while(edgeCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(start, end, weight));
		}

		Collections.sort(edges);

		// make-set
		parents = new int[vertexCnt + 1];
		Arrays.fill(parents, -1);

		int cnt=0, cost=0, lastCost = 0;
		for (Edge edge : edges) {
			if (findSet(edge.start) == findSet(edge.end)) continue;
			union(edge.start, edge.end);
			cost += edge.weight;
			lastCost = edge.weight;
			if(++cnt == vertexCnt - 1) break;
		}

		System.out.println(cost - lastCost);
	}

	static int findSet(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}

	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return;
		parents[bRoot] = aRoot;
	}

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
