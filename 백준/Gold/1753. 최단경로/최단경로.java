import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	BOJ.1753 최단경로
 *	
 *	1. 정점 개수, 간선 개수, 시작 정점, 간선 리스트를 입력받는다.
 *		1-1. 입력 받은 간선 리스트로 인접 정점 리스트를 만든다.
 *	2. 최단 경로의 초기값으로 모두 무한대를 할당한다.
 *	3. 비용이 최소인 정점부터 꺼내기 위해 우선순위 큐를 초기화한다.
 *		3-1. 시작 정점을 큐에 넣고 (start -> start) 경로의 비용을 0으로 설정한다.
 *		3-2. 인접 정점이 없을 때까지 반복한다.
 *			3-2-1. minDistance가 최소인 정점을 선택한다.
 *			3-2-2. 만약, 이미 확인한 정점이면 제외한다.
 *			3-2-3. 현재 정점의 인접 정점들을 모두 확인한다.
 *				3-2-3-1. (start -> next)의 최단 경로와 (start ~> now -> next)의 최단 경로를 비교한다.
 *				3-2-3-2. (start ~> now -> next)의 최단 경로가 더 작으면 갱신한다.
 *	4. 시작 정점에서 모든 정점으로의 최단 경로를 구했으므로, 초기값인 무한대면 INF 출력, 아니면 최단 경로 값을 출력한다.
 */
public class Main {
	static List<Node>[] adjList;
	static boolean[] visited;
	static int[] minDistance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 정점 개수, 간선 개수, 시작 정점, 간선 리스트를 입력받는다.
		int vertectCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[vertectCnt+1];
		for(int idx=1; idx<=vertectCnt; idx++) {
			adjList[idx] = new ArrayList<>();
		}
		minDistance = new int[vertectCnt+1];
		visited = new boolean[vertectCnt+1];
		
		// 1-1. 입력 받은 간선 리스트로 인접 정점 리스트를 만든다.
		for(int idx=0; idx<edgeCnt; idx++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[node1].add(new Node(node2, weight));
		}

		// 2. 최단 경로의 초기값으로 모두 무한대를 할당한다.
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		
		// 3. 비용이 최소인 정점부터 꺼내기 위해 우선순위 큐를 초기화한다.
		Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		// 3-1. 시작 정점을 큐에 넣고 (start -> start) 경로의 비용을 0으로 설정한다.
		pq.add(new Node(start, 0));
		minDistance[start] = 0;
		
		// 3-2. 인접 정점이 없을 때까지 반복한다.
		while(!pq.isEmpty()) {
			// 3-2-1. minDistance가 최소인 정점을 선택한다.
			Node poll = pq.poll();
			// 3-2-2. 만약, 이미 확인한 정점이면 제외한다.
			if(visited[poll.to]) continue;
			
			visited[poll.to] = true;
			
			// 3-2-3. 현재 정점의 인접 정점들을 모두 확인한다.
			for(Node next : adjList[poll.to]) {
				// 3-2-3-1. (start -> next)의 최단 경로와 (start ~> now -> next)의 최단 경로를 비교한다.
				if(minDistance[next.to] > minDistance[poll.to] + next.weight) {
					// 3-2-3-2. (start ~> now -> next)의 최단 경로가 더 작으면 갱신한다.
					minDistance[next.to] = minDistance[poll.to] + next.weight;
					pq.add(new Node(next.to, minDistance[next.to]));
				}
			}
		}
		
		// 4. 시작 정점에서 모든 정점으로의 최단 경로를 구했으므로, 초기값인 무한대면 INF 출력, 아니면 최단 경로 값을 출력한다.
		for(int i=1; i<=vertectCnt; i++) {
			sb.append(minDistance[i] == Integer.MAX_VALUE ? "INF" : minDistance[i]).append('\n');
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
