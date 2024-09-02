import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size, start, minResult = Integer.MAX_VALUE;
	static int[][] adjMatrix;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		size = Integer.parseInt(br.readLine());
		adjMatrix = new int[size][size];
		
		for(int row=0; row<size; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<size; col++) {
				adjMatrix[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(start=0; start<size; start++) {
			visited = new boolean[size];
			visited[start] = true;
			permutation(1, start, 0);
		}
		
		System.out.println(minResult);
	}
	private static void permutation(int selectIdx, int prev, int cost) {
		if(cost >= minResult) {
			return;
		}
		
		if(selectIdx == size) {
			if(adjMatrix[prev][start] == 0) return;
			cost += adjMatrix[prev][start];
			minResult = Math.min(minResult, cost);
			return;
		}
		
		for(int next=0; next<size; next++) {
			if(visited[next] || adjMatrix[prev][next] == 0) continue;
			
			visited[next] = true;
			permutation(selectIdx + 1, next, cost + adjMatrix[prev][next]);
			visited[next] = false;
		}
	}
}
