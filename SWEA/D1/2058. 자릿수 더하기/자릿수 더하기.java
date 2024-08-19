import java.util.Scanner;

/**
 * SWEA.2058 자릿수더하기 
 *
 * 1. 수(num)을 입력받는다.
 * 2. 나누기 연산을 통해 마지막 자릿수를 sum에 더해준다.
 * 		2-1. while문으로 num이 0이 될때까지 num을 10으로 나누어준다.
 * 3. sum 값을 출력한다.
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 수(num)을 입력받는다.
		int num = sc.nextInt();
		int sum = 0;
		while(num != 0) {
			// 2. 나누기 연산을 통해 마지막 자릿수를 sum에 더해준다.
			sum += num%10;
			// 2-1. while문으로 num이 0이 될때까지 num을 10으로 나누어준다.
			num /= 10;
		}
		// 3. sum 값을 출력한다.
		System.out.println(sum);
	}
}
