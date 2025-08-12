import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

		int left = 1, right = 1_000_000_000;
		int answer = 0;

		while(left <= right) {
			int nowWeight = (left + right) / 2; // 중량제한
			if (canReach(nowWeight)) {
				answer = nowWeight;
				left = nowWeight + 1;
			} else {
				right = nowWeight - 1;
			}
		}

		System.out.println(answer);
	}

	private static boolean canReach(int nowWeight) {
		boolean[] visited = new boolean[vertexCnt + 1];
		Queue<Integer> queue = new LinkedList<>();

		queue.add(startVertex);
		visited[startVertex] = true;

		while(!queue.isEmpty()) {
			int poll = queue.poll();
			if(poll == endVertex) return true;

			for (Node next : graph[poll]) {
				if(!visited[next.end] && next.weight >= nowWeight) {
					visited[next.end] = true;
					queue.add(next.end);
				}
			}
		}
		return false;
	}

	static class Node {
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}
