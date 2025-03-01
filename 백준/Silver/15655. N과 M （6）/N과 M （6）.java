import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int elementCnt, selectCnt;
	static int[] elementList, selectList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		elementCnt = Integer.parseInt(st.nextToken());
		selectCnt = Integer.parseInt(st.nextToken());

		elementList = new int[elementCnt];
		selectList = new int[selectCnt];

		st = new StringTokenizer(br.readLine());
		for (int elementIdx = 0; elementIdx < elementCnt; elementIdx++) {
			elementList[elementIdx] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(elementList);

		combination(0, 0);
		System.out.print(sb);
	}

	private static void combination(int elementIdx, int selectIdx) {
		if (selectIdx == selectCnt) {
			for (int select : selectList) {
				sb.append(select).append(' ');
			}
			sb.append('\n');
			return;
		}

		if (elementIdx == elementCnt) {
			return;
		}

		selectList[selectIdx] = elementList[elementIdx];
		combination(elementIdx + 1, selectIdx + 1);
		selectList[selectIdx] = 0;
		combination(elementIdx + 1, selectIdx);
	}
}