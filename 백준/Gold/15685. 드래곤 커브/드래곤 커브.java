import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static boolean[][] map = new boolean[101][101];
	static int[] dRow = {0, -1, 0, 1};
	static int[] dCol = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = Integer.parseInt(br.readLine());

		for(int idx=0; idx<size; idx++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());

			List<Integer> dirList = new ArrayList<>();
			dirList.add(dir);
			while(gen-- > 0) {
				for(int dirListIdx = dirList.size() - 1; dirListIdx >= 0; dirListIdx--) {
					dirList.add((dirList.get(dirListIdx) + 1)%4);
				}
			}

			map[row][col] = true;
			for (int nextDir : dirList) {
				row += dRow[nextDir];
				col += dCol[nextDir];
				map[row][col] = true;
			}
		}


		int result = 0;
		for(int row=0; row<100; row++) {
			for(int col=0; col<100; col++) {
				if(map[row][col] && map[row][col+1] && map[row+1][col] && map[row+1][col+1])
					result++;
			}
		}
		System.out.println(result);
	}
}
