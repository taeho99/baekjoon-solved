import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long original = Integer.parseInt(st.nextToken());
		long target = Integer.parseInt(st.nextToken());

		System.out.println(bfs(original, target));

	}

	private static long bfs(long original, long target) {
		HashSet<Long> visited = new HashSet<>();
		Queue<long[]> queue = new LinkedList<>();

		visited.add(original);
		queue.add(new long[] {original, 0});

		while(!queue.isEmpty()) {
			long[] poll = queue.poll();

			if (poll[0] == target) {
				return poll[1] + 1;
			}

			long next1 = poll[0] * 2L;
			long next2 = poll[0] * 10L + 1L;
			if (!visited.contains(next1) && next1 <= target) {
				visited.add(next1);
				queue.add(new long[] {next1, poll[1] + 1});
			}
			if (!visited.contains(next2) && next2 <= target) {
				visited.add(next2);
				queue.add(new long[] {next2, poll[1] + 1});
			}
		}
		return -1;
	}
}