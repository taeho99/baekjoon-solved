import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	BOJ.1453 1로만들기
 * 
 * 	1. 1로 만들 숫자 num을 입력받는다.
 * 	2. dp 배열에 idx에서 1까지 만드는 최소 연산 횟수를 저장
 * 		2-1. 1을 빼는 연산은 (현재 수 - 1) 연산 횟수에서 1을 더해서 저장
 * 		2-2. 2로 나누는 연산은 현재 수가 2로 나누어 떨어질 때만
 * 			2-2-1. 기존에 구한 연산 횟수와 (현재수/2)연산 횟수에 연산횟수 1을 더한 값과 비교해 더 작은 값 저장
 * 		2-3. 3으로 나누는 연산은 현재 수가 3으로 나누어 떨어질 때만
 * 			2-3-1. 기존에 구한 연산 횟수와 (현재수/3)연산 횟수에 연산횟수 1을 더한 값과 비교해 더 작은 값 저장
 * 	3. num의 연산 횟수를 출력
 */
public class Main {
	static int num;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// 1. 1로 만들 숫자 num을 입력받는다.
		num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		
		// 2. dp 배열에 idx에서 1까지 만드는 최소 연산 횟수를 저장
		dp = new int[num+1];
		for(int idx=2; idx<=num; idx++) {
			// 2-1. 1을 빼는 연산은 (현재 수 - 1) 연산 횟수에서 1을 더해서 저장
			dp[idx] = dp[idx-1] + 1;
			
			// 2-2. 2로 나누는 연산은 현재 수가 2로 나누어 떨어질 때만
			if(idx%2 == 0) {
				// 2-2-1. 기존에 구한 연산 횟수와 (현재수/2)연산 횟수에 연산횟수 1을 더한 값과 비교해 더 작은 값 저장
				dp[idx] = Math.min(dp[idx], dp[idx/2]+1);
			}
			
			// 2-3. 3으로 나누는 연산은 현재 수가 3으로 나누어 떨어질 때만
			if(idx%3 == 0) {
				// 2-3-1. 기존에 구한 연산 횟수와 (현재수/3)연산 횟수에 연산횟수 1을 더한 값과 비교해 더 작은 값 저장
				dp[idx] = Math.min(dp[idx], dp[idx/3]+1);
			}
		}
		
		// 3. num의 연산 횟수를 출력
		System.out.print(dp[num]);
	}
}