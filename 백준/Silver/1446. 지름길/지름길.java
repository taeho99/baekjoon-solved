import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pathCnt = Integer.parseInt(st.nextToken());
		int totalLen = Integer.parseInt(st.nextToken());
		
		Path[] paths = new Path[pathCnt];
		for(int idx=0; idx<pathCnt; idx++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			paths[idx] = new Path(start, end, cost);
		}
		
		int[] dp = new int[totalLen+1];
		for(int idx=1; idx<=totalLen; idx++) {
			dp[idx] = idx;
		}
		
		for(int len=1; len<=totalLen; len++) {
			dp[len] = Math.min(dp[len], dp[len-1]+1);
			for(int pathIdx=0; pathIdx<pathCnt; pathIdx++) {
				Path path = paths[pathIdx];
				if(len == path.end) {
					dp[len] = Math.min(dp[len], dp[paths[pathIdx].start] + paths[pathIdx].cost);
				}
			}
		}
		
		System.out.println(dp[totalLen]);
	}
	
	static class Path {
		int start, end, cost;

		public Path(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
	}
}