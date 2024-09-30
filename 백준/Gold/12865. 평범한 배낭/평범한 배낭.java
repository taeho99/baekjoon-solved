import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int itemCnt = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[itemCnt+1];
		int[] values = new int[itemCnt+1];
		
		for(int idx=1; idx<=itemCnt; idx++) {
			st = new StringTokenizer(br.readLine());
			weights[idx] = Integer.parseInt(st.nextToken());
			values[idx] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[itemCnt+1][maxWeight+1];
		for(int item=1; item<=itemCnt; item++) {
			for(int weight=1; weight<=maxWeight; weight++) {
				if(weights[item] > weight) {
					dp[item][weight] = dp[item-1][weight];
				} else {
					dp[item][weight] = Math.max(values[item] + dp[item-1][weight-weights[item]], dp[item-1][weight]);
				}
			}
		}
		
		System.out.print(dp[itemCnt][maxWeight]);
	}
}