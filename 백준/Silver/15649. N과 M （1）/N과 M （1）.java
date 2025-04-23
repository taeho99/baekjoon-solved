import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int elementCnt, selectCnt;
	static int[] elementList, selectList;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		elementCnt = Integer.parseInt(st.nextToken());
		selectCnt = Integer.parseInt(st.nextToken());
		elementList = new int[elementCnt];
		selectList = new int[selectCnt];
		visited = new boolean[elementCnt];

		for(int elementIdx=0; elementIdx<elementCnt; elementIdx++) {
			elementList[elementIdx] = elementIdx + 1;
		}

		permutation(0);

		System.out.print(sb);
	}

	private static void permutation(int selectIdx) {
		if (selectIdx == selectCnt) {
			for (int select : selectList) {
				sb.append(select).append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int elementIdx=0; elementIdx<elementCnt; elementIdx++) {
			if (visited[elementIdx]) continue;
			visited[elementIdx] = true;
			selectList[selectIdx] = elementList[elementIdx];
			permutation(selectIdx + 1);
			visited[elementIdx] = false;
		}
	}
}