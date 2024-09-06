import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	BOJ.1010 다리놓기
 * 
 * 	0. r: 강 서쪽 사이트 수 / n: 강 동쪽 사이트 수 -> n개 중 r개 조합으로 뽑으면 됨
 * 	0. dp[n][r] : nCr 값 메모이제이션 
 * 	1. n과 r 입력으로 받기
 * 	2. nCr 구하고 출력하기
 * 		2-1. 메모이제이션 한 값이 있으면 그 값 반환하기
 * 		2-2. n==r 또는 r==0 이면 무조건 1이므로 메모이제이션 하고 반환하기
 * 		2-3. 두 경우 다 아니면 직접 계산해서 메모이제이션 하고 반환하기
 */
public class Main {
	// 0. r: 강 서쪽 사이트 수 / n: 강 동쪽 사이트 수 -> n개 중 r개 조합으로 뽑으면 됨
	static int n, r;
	// 0. dp[n][r] : nCr 값 메모이제이션 
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			// 1. n과 r 입력으로 받기
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			// 2. nCr 구하고 출력하기
			sb.append(combination(n, r)).append('\n');
		}
		System.out.print(sb);
	}
	static int combination(int n, int r) {
		// 2-1. 메모이제이션 한 값이 있으면 그 값 반환하기
		if(dp[n][r] > 0) return dp[n][r];
		// 2-2. n==r 또는 r==0 이면 무조건 1이므로 메모이제이션 하고 반환하기
		if(n==r || r==0) return dp[n][r] = 1;
		// 2-3. 두 경우 다 아니면 직접 계산해서 메모이제이션 하고 반환하기
		return dp[n][r] = combination(n-1, r) + combination(n-1, r-1);
	}
}