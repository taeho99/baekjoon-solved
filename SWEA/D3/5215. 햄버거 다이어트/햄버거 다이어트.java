import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *	SWEA.5215 햄버거다이어트_DP 
 *
 *	1. 재료 개수와 최대 칼로리를 입력받는다.
 *	2. 각 재료의 점수와 칼로리를 입력받는다.
 *	3. 재료를 모두 순회 (각 재료를 선택)
 *		3-1. 칼로리 제한을 1부터 최대 칼로리까지 순회
 *			3-1-1. 현재 칼로리가 제한 칼로리를 이하인 경우
 *				3-1-1-1. 현재(row번) 재료를 넣지 않는 경우 점수와 재료를 넣은 점수 중 큰 값을 dp배열에 넣기
 *			3-1-2. 현재 칼로리가 제한 칼로리를 넘는 경우
 *				3-1-2-1. 직전(row-1번) 재료의 최대 점수를 그냥 넣어주기
 *	4. 최대 점수는 우측 하단 마지막 인덱스이므로 출력
 */
public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T;
	static int ingredientCnt, maxCalorie;
	static int[] scores, calories;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 재료 개수와 최대 칼로리를 입력받는다.
			st = new StringTokenizer(br.readLine());
			ingredientCnt = Integer.parseInt(st.nextToken());
			maxCalorie = Integer.parseInt(st.nextToken());
			
			// 2. 각 재료의 점수와 칼로리를 입력받는다.
			scores = new int[ingredientCnt+1];
			calories = new int[ingredientCnt+1];
			for(int idx=1; idx<=ingredientCnt; idx++) {
				st = new StringTokenizer(br.readLine());
				scores[idx] = Integer.parseInt(st.nextToken());
				calories[idx] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[ingredientCnt+1][maxCalorie+1];
			// 3. 재료를 모두 순회 (각 재료를 선택)
			for(int row=1; row<=ingredientCnt; row++) {
				// 3-1. 칼로리 제한을 1부터 최대 칼로리까지 순회
				for(int col=1; col<=maxCalorie; col++) {
					// 3-1-1. 현재 칼로리가 제한 칼로리를 이하인 경우
					if(calories[row] <= col) {
						// 3-1-1-1. 현재(row번) 재료를 넣지 않는 경우 점수와 재료를 넣은 점수 중 큰 값을 dp배열에 넣기
						dp[row][col] = Math.max(dp[row-1][col], dp[row-1][col-calories[row]] + scores[row]);
					} 
					// 3-1-2. 현재 칼로리가 제한 칼로리를 넘는 경우
					else {
						// 3-1-2-1. 직전(row-1번) 재료의 최대 점수를 그냥 넣어주기
						dp[row][col] = dp[row-1][col];
					}
				}
			}
			
			// 4. 최대 점수는 우측 하단 마지막 인덱스이므로 출력
			sb.append(dp[ingredientCnt][maxCalorie]).append('\n');
		}
		System.out.print(sb);
	}

}