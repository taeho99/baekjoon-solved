import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = {-1, 0, 1, 0};
	static int[] dCol = {0, 1, 0, -1};
	static int rowSize, colSize, minResult = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> cctvList = new ArrayList<>();
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());

		map = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if (map[row][col] == 6) {
					map[row][col] = -1;
				} else if (1 <= map[row][col]) {
					cctvList.add(new int[] {row, col, map[row][col]});
					set.add(row*colSize + col);
					map[row][col] = 0;
				}
			}
		}

		combination(0);
		System.out.println(minResult);
	}

	private static void combination(int depth) {
		if(minResult == 0) return;

		if(depth == cctvList.size()) {
			minResult = Math.min(minResult, getZeroArea());
			return;
		}

		int[] cctv = cctvList.get(depth);
		if (cctv[2] == 1) {
			for(int dir=0; dir<4; dir++) {
				monitor(cctv[0], cctv[1], dir, 1);
				combination(depth+1);
				monitor(cctv[0], cctv[1], dir, -1);
			}
		} else if (cctv[2] == 2) {
			for(int dir=0; dir<2; dir++) {
				monitor(cctv[0], cctv[1], dir, 1);
				monitor(cctv[0], cctv[1], dir+2, 1);
				combination(depth+1);
				monitor(cctv[0], cctv[1], dir, -1);
				monitor(cctv[0], cctv[1], dir+2, -1);
			}
		} else if (cctv[2] == 3) {
			for(int dir=0; dir<4; dir++) {
				monitor(cctv[0], cctv[1], dir, 1);
				monitor(cctv[0], cctv[1], (dir+1)%4, 1);
				combination(depth+1);
				monitor(cctv[0], cctv[1], dir, -1);
				monitor(cctv[0], cctv[1], (dir+1)%4, -1);
			}
		} else if (cctv[2] == 4) {
			for(int dir=0; dir<4; dir++) {
				monitor(cctv[0], cctv[1], dir, 1);
				monitor(cctv[0], cctv[1], (dir+1)%4, 1);
				monitor(cctv[0], cctv[1], (dir+2)%4, 1);
				combination(depth+1);
				monitor(cctv[0], cctv[1], dir, -1);
				monitor(cctv[0], cctv[1], (dir+1)%4, -1);
				monitor(cctv[0], cctv[1], (dir+2)%4, -1);
			}
		} else {
			for(int dir=0; dir<4; dir++) {
				monitor(cctv[0], cctv[1], dir, 1);
			}
			combination(depth+1);
			for(int dir=0; dir<4; dir++) {
				monitor(cctv[0], cctv[1], dir, -1);
			}
		}
	}

	private static int getZeroArea() {
		int cnt = 0;
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if(map[row][col] == 0 && !set.contains(row*colSize + col)) cnt++;
			}
		}
		return cnt;
	}

	private static void monitor(int r, int c, int dir, int delta) {
		int nr = r + dRow[dir], nc = c + dCol[dir];
		while (0 <= nr && nr < rowSize && 0 <= nc && nc < colSize && map[nr][nc] != -1) {
			map[nr][nc] += delta;
			nr += dRow[dir];
			nc += dCol[dir];
		}
	}
}
