import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			graph[i] = new ArrayList<>();
		}
		dp = new int[v+1];
		visited = new boolean[v+1];
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[node1].add(new Node(node2, weight));
		}
		
		Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		Arrays.fill(dp, Integer.MAX_VALUE);
		pq.add(new Node(start, 0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			
			if(!visited[poll.to]) {
				visited[poll.to] = true;
				
				for(Node next : graph[poll.to]) {
					if(dp[next.to] >= dp[poll.to] + next.weight) {
						dp[next.to]= dp[poll.to] + next.weight;
						pq.add(new Node(next.to, dp[next.to]));
					}
				}
			}
		}
		
		for(int i=1; i<=v; i++) {
			sb.append(dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]).append('\n');
		}
		System.out.print(sb);
	}
	
	static class Node {
		int to, weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
