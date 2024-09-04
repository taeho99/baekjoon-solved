import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int homeCnt = Integer.parseInt(br.readLine());
		int[][] dp = new int[homeCnt][3];
		for(int home=0; home<homeCnt; home++) {
			st = new StringTokenizer(br.readLine());
			for(int color=0; color<3; color++) {
				dp[home][color] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int home=1; home<homeCnt; home++) {
			for(int color=0; color<3; color++) {
				if(color == 0) {
					dp[home][0] += Math.min(dp[home-1][1], dp[home-1][2]);
				} else if (color == 1) {
					dp[home][1] += Math.min(dp[home-1][0], dp[home-1][2]);
				} else {
					dp[home][2] += Math.min(dp[home-1][0], dp[home-1][1]);
				}
			}
		}
		System.out.print(Math.min(dp[homeCnt-1][0], Math.min(dp[homeCnt-1][1], dp[homeCnt-1][2])));
	}
}