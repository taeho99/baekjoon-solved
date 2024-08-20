import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA.1486 장훈이의높은선반
 *
 * 1. 점원 수와 선반의 높이, 각 점원들의 키를 입력받는다.
 * 2. 부분집합으로 가능한 모든 조합을 살펴보고 키의 합이 선반의 높이보다 같거나 크면 result를 갱신한다.
 * 3. 결과값을 출력한다.
 */
public class Solution {
	static int size, shelf, result;
	static int[] height;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 점원 수와 선반의 높이, 각 점원들의 키를 입력받는다.
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			shelf = Integer.parseInt(st.nextToken());
			height = new int[size];
			
			st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<size; idx++) {
				height[idx] = Integer.parseInt(st.nextToken());
			}
			
			result = Integer.MAX_VALUE;
			// 2. 부분집합으로 가능한 모든 조합을 살펴보고 키의 합이 선반의 높이보다 같거나 크면 result를 갱신한다.
			powerSet(0, 0);
			// 3. 결과값을 출력한다.
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
	static void powerSet(int elementIdx, int heightSum) {
		if(elementIdx == size) {
			if(heightSum >= shelf) {
				result = Math.min(result, heightSum - shelf);
			}
			return;
		}

		powerSet(elementIdx + 1, heightSum + height[elementIdx]);
		powerSet(elementIdx + 1, heightSum);
	}
}
