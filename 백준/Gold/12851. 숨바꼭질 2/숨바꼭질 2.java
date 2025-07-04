import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int original = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int minTime = Integer.MAX_VALUE;

		Queue<int[]> queue = new LinkedList<>();
		int[] visited = new int[100_001];

		queue.add(new int[] {original, 0});

		int cnt = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();

			if (poll[0] == target) {
				if (minTime == Integer.MAX_VALUE) {
					minTime = poll[1];
				}
				if (minTime == poll[1]) {
					cnt++;
				}
				continue;
			}

			int[] next = {poll[0] - 1, poll[0] + 1, poll[0] * 2};

			for(int idx=0; idx<3; idx++) {
				if (next[idx] < 0 || next[idx] > 100_000) continue;
				if (visited[next[idx]] == 0 || visited[next[idx]] == poll[1] + 1) {
					queue.add(new int[] {next[idx], poll[1] + 1});
					visited[next[idx]] = poll[1] + 1;
				}
			}
		}

		System.out.println(minTime);
		System.out.println(cnt);
	}
}