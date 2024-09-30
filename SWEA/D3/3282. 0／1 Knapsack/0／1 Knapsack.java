import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 물품의 수와 무게, 그리고 무게와 가치 리스트를 입력받는다.
			st = new StringTokenizer(br.readLine());
			int itemCnt = Integer.parseInt(st.nextToken());
			int maxWeight = Integer.parseInt(st.nextToken());

			int[] weights = new int[itemCnt + 1];
			int[] values = new int[itemCnt + 1];

			for (int idx = 1; idx <= itemCnt; idx++) {
				st = new StringTokenizer(br.readLine());
				weights[idx] = Integer.parseInt(st.nextToken());
				values[idx] = Integer.parseInt(st.nextToken());
			}

			// 2. DP 테이블을 만든다.
			int[][] dp = new int[itemCnt + 1][maxWeight + 1];

			// 3. 1번 물품부터 N번 물품까지 각 물품의 최대 가치를 구한다.
			for (int item = 1; item <= itemCnt; item++) {
				// 3-1. 무게 1부터 최대 무게까지 배낭 무게를 늘려가며 최대 가치를 구한다.
				for (int weight = 1; weight <= maxWeight; weight++) {
					// 3-1-1. 현재 아이템이 배낭에 안들어가면 이전 물품까지의 가치를 현재 가치에 대입
					if (weights[item] > weight) {
						dp[item][weight] = dp[item - 1][weight];
					}
					// 3-1-2. 현재 아이템이 배낭에 들어가면
					// max(현재아이템 가치+이전 물품까지의 가치 중 현재 무게를 뺀 것, 이전 물품까지 가치)를
					// 현재 가치에 대입
					else {
						dp[item][weight] = Math.max(values[item] + dp[item - 1][weight - weights[item]],
								dp[item - 1][weight]);
					}
				}
			}

			// 4. 테이블 우측 하단의 마지막 계산된 결과가 넣을 수 있는 물건들의 가치합의 최댓값이므로 출력
			sb.append(dp[itemCnt][maxWeight]).append('\n');
		}
		System.out.print(sb);
	}
}