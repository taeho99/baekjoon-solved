import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 	SWEA.5656 구슬깨기
 * 	
 * 	1. 구슬 떨어뜨릴 위치와 순서 정하기
 * 		1-1. n개중 w개 중복허용 순서있게 뽑기 -> 중복순열
 * 	2. 위에서 구슬 떨어뜨리기
 * 		2-1. 사방으로 (숫자-1)칸만큼 퍼뜨리기
 * 		2-2. 영향받은 모든 벽돌들도 다 터뜨려주기 -> BFS
 * 	3. 벽돌 모두 깼으면 0인 칸들 밑으로 끌어내리기
 * 	4. 구슬 다 떨어뜨렸으면 잔여 블럭개수 세기
 */
public class Solution {
	static int rowSize, colSize, beadCnt, minResult;
	static int[] dropCols;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			beadCnt = Integer.parseInt(st.nextToken());
			colSize = Integer.parseInt(st.nextToken());
			rowSize = Integer.parseInt(st.nextToken());
			
			map = new int[rowSize][colSize];
			for(int row=0; row<rowSize; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<colSize; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			dropCols = new int[beadCnt];
			minResult = Integer.MAX_VALUE;
			permutation(0);
			
			sb.append(minResult).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void permutation(int depth) {
		if(depth == beadCnt) {
			int[][] copyMap = getCopyMap();
			for(int bead=0; bead<beadCnt; bead++) {
				// 벽돌 깨기
				breakOut(copyMap, dropCols[bead]);
				// 밑으로 땡기기
				brickDown(copyMap);
			}
			
			minResult = Math.min(minResult, getBrickCount(copyMap));
			return;
		}
		
		for(int col=0; col<colSize; col++) {
			dropCols[depth] = col;
			permutation(depth+1);
		}
	}

	private static int getBrickCount(int[][] map) {
		int cnt = 0;
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if(map[row][col] != 0) cnt++;
			}
		}
		return cnt;
	}

	private static int[][] getCopyMap() {
		int[][] copyMap = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			copyMap[row] = map[row].clone();
		}
		return copyMap;
	}

	private static void breakOut(int[][] map, int dropCol) {
		int dropRow;
		for(dropRow=0; dropRow<rowSize; dropRow++) {
			if(map[dropRow][dropCol] != 0) break;
		}
		
		if(dropRow == rowSize) return;
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {dropRow, dropCol, map[dropRow][dropCol]});
		map[dropRow][dropCol] = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int power = poll[2] - 1;
			
			// 가로방향 깨기
			for(int col=poll[1]-power; col<=poll[1]+power; col++) {
				if(col < 0 || col >= colSize || map[poll[0]][col] == 0) continue;
				if(map[poll[0]][col] > 1) {
					queue.add(new int[] {poll[0], col, map[poll[0]][col]});
				}
				map[poll[0]][col] = 0;
			}
			
			// 세로방향 깨기
			for(int row=poll[0]-power; row<=poll[0]+power; row++) {
				if(row < 0 || row >= rowSize) continue;
				if(map[row][poll[1]] > 1) {
					queue.add(new int[] {row, poll[1], map[row][poll[1]]});
				}
				map[row][poll[1]] = 0;
			}
		}
	}

	private static void brickDown(int[][] map) {
		for(int col=0; col<colSize; col++) {
			Queue<Integer> queue = new ArrayDeque<>();
			for(int row=rowSize-1; row>=0; row--) {
				if(map[row][col] != 0) {
					queue.add(map[row][col]);
					map[row][col] = 0;
				}
			}
			
			for(int row=rowSize-1; row>=0; row--) {
				if(queue.isEmpty()) break;
				map[row][col] = queue.poll();
			}
		}
	}

}