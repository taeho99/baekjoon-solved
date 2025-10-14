import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, opCnt, result = Integer.MAX_VALUE;
	static int[][] map, ops;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		opCnt = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		ops = new int[opCnt][3];
		for(int idx=0; idx<opCnt; idx++) {
			st = new StringTokenizer(br.readLine());
			ops[idx][0] = Integer.parseInt(st.nextToken()) - 1;
			ops[idx][1] = Integer.parseInt(st.nextToken()) - 1;
			ops[idx][2] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[opCnt];
		int[] order = new int[opCnt];
		permutation(0, order, visited);

		System.out.println(result);
	}

	private static void permutation(int depth, int[] order, boolean[] visited) {
		if(depth == opCnt) {
			int[][] copyMap = deepCopy();
			for (int idx : order) {
				simulation(copyMap, ops[idx]);
			}
			result = Math.min(result, getRowSum(copyMap));
			return;
		}

		for(int idx=0; idx<opCnt; idx++) {
			if(visited[idx]) continue;
			visited[idx] = true;
			order[depth] = idx;
			permutation(depth + 1, order, visited);
			visited[idx]= false;
		}
	}

	private static void simulation(int[][] copyMap, int[] op) {
		for(int layer=1; layer<=op[2]; layer++) {
			int top = op[0] - layer;
			int left = op[1] - layer;
			int bottom = op[0] + layer;
			int right = op[1] + layer;

			ArrayDeque<Integer> queue = new ArrayDeque<>();
			for(int col=left; col<=right; col++) queue.add(copyMap[top][col]);
			for(int row=top+1; row<=bottom-1; row++) queue.add(copyMap[row][right]);
			for(int col=right; col>=left; col--) queue.add(copyMap[bottom][col]);
			for(int row=bottom-1; row>=top+1; row--) queue.add(copyMap[row][left]);


			queue.addFirst(queue.pollLast());

			for(int col=left; col<=right; col++) copyMap[top][col] = queue.pollFirst();
			for(int row=top+1; row<bottom; row++) copyMap[row][right] = queue.pollFirst();
			for(int col=right; col>=left; col--) copyMap[bottom][col] = queue.pollFirst();
			for(int row=bottom-1; row>top; row--) copyMap[row][left] = queue.pollFirst();
		}
	}

	private static int[][] deepCopy() {
		int[][] copyMap = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				copyMap[row][col] = map[row][col];
			}
		}
		return copyMap;
	}

	private static int getRowSum(int[][] copyMap) {
		int minRowSum = Integer.MAX_VALUE;
		for(int row=0; row<rowSize; row++) {
			int rowSum = 0;
			for(int col=0; col<colSize; col++) {
				rowSum += copyMap[row][col];
			}
			minRowSum = Math.min(minRowSum, rowSum);
		}
		return minRowSum;
	}
}
