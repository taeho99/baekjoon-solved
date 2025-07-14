import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int screenTarget = Integer.parseInt(br.readLine());

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[1001][1001];

		queue.add(new int[] {1, 0, 0});
		visited[1][0] = true;

		while(!queue.isEmpty()) {
			int[] poll = queue.poll();

			if (poll[0] == screenTarget) {
				System.out.println(poll[2]);
				return;
			}

			queue.add(new int[] {poll[0], poll[0], poll[2] + 1});
			visited[poll[0]][poll[0]] = true;
			if (poll[1] != 0  && poll[0] + poll[1] <= screenTarget && !visited[poll[0]+poll[1]][poll[1]]) {
				queue.add(new int[] {poll[0] + poll[1], poll[1], poll[2] + 1});
				visited[poll[0]+poll[1]][poll[1]] = true;
			}
			if (poll[0] >= 3 && !visited[poll[0]-1][poll[1]]) {
				queue.add(new int[] {poll[0] - 1, poll[1], poll[2] + 1});
				visited[poll[0]-1][poll[1]] = true;
			}
		}
	}
}
