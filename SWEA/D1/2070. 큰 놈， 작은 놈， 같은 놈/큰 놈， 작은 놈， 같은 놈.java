import java.util.Scanner;

/**
 * SWEA.2070 큰놈,작은놈,같은놈
 *
 * 1. 두 수 A, B를 입력받는다.
 * 2-1. A>B인 경우 '>' 출력
 * 2-2. A==B인 경우 '=' 출력
 * 2-3. A<B인 경우 '<' 출력
 */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 1. 두 수 A, B를 입력받는다.
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.print("#" + tc + " ");
			// 2-1. A>B인 경우 '>' 출력
			if(A < B) System.out.println("<");
			// 2-2. A==B인 경우 '=' 출력
			else if(A == B) System.out.println("=");
			// 2-3. A<B인 경우 '<' 출력
			else System.out.println(">");
		}
	}
}
