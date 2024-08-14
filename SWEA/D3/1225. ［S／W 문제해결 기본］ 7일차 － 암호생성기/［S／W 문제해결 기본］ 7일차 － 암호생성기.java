import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA.1225 암호생성기 
 *
 * 1. 테스트케이스 번호와 초기 암호를 큐에 입력받는다.
 * 2. 1사이클은 각 원소를 앞에서부터 1 감소, 2 감소, ... , 5 감소 이다.
 * 2-1. 큐의 앞에서 원소를 꺼내서 임시로 poll 변수에 저장한다.
 * 2-2. 큐에 추가되는 값이 0 이하인 경우 암호를 생성한 경우이다.
 * 	 2-2-1. isEnd = true로 바꿔주고 while문을 탈출하여 프로그램을 종료한다.
 * 2-3. 감소 값을 큐의 가장 뒤에 추가한다.
 * 3. 그 때의 원소 값을 출력한다. 큐의 앞 부분부터 꺼내서 출력하면 된다!
 */
public class Solution {
	static final int SIZE = 8;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			br.readLine(); // 테스트 케이스 번호 입력
			
			// 1. 테스트케이스 번호와 초기 암호를 큐에 입력받는다.
			Queue<Integer> queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<SIZE; idx++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			while(true) {
				boolean isEnd = false; // 종료 여부
				
				// 2. 1사이클은 각 원소를 앞에서부터 1 감소, 2 감소, ... , 5 감소 이다.
				for(int cnt=1; cnt<=5; cnt++) {
					// 2-1. 큐의 앞에서 원소를 꺼내서 임시로 poll 변수에 저장한다.
					int poll = queue.poll();
					
					// 2-2. 큐에 추가되는 값이 0 이하인 경우 암호를 생성한 경우이다.
					if(poll - cnt <= 0) {
						queue.add(0);
						// 2-2-1. isEnd = true로 바꿔주고 while문을 탈출하여 프로그램을 종료한다.
						isEnd = true;
						break;
					} 
					
					// 2-3. 감소 값을 큐의 가장 뒤에 추가한다.
					else {
						queue.add(poll - cnt);
					}
				}
				if(isEnd) break;
			}
			
			// 3. 그 때의 원소 값을 출력한다. 큐의 앞 부분부터 꺼내서 출력하면 된다!
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
