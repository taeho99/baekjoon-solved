import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 임태호
 *
 * 1. n: 계산기 레지스터에 십진수 네자리 수(d1, d2, d3, d4)
 * 2-1. D: 레지스터=(2*n)%10000
 * 2-2. S: 레지스터=n-1 (if.n==0 then.레지스터=9999)
 * 2-3. L: 레지스터=(d2,d3,d4,d1)
 * 2-4. R: 레지스터=(d4,d1,d2,d3)
 * 3. 서로 다른 두 정수 A, B에 대해 A->B로 바꾸는 최소한의 명령을 출력
 */
public class Main {
	static char[] cmd = {'D', 'S', 'L', 'R'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(a, ""));
			
			while(!queue.isEmpty()) {
				Node poll = queue.poll();
				
				if(poll.num == b) {
					sb.append(poll.cmd).append('\n');
					break;
				}
				
				if(visited[poll.num]) {
					continue;
				}
				visited[poll.num] = true; 
				
				for(int i=0; i<4; i++) {
					int tmp = calc(cmd[i], poll.num);
					queue.add(new Node(tmp, poll.cmd + cmd[i]));
				}
			}
		}
		System.out.print(sb);
	}
	
	static int calc(char cmd, int num) {
		if(cmd == 'D') {
			return (2*num) % 10000;
		} else if(cmd == 'S') {
			if(num == 0) {
				return 9999;
			}
			return num - 1;
		} else if(cmd == 'L') {
			return (num % 1000) * 10 + num / 1000;
		} else {
			return (num % 10) * 1000 + num / 10;
		}
	}

	static class Node {
		int num;
		String cmd;
		
		public Node(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}
}
