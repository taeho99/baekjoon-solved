import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 사람 수: N명, 문제 수: M개
 * 2. N*M 배열에 문제를 풀었으면 1, 못 풀었으면 0
 * 3. 가장 많이 문제를 푼 사람의 수와 푼 문제의 수를 출력
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			sb.append('#').append(t).append(' ');
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			//각 사람들이 푼 문제 수를 담는 배열
			int[] result = new int[n];
			//cnt: 1등한 사람 수, maxScore: 가장 높은 점수
			int cnt = 0, maxScore = 0; 
			
			for(int row=0; row<n; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<m; col++) {
					//문제를 풀었을 경우 result 배열에 푼 문제 수를 1 추가하고 maxScore 업데이트
					if(Integer.parseInt(st.nextToken()) == 1) {
						result[row]++;
						maxScore = Math.max(maxScore, result[row]);
					}
				}
			}
			
			//점수가 maxScore인 사람 카운팅
			for(int row=0; row<n; row++) {
				if(result[row] == maxScore) cnt++;
			}
			
			sb.append(cnt).append(' ').append(maxScore).append('\n');
		}
		System.out.print(sb);
	}
}
