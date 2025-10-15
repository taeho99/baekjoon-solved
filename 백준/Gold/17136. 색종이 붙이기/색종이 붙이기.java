import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result = Integer.MAX_VALUE, areaCnt = 0;
	static int[][] map = new int[10][10];
	static int[] paper = {0, 5, 5, 5, 5, 5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int row=0; row<10; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<10; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == 1) areaCnt++;
			}
		}

		dfs(0, 0, areaCnt);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void dfs(int pos, int usedPaper, int remain) {
		if(usedPaper >= result) return;
		if(remain >= getMaxCover()) return;
		if(remain == 0) {
			result = Math.min(result, usedPaper);
			return;
		}

		while(pos < 100 && map[pos/10][pos%10] == 0) pos++;
		if(pos == 100) {
			result = Math.min(result, usedPaper);
			return;
		}
		int row = pos/10;
		int col = pos%10;

		for(int size=5; size>=1; size--) {
			if(paper[size] == 0) continue;
			if(!canPlace(row, col, size)) continue;
			paper[size]--;
			paperUpDown(row, col, size, 0);
			dfs(pos+1, usedPaper + 1, remain - size*size);
			paper[size]++;
			paperUpDown(row, col, size, 1);
		}
	}

	private static boolean canPlace(int row, int col, int size) {
		if (row + size > 10 || col + size > 10) return false;
		for(int r=row; r<row+size; r++) {
			for(int c=col; c<col+size; c++) {
				if(map[r][c] == 0) return false;
			}
		}
		return true;
	}

	private static void paperUpDown(int row, int col, int size, int offSet) {
		for(int r=row; r<row+size; r++) {
			for(int c=col; c<col+size; c++) {
				map[r][c] = offSet;
			}
		}
	}

	private static int getMaxCover() {
		int cover = 0;
		for (int size = 1; size <= 5; size++) {
			cover += paper[size] * size * size;
		}
		return cover;
	}
}
