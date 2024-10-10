import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	SWEA.1263 사람네트워크2 
 *
 *	
 */
public class Solution {
	static int vertexCnt, INF = 1001;
	static int[] cc;
	static int[][] dp;
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
			dp = new int[vertexCnt][vertexCnt];
			
			for(int row=0; row<vertexCnt; row++) {
				for(int col=0; col<vertexCnt; col++) {
					dp[row][col] = st.nextToken().equals("0") ? INF : 1;
				}
			}
			
			for(int middle=0; middle<vertexCnt; middle++) {
				for(int start=0; start<vertexCnt; start++) {
					if(start == middle) continue;
					for(int end=0; end<vertexCnt; end++) {
						if(end == start || end == middle) continue;
						dp[start][end] = Math.min(dp[start][end], dp[start][middle] + dp[middle][end]);
					}
				}
			}
			
			int minResult = Integer.MAX_VALUE;
			for(int row=0; row<vertexCnt; row++) {
				for(int col=0; col<vertexCnt; col++) {
					if(row == col) continue;
					cc[row] += dp[row][col];
				}
				minResult = Math.min(minResult, cc[row]);
			}
	
			sb.append(minResult).append('\n');
		}
		System.out.println(sb);
	}
}