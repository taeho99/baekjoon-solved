import java.io.IOException;
import java.util.Scanner;

/**
 * SWEA.2072 홀수만 더하기
 * 
 * 1. 10개의 입력이 주어진다.
 * 2. 입력이 홀수인 경우만 sum에 추가한다.
 * 3. sum을 출력한다.
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int sum = 0;
			// 1. 10개의 입력이 주어진다.
			for(int idx=0; idx<10; idx++) {
				int tmp = sc.nextInt();
				// 2. 입력이 홀수인 경우만 sum에 추가한다.
				if(tmp%2 == 1) sum += tmp;
			}
			// 3. sum을 출력한다.
			System.out.println("#" + tc + " " + sum);
		}
	}
}
