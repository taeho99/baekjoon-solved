import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int totalDay = Integer.parseInt(br.readLine());
		int[] dp = new int[totalDay+2];

		for (int day = 1; day <= totalDay; day++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			dp[day] = Math.max(dp[day], dp[day - 1]);
			if (day + t <= totalDay + 1) {
				dp[day + t] = Math.max(dp[day + t], dp[day] + p);
			}
		}
		dp[totalDay+1] = Math.max(dp[totalDay], dp[totalDay+1]);
		System.out.println(dp[totalDay+1]);
	}
}
