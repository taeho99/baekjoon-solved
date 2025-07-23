import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size, maxResult = 0;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		for(int row=0; row<size; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<size; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(0);
		System.out.println(maxResult);
	}

	static void simulation(int depth) {
		if (depth == 10) {
			for(int row=0; row<size; row++) {
				for(int col=0; col<size; col++) {
					maxResult = Math.max(maxResult, map[row][col]);
				}
			}
			return;
		}

		int[][] origin = new int[size][size];
		for(int row=0; row<size; row++) {
			origin[row] = map[row].clone();
		}

		for(int dir=0; dir<4; dir++) {
			move(dir);
			simulation(depth+1);
			for(int row=0; row<size; row++) {
				map[row] = origin[row].clone();
			}
		}
	}

	static void move(int dir) {
		if (dir == 0) { // 상
			for(int col=0; col<size; col++) {
				int idx = 0, block = 0;
				for(int row=0; row<size; row++) {
					if (map[row][col] == 0) continue;
					if(map[row][col] == block) {
						map[idx-1][col] = block * 2;
						block = 0;
						map[row][col] = 0;
					} else {
						block = map[row][col];
						map[row][col] = 0;
						map[idx++][col] = block;
					}
				}
			}
		} else if (dir == 1) { // 우
			for(int row=0; row<size; row++) {
				int idx = size-1, block = 0;
				for(int col=size-1; col>=0; col--) {
					if (map[row][col] == 0) continue;
					if(map[row][col] == block) {
						map[row][idx+1] = block * 2;
						block = 0;
						map[row][col] = 0;
					} else {
						block = map[row][col];
						map[row][col] = 0;
						map[row][idx--] = block;
					}
				}
			}
		} else if (dir == 2) { // 하
			for(int col=0; col<size; col++) {
				int idx = size-1, block = 0;
				for(int row=size-1; row>=0; row--) {
					if (map[row][col] == 0) continue;
					if(map[row][col] == block) {
						map[idx+1][col] = block * 2;
						block = 0;
						map[row][col] = 0;
					} else {
						block = map[row][col];
						map[row][col] = 0;
						map[idx--][col] = block;
					}
				}
			}
		} else { // 좌
			for(int row=0; row<size; row++) {
				int idx = 0, block = 0;
				for(int col=0; col<size; col++) {
					if (map[row][col] == 0) continue;
					if(map[row][col] == block) {
						map[row][idx-1] = block * 2;
						block = 0;
						map[row][col] = 0;
					} else {
						block = map[row][col];
						map[row][col] = 0;
						map[row][idx++] = block;
					}
				}
			}
		}
	}
}
