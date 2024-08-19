import java.util.Scanner;

/**
 * SWEA.2068 최대수구하기 
 *
 * 1. 수를 10개 입력받는다.
 * 2. max 값이 입력된 수보다 작으면 갱신한다.
 * 3. max 값을 출력한다.
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int max = 0;
			// 1. 수를 10개 입력받는다.
			for(int idx=0; idx<10; idx++) {
				// 2. max 값이 입력된 수보다 작으면 갱신한다.
				max = Math.max(max, sc.nextInt());
			}
			// 3. max 값을 출력한다.
			System.out.println("#" + tc + " " + max);
		}
	}
}
