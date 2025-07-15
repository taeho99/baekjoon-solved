import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());


		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[100_001];
		int[] parent = new int[100_001];
		Arrays.fill(parent, -1);

		queue.add(new int[] {start, 0});
		visited[start] = true;

		while(!queue.isEmpty()) {
			int[] poll = queue.poll();

			if (poll[0] == end) {
				System.out.println(poll[1]);
				break;
			}

			int[] next = {poll[0] - 1, poll[0] + 1, poll[0] * 2};
			for(int idx=0; idx<3; idx++) {
				if (next[idx] < 0 || next[idx] > 100_000 || visited[next[idx]]) continue;
				queue.add(new int[] {next[idx], poll[1] + 1});
				visited[next[idx]] = true;
				parent[next[idx]] = poll[0];
			}
		}

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		int now = parent[end];
		while(now != -1) {
			stack.push(now);
			now = parent[now];
		}

		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(' ');
		}
		System.out.print(sb);
	}
}
