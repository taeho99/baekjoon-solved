import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 정수 num을 입력받는다.
 * 2. num이 2가 될 때까지 반복한다.
 * 		2-1. 만약 num이 완전제곱수이면 num = sqrt(num) 해주고 cnt를 1 증가시킨다.
 * 		2-2. 완전제곱수가 아니면 완전제곱수를 만들어주고 그 수만큼 cnt도 증가시킨다.
 * 3. 수행 횟수인 cnt를 출력한다.
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			// 1. 정수 num을 입력받는다.
			long num = Long.parseLong(br.readLine());
			int cnt = 0;
			// 2. num이 2가 될 때까지 반복한다.
			while(num != 2) {
				// 2-1. 만약 num이 완전제곱수이면 num = sqrt(num) 해주고 cnt를 1 증가시킨다.
				if((long)(Math.pow((long)Math.sqrt(num), 2)) == num) {
					num = (long)Math.sqrt(num);
					cnt++;
				} 
				// 2-2. 완전제곱수가 아니면 완전제곱수를 만들어주고 그 수만큼 cnt도 증가시킨다.
				else {
					long sqrt = (long)Math.sqrt(num);
					long tmp = (sqrt+1)*(sqrt+1) - num;
					num += tmp;
					cnt += tmp;
				}
			}
			// 3. 수행 횟수인 cnt를 출력한다.
			sb.append('#').append(tc).append(' ').append(cnt).append('\n');
		}
		System.out.print(sb);
	}
}
