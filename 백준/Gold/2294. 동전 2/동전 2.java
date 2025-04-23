import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int coinCnt = Integer.parseInt(st.nextToken());
		int valueSum = Integer.parseInt(st.nextToken());

		int[] coins = new int[coinCnt + 1];
		for (int idx=1; idx<=coinCnt; idx++) {
			coins[idx] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[valueSum + 1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;

		for (int coin : coins) {
			if (coin == 0) continue;
			for(int value=coin; value<=valueSum; value++) {
				dp[value] = Math.min(dp[value], dp[value-coin] + 1);
			}
		}
		System.out.println(dp[valueSum] == Integer.MAX_VALUE-1 ? -1 : dp[valueSum]);
	}
}