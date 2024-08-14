import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ.11659 구간 합 구하기 4 
 *
 * 1. 수의 개수 size와 합을 구하는 횟수 cmd가 주어진다.
 * 2. 수를 입력받으면서 구간합 배열을 초기화한다.
 * 2-1. 현재 입력값 + 직전 구간합 값을 더해서 입력한다.
 * 3. 구간합 성질을 이용해 (마지막 위치까지 구간합 - 시작 위치 직전의 구간합) 값을 결과로 출력한다.
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1. 수의 개수 size와 합을 구하는 횟수 cmd가 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int cmd = Integer.parseInt(st.nextToken());
		
		int[] subTotal = new int[size + 1];
		st = new StringTokenizer(br.readLine());

		// 2. 수를 입력받으면서 구간합 배열을 초기화한다.
		for(int idx=1; idx<=size; idx++) {
			// 2-1. 현재 입력값 + 직전 구간합 값을 더해서 입력한다.
			subTotal[idx] = subTotal[idx-1] + Integer.parseInt(st.nextToken());
		}
		
		while(cmd-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 3. 구간합 성질을 이용해 (현재 위치까지 구간합 - 시작 위치 직전의 구간합) 값을 결과로 출력한다.
			sb.append(subTotal[end] - subTotal[start-1]).append('\n');
		}
		
		System.out.print(sb);
	}
}
