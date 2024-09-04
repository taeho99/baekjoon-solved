import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author SSAFY
 *	역으로 1부터 연산해가며 num 까지 만들기
 */
public class Main {

	public static void main(String[] args) throws IOException {
		int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] dp = new int[num+1];
		for(int idx=2; idx<=num; idx++) {
			dp[idx] = dp[idx-1] + 1;
			if(idx%2 == 0) 
				dp[idx] = dp[idx] < (dp[idx/2]+1) ? dp[idx] : (dp[idx/2]+1);
			if(idx%3 == 0) 
				dp[idx] = dp[idx] < (dp[idx/3]+1) ? dp[idx] : (dp[idx/3]+1);
		}
		System.out.println(dp[num]);
	}

}