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
 *		1-3. 앱의 비활성화 비용을 입력
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int appCnt = Integer.parseInt(st.nextToken());
		int targetMemory = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] memory = new int[appCnt+1];
		for(int idx=1; idx<=appCnt; idx++) {
			memory[idx] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] cost = new int[appCnt+1];
		int maxCost = 0;
		for(int idx=1; idx<=appCnt; idx++) {
			cost[idx] = Integer.parseInt(st.nextToken());
			maxCost += cost[idx];
		}
		
		int[] dp = new int[maxCost+1];
		int result = Integer.MAX_VALUE;
//		for(int appIdx=1; appIdx<=appCnt; appIdx++) {
//			for(int nowMaxCost=1; nowMaxCost<=10000; nowMaxCost++) {
//				if(cost[appIdx] > nowMaxCost) {
//					dp[appIdx][nowMaxCost] = dp[appIdx-1][nowMaxCost];
//				} else {
//					dp[appIdx][nowMaxCost] = Math.max(dp[appIdx-1][nowMaxCost], memory[appIdx] + dp[appIdx-1][nowMaxCost-cost[appIdx]]);
//				}
//				
//				if(dp[appIdx][nowMaxCost] >= targetMemory) {
//					result = Math.min(result, nowMaxCost);
//				}
//			}
//		}
		
		for(int appIdx=1; appIdx<=appCnt; appIdx++) {
			for(int nowMaxCost=maxCost; nowMaxCost>=cost[appIdx]; nowMaxCost--) {
				dp[nowMaxCost] = Math.max(dp[nowMaxCost], memory[appIdx] + dp[nowMaxCost-cost[appIdx]]);
				if(dp[nowMaxCost] >= targetMemory) {
					result = Math.min(result, nowMaxCost);
				}
			}
		}
		
		System.out.println(result);
		
	}

}