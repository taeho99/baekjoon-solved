import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 	1. 인접 리스트를 2개 만든다.
 * 		1-1. 하나는 정방향
 * 		1-2. 하나는 키순서 역방향
 * 	2. 두 방향으로 인접 정점들 bfs 하면서 몇 칸 지나가는지 체크
 * 	3. 정방향 bfs 지난 칸 개수 + 역방향 bfs 지난 칸 개수 == (v-1)개
 */
public class Solution {
	static int vertexCnt, edgeCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			vertexCnt = Integer.parseInt(br.readLine().trim());
			edgeCnt = Integer.parseInt(br.readLine().trim());
			
			ArrayList<Integer>[] adj = new ArrayList[vertexCnt];
			ArrayList<Integer>[] adjReverse = new ArrayList[vertexCnt];
			
			for(int idx=0; idx<vertexCnt; idx++) {
				adj[idx] = new ArrayList<>();
				adjReverse[idx] = new ArrayList<>();
			}
			
			for(int idx=0; idx<edgeCnt; idx++) {
				st = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				
				adj[from].add(to);
				adjReverse[to].add(from);
			}
			
			int result = 0;
			for(int idx=0; idx<vertexCnt; idx++) {
				int inCnt = bfs(idx, adjReverse);
				int outCnt = bfs(idx, adj);
//				System.out.println("[" + (idx+1) + "] " + inCnt + " " + outCnt);
				if(inCnt + outCnt == vertexCnt-1) result++;
			}
			
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}

	private static int bfs(int startIdx, ArrayList<Integer>[] adj) {
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[vertexCnt];
		
		queue.add(startIdx);
		visited[startIdx] = true;
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for (int next : adj[poll]) {
				if(visited[next]) continue;
				visited[next] = true;
				queue.add(next);
				cnt++;
			}
		}
		
		return cnt;
	}
}