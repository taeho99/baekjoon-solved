import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	SWEA.1263 사람네트워크2 
 *
 *	
 */
public class Solution {
	static int vertexCnt;
	static int[] cc;
	static boolean[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			vertexCnt = Integer.parseInt(st.nextToken());
			
			cc = new int[vertexCnt];
			adjMatrix = new boolean[vertexCnt][vertexCnt];
			for(int row=0; row<vertexCnt; row++) {
				for(int col=0; col<vertexCnt; col++) {
					adjMatrix[row][col] = st.nextToken().equals("1");
				}
			}
			
			int minResult = Integer.MAX_VALUE;
			for(int vertex=0; vertex<vertexCnt; vertex++) {
				cc[vertex] = bfs(vertex);
				minResult = Math.min(minResult, cc[vertex]);
			}
			
			sb.append(minResult).append('\n');
		}
		System.out.println(sb);
	}
	
	private static int bfs(int vertex) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[vertexCnt];
		
		queue.add(new int[] {vertex, 0});
		visited[vertex] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			cnt += poll[1];
			
			for(int idx=0; idx<vertexCnt; idx++) {
				if(idx == poll[0]) continue;
				if(!adjMatrix[idx][poll[0]] || visited[idx]) continue;
				
				queue.add(new int[] {idx, poll[1]+1});
				visited[idx] = true;
			}
		}
		
		return cnt;
	}
}