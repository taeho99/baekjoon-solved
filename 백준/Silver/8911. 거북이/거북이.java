import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dRow = {-1, 0, 1, 0};
	static int[] dCol = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			char[] cmds = br.readLine().toCharArray();
			int nowRow = 0, maxRow = 0, minRow = 0;
			int nowCol = 0, maxCol = 0, minCol = 0;
			int nowDir = 0;

			for (char cmd : cmds) {
				if (cmd == 'F') {
					nowRow += dRow[nowDir];
					nowCol += dCol[nowDir];
					maxRow = Math.max(maxRow, nowRow);
					minRow = Math.min(minRow, nowRow);
					maxCol = Math.max(maxCol, nowCol);
					minCol = Math.min(minCol, nowCol);
				} else if (cmd == 'B') {
					int tmpDir = (nowDir + 2) % 4;
					nowRow += dRow[tmpDir];
					nowCol += dCol[tmpDir];
					maxRow = Math.max(maxRow, nowRow);
					minRow = Math.min(minRow, nowRow);
					maxCol = Math.max(maxCol, nowCol);
					minCol = Math.min(minCol, nowCol);
				} else if (cmd == 'L') {
					nowDir = (nowDir + 3) % 4;
				} else {
					nowDir = (nowDir + 1) % 4;
				}
			}

			sb.append((maxRow - minRow) * (maxCol - minCol)).append('\n');
		}
		System.out.print(sb);
	}
}
