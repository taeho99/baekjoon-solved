import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int elementCnt, selectCnt;
	static int[] selectList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		elementCnt = Integer.parseInt(st.nextToken());
		selectCnt = Integer.parseInt(st.nextToken());
		selectList = new int[selectCnt];

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

		for(int elementIdx=1; elementIdx<=elementCnt; elementIdx++) {
			selectList[selectIdx] = elementIdx;
			permutation(selectIdx + 1);
		}
	}
}