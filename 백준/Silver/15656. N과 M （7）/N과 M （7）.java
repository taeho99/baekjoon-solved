import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int elementSize, selectSize;
	static int[] elementList, selectList;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		elementSize = Integer.parseInt(st.nextToken());
		selectSize = Integer.parseInt(st.nextToken());

		elementList = new int[elementSize];
		selectList = new int[selectSize];
		visited = new boolean[elementSize];
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<elementSize; idx++) {
			elementList[idx] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(elementList);
		dfs(0);
		System.out.print(sb);
	}

	private static void dfs(int depth) {
		if(depth == selectSize) {
			for (int select : selectList) {
				sb.append(select).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int idx=0; idx<elementSize; idx++) {
			selectList[depth] = elementList[idx];
			dfs(depth + 1);
		}
	}
}
