import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[9][9];
	static List<int[]> emptyList = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int row=0; row<9; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<9; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == 0) {
					emptyList.add(new int[] {row, col});
				}
			}
		}

		backtrack(0);
		System.out.print(sb);
	}

	private static void backtrack(int depth) {
		if(sb.length() > 0) return;
		if(depth == emptyList.size()) {
			for (int[] row : map) {
				for (int n : row) {
					sb.append(n).append(' ');
				}
				sb.append('\n');
			}
			return;
		}

		int[] pos = emptyList.get(depth);
		for(int num=1; num<=9; num++) {
			if(isPossible(pos[0], pos[1], num)) {
				map[pos[0]][pos[1]] = num;
				backtrack(depth+1);
				map[pos[0]][pos[1]] = 0;
			}
		}
	}

	private static boolean isPossible(int row, int col, int num) {
		for(int c=0; c<9; c++) {
			if(map[row][c] == num) return false;
		}
		for(int r=0; r<9; r++) {
			if(map[r][col] == num) return false;
		}
		for(int r=(row/3)*3; r<((row/3)*3) + 3; r++) {
			for(int c=(col/3)*3; c<((col/3)*3) + 3; c++) {
				if(map[r][c] == num) return false;
			}
		}
		return true;
	}
}
