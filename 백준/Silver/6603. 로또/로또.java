import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] selectList = new int[6];
	static int[] elementList;
	static int elementSize;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input;
		while(!(input = br.readLine()).equals("0")) {
			st = new StringTokenizer(input);
			elementSize = Integer.parseInt(st.nextToken());
			elementList = new int[elementSize];
			visited = new boolean[elementSize];

			for(int idx=0; idx<elementSize; idx++) {
				elementList[idx] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(elementList);
			combination(0, 0);
			sb.append('\n');
		}
		System.out.print(sb);
	}

	private static void combination(int depth, int at) {
		if(depth == 6) {
			for (int select : selectList) {
				sb.append(select).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int idx=at; idx<elementSize; idx++) {
			if(visited[idx]) continue;
			visited[idx] = true;
			selectList[depth] = elementList[idx];
			combination(depth+1, idx+1);
			visited[idx] = false;
		}
	}
}
