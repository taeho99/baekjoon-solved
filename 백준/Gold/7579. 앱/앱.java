import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *	BOJ.7579 앱
 *
 *	0. 확보해야 하는 메모리를 넘으면서 비용은 최소가 돼야함.
 *	1. 입력
 *		1-1. 앱의 개수와 총 확보해야 하는 최소 메모리 입력
 *		1-2. 앱이 사용하는 메모리를 입력
 *		1-3. 앱의 비활성화 비용을 입력 및 최대 비용 저장
 *	2. DP 테이블 정의 : dp[cost] -> 현재 cost에서 가능한 최대 메모리
 *	3. 1번 앱부터 마지막 앱까지 확인
 *		3-1. 현재 비용을 최댓값부터 줄여나가면서 확인
 *			3-1-1. 이전 메모리 누적 값에 max(현재 앱 선택X, 현재 앱 선택O)한 메모리 값을 DP 테이블에 저장
 *			3-1-2. 현재 사용한 메모리가 목표 메모리값보다 크면 result 갱신
 *	4. 결과값 출력
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 입력
		// 1-1. 앱의 개수와 총 확보해야 하는 최소 메모리 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int appCnt = Integer.parseInt(st.nextToken());
		int targetMemory = Integer.parseInt(st.nextToken());
		
		// 1-2. 앱이 사용하는 메모리를 입력
		st = new StringTokenizer(br.readLine());
		int[] memory = new int[appCnt+1];
		for(int idx=1; idx<=appCnt; idx++) {
			memory[idx] = Integer.parseInt(st.nextToken());
		}
		
		// 1-3. 앱의 비활성화 비용을 입력 및 최대 비용 저장
		st = new StringTokenizer(br.readLine());
		int[] cost = new int[appCnt+1];
		int maxCost = 0;
		for(int idx=1; idx<=appCnt; idx++) {
			cost[idx] = Integer.parseInt(st.nextToken());
			maxCost += cost[idx];
		}
		
		
		int result = Integer.MAX_VALUE;

		// 2. DP 테이블 정의 : dp[cost] -> 현재 cost에서 가능한 최대 메모리
		int[] dp = new int[maxCost+1];
		
		// 3. 1번 앱부터 마지막 앱까지 확인
		for(int appIdx=1; appIdx<=appCnt; appIdx++) {
			// 3-1. 현재 비용을 최댓값부터 줄여나가면서 확인
			for(int nowCost=maxCost; nowCost>=cost[appIdx]; nowCost--) {
				// 3-1-1. 이전 메모리 누적 값에 max(현재 앱 선택X, 현재 앱 선택O)한 메모리 값을 DP 테이블에 저장
				dp[nowCost] = Math.max(dp[nowCost], memory[appIdx] + dp[nowCost-cost[appIdx]]);
				// 3-1-2. 현재 사용한 메모리가 목표 메모리값보다 크면 result 갱신
				if(dp[nowCost] >= targetMemory) {
					result = Math.min(result, nowCost);
				}
			}
		}
		
		// 4. 결과값 출력
		System.out.println(result);
		
	}

}