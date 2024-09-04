import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *	SWEA.1952 수영장_DP
 * 
 *	1. 이용권 가격을 입력받는다.
 *	2. 이용 계획을 입력받는다.
 *		2-1. 1일 이용권을 사용했을 때 가격과 1달 이용권을 사용했을 때 가격을 비교해서 더 적은 비용을 dp 배열에 저장
 *		2-2. 1~3월, 2~4월, ... , 10~12월까지 3달 이용권을 사용했을 때 비용을 기존 dp 배열과 비교해 더 적은 비용을 저장
 *	3. 1일, 1달, 3달 이용권의 최소 비용과 1년 이용권 비용 중 더 적은 비용을 출력
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 이용권 가격을 입력받는다.
			int[] price = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<4; idx++) {
				price[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 2. 이용 계획을 입력받는다.
			int[] dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int month=1; month<=12; month++) {
				int plan = Integer.parseInt(st.nextToken());
				// 2-1. 1일 이용권을 사용했을 때 가격과 1달 이용권을 사용했을 때 가격을 비교해서 더 적은 비용을 dp 배열에 저장
				dp[month] = dp[month-1] + Math.min(plan*price[0], price[1]);
				
				// 2-2. 1~3월, 2~4월, ... , 10~12월까지 3달 이용권을 사용했을 때 비용을 기존 dp 배열과 비교해 더 적은 비용을 저장
				if(month >= 3) {
					dp[month] = Math.min(dp[month], dp[month-3] + price[2]);
				}
			}
			
			// 3. 1일, 1달, 3달 이용권의 최소 비용과 1년 이용권 비용 중 더 적은 비용을 출력
			sb.append(Math.min(dp[12], price[3])).append('\n');
		}
		System.out.print(sb);
	}
}