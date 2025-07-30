import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// dp[people] = minimumCost
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int minimumPeople = Integer.parseInt(st.nextToken());
		int cityCnt = Integer.parseInt(st.nextToken());

		int[] dp = new int[minimumPeople + 101];
		Arrays.fill(dp, 999_999_999);
		dp[0] = 0;
		for(int idx=0; idx<cityCnt; idx++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			for(int customerIdx=people; customerIdx<minimumPeople+101; customerIdx++) {
				dp[customerIdx] = Math.min(dp[customerIdx], dp[customerIdx-people] + cost);
			}
		}
		int minResult = Integer.MAX_VALUE;
		for(int idx=minimumPeople; idx<minimumPeople+101; idx++) {
			minResult = Math.min(minResult, dp[idx]);
		}
		System.out.println(minResult);
	}
}
