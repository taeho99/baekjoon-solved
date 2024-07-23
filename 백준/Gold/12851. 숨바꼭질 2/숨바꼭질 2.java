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
		
		int[] visited = new int[100001];
		Queue<int[]> queue = new LinkedList<>();
	
		queue.add(new int[] {n, 0});
		visited[n] = 1;
		int count = 0, time = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			if(poll[0] == k) {
				if(count == 0) {
					time = poll[1];
				}
				if(time == poll[1]) {
					count++;
				}
			}
			
			int[] next = {poll[0] - 1, poll[0] + 1, poll[0]*2};
			
			for(int i=0; i<3; i++) {
				if(next[i] >= 0 && next[i] <= 100000 && (visited[next[i]] == 0 || visited[next[i]] == poll[1]+1)) {
					queue.add(new int[] {next[i], poll[1] + 1});
					visited[next[i]] = poll[1]+1;
				}
			}
		}
		System.out.println(time);
		System.out.println(count);
	}

}
