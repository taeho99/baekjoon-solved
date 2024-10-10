import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *	SWEA.1263 사람네트워크2 
 *
 *	1. 사람 수와 인접행렬을 입력받는다.
 *		1-1. 인접하지 않은 경우 모두 INF로 채워주기
 *	2. 플로이드 워셜 (경유지, 출발지, 도착지 순서로 for 반복)
 *		2-1. 기존 경로와 경유지를 추가해서 가는 경로 중 최소로 dp 테이블 갱신
 *	3. CC 구하기
 *		3-1. 출발지와 도착지가 같은 경우는 제외
 *		3-2. 누적합 구하기
 *		3-3. 기존 최소값과 비교하여 누적합의 최소 갱신해주기
 *	4. CC 최소값 출력
 */
public class Solution {
	static int vertexCnt, INF = 1001;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');

			// 1. 사람 수와 인접행렬을 입력받는다.
			st = new StringTokenizer(br.readLine());
			vertexCnt = Integer.parseInt(st.nextToken());
			dp = new int[vertexCnt][vertexCnt];
			
			for(int row=0; row<vertexCnt; row++) {
				for(int col=0; col<vertexCnt; col++) {
					// 1-1. 인접하지 않은 경우 모두 INF로 채워주기
					dp[row][col] = st.nextToken().equals("0") ? INF : 1;
				}
			}
			
			// 2. 플로이드 워셜 (경유지, 출발지, 도착지 순서로 for 반복)
			for(int middle=0; middle<vertexCnt; middle++) {
				for(int start=0; start<vertexCnt; start++) {
					for(int end=0; end<vertexCnt; end++) {
						// 2-1. 기존 경로와 경유지를 추가해서 가는 경로 중 최소로 dp 테이블 갱신
						dp[start][end] = Math.min(dp[start][end], dp[start][middle] + dp[middle][end]);
					}
				}
			}
			
			// 3. CC 구하기
			int minResult = Integer.MAX_VALUE;
			for(int start=0; start<vertexCnt; start++) {
				int cc = 0;
				for(int end=0; end<vertexCnt; end++) {
					// 3-1. 출발지와 도착지가 같은 경우는 제외
					if(start == end) continue;
					// 3-2. 누적합 구하기
					cc += dp[start][end];
				}
				// 3-3. 기존 최소값과 비교하여 누적합의 최소 갱신해주기
				minResult = Math.min(minResult, cc);
			}
	
			// 4. CC 최소값 출력
			sb.append(minResult).append('\n');
		}
		System.out.print(sb);
	}
}