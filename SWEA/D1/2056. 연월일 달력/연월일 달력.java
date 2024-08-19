import java.util.Scanner;

/**
 * SWEA.2056 연월일달력
 *
 * 1. 날짜를 입력받아 나누기 연산과 나머지 연산으로 year, month, day를 구한다.
 * 2. 년도는 0000을 제외하면 모두 유효하다.
 * 3. 달은 1~12 사이의 값이면 유효하다.
 * 4. 일은 월에 따라 다른데 달마다 마지막 날을 배열에 넣어 그 배열과 현재 일을 비교하여 유효한지 확인한다.
 * 5. 3가지 모두 유효하다면 형식에 맞춰 출력한다.
 */
public class Solution {
	static int[] maxDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			System.out.print("#" + tc + " ");
			
			// 1. 날짜를 입력받아 나누기 연산과 나머지 연산으로 year, month, day를 구한다.
			int date = sc.nextInt();
			int day = date%100;
			date /= 100;
			int month = date%100;
			date /= 100;
			int year = date;
			
			// 2. 년도는 0000을 제외하면 모두 유효하다.
			// 3. 달은 1~12 사이의 값이면 유효하다.
			// 4. 일은 월에 따라 다른데 달마다 마지막 날을 배열에 넣어 그 배열과 현재 일을 비교하여 유효한지 확인한다.
			if(year != 0 
				&& 1 <= month && month <= 12 
				&& 1 <= day && day <= maxDay[month]) {
				// 5. 3가지 모두 유효하다면 형식에 맞춰 출력한다.
				System.out.printf("%04d/%02d/%02d\n", year, month, day);
			} else {
				System.out.println("-1");
			}
			
		}
	}
}
