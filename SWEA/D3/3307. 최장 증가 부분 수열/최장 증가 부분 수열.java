import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *	SWEA.3307 최장증가부분수열 
 *
 *	1. 전체 수열의 길이와 수열의 값을 입력받는다.
 *	2. 첫 번째 값부터 마지막 값까지 탐색한다.
 *		2-1. 현재 위치에서 최장 부분수열 길이를 기본으로 1로 설정
 *		2-2. 현재 위치의 이전의 값과 비교한다.
 *			2-2-1. 현재 값이 이전 값보다 크면서 현재 저장된 LIS 값보다 이전 저장된 LIS값+1 이 더 크면 LIS 값 업데이트
 *		2-3. 최대 LIS 값을 업데이트하여 maxResult에 저장
 *	3. maxResult 값 출력
 */
public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 전체 수열의 길이와 수열의 값을 입력받는다.
			int size = Integer.parseInt(br.readLine());
			
			int[] nums = new int[size+1];
			st = new StringTokenizer(br.readLine());
			for(int idx=1; idx<=size; idx++) {
				nums[idx] = Integer.parseInt(st.nextToken());
			}
			
			int maxResult = 0;
			// 2. 첫 번째 값부터 마지막 값까지 탐색한다.
			int[] lis = new int[size+1];
			for(int nowIdx=1; nowIdx<=size; nowIdx++) {
				// 2-1. 현재 위치에서 최장 부분수열 길이를 기본으로 1로 설정
				lis[nowIdx] = 1;
				
				// 2-2. 현재 위치의 이전의 값과 비교한다.
				for(int prevIdx=1; prevIdx<nowIdx; prevIdx++) {
					// 2-2-1. 현재 값이 이전 값보다 크면서 현재 저장된 LIS 값보다 이전 저장된 LIS값+1 이 더 크면 LIS 값 업데이트
					if(nums[prevIdx] < nums[nowIdx] && lis[nowIdx] < lis[prevIdx] + 1) {
						lis[nowIdx] = lis[prevIdx] + 1;
					}
				}
				
				// 2-3. 최대 LIS 값을 업데이트하여 maxResult에 저장
				maxResult = Math.max(maxResult, lis[nowIdx]);
			}
			// 3. maxResult 값 출력
			sb.append(maxResult).append('\n');
		}
		
		System.out.print(sb);
	}

}