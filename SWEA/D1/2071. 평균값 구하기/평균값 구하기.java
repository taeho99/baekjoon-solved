import java.io.IOException;
import java.util.Scanner;

/**
 * SWEA.2071 평균값 구하기
 * 
 * 1. 10개의 입력이 주어진다.
 * 2. 입력을 sum에 추가한다.
 * 3. sum을 10으로 나누어 반올림 후 출력한다.
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int sum = 0;
			// 1. 10개의 입력이 주어진다.
			for(int idx=0; idx<10; idx++) {
				// 2. 입력을 sum에 추가한다.
				sum += sc.nextInt();
			}
			// 3. sum을 10으로 나누어 반올림 후 출력한다.
			System.out.println("#" + tc + " " + Math.round(sum / 10.0));
		}
	}
}