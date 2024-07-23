import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[100001];
		Queue<int[]> queue = new LinkedList<>();
	
		queue.add(new int[] {n, 0});
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			if(poll[0] == k) {
				System.out.println(poll[1]);
				break;
			}
			
			int[] next = {poll[0] - 1, poll[0] + 1, poll[0]*2};
			
			for(int i=0; i<3; i++) {
				if(next[i] >= 0 && next[i] <= 100000 && !visited[next[i]]) {
					queue.add(new int[] {next[i], poll[1] + 1});
					visited[next[i]] = true;
				}
			}
		}
		
	}

}
