import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 	SWEA.5656 구슬깨기
 * 	
 * 	1. 구슬 개수와 맵의 크기, 맵 입력
 * 	2. 중복순열로 구슬 떨어뜨릴 위치와 순서 정해주기
 * 		2-1. [기저조건] 구슬 위치 모두 선택되면
 * 			2-1-1. 기존 맵을 깊은복사하여 새로운 copyMap 생성
 * 			2-1-2. 구슬 개수만큼 벽돌깨기와 밑으로 당기기 반복
 * 			2-1-3. 벽돌 개수 카운트하여 최소 벽돌 개수 갱신
 * 	3. 벽돌 깨기
 * 		3-1. 구슬이 벽돌과 닿는 위치 구하기
 * 			3-1-1. 구슬과 닿는 벽돌이 없으면 종료
 * 		3-2. 현재 구슬 위치와 벽돌 숫자를 큐에 삽입하고 벽돌 부시기
 * 			3-2-1. 가로 방향에 있는 벽돌 깨기
 * 				3-2-1-1. 맵의 범위를 벗어나거나 벽돌이 없으면 제외
 * 				3-2-1-2. 벽돌 숫자가 1보다 크면 주변 벽돌도 깨야하므로 큐에 삽입하고 벽돌 부수기
 * 			3-2-2. 세로 방향에 있는 벽돌 깨기
 * 				3-2-2-1. 맵의 범위를 벗어나거나 벽돌이 없으면 제외
 * 				3-2-2-2. 벽돌 숫자가 1보다 크면 주변 벽돌도 깨야하므로 큐에 삽입하고 벽돌 부수기
 * 	4. 벽돌 밑으로 당기기
 * 		4-1. 밑에있는 줄부터 벽돌이 있는 칸의 벽돌 숫자를 큐에 삽입 후 맵을 0으로 변경
 * 		4-2. 밑에있는 줄부터 큐에서 poll한 값으로 채워주기
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
			
			// 1. 구슬 개수와 맵의 크기, 맵 입력
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
			
			// 2. 중복순열로 구슬 떨어뜨릴 위치와 순서 정해주기
			dropCols = new int[beadCnt];
			minResult = Integer.MAX_VALUE;
			permutation(0);
			
			sb.append(minResult).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void permutation(int depth) {
		// 2-1. [기저조건] 구슬 위치 모두 선택되면
		if(depth == beadCnt) {
			// 2-1-1. 기존 맵을 깊은복사하여 새로운 copyMap 생성
			int[][] copyMap = getCopyMap();
			
			// 2-1-2. 구슬 개수만큼 벽돌깨기와 밑으로 당기기 반복
			for(int bead=0; bead<beadCnt; bead++) {
				brickOut(copyMap, dropCols[bead]); // 벽돌 깨기
				brickDown(copyMap); // 밑으로 당기기
			}
			
			// 2-1-3. 벽돌 개수 카운트하여 최소 벽돌 개수 갱신
			minResult = Math.min(minResult, getBrickCount(copyMap));
			return;
		}
		
		for(int col=0; col<colSize; col++) {
			dropCols[depth] = col;
			permutation(depth+1);
		}
	}

	// 3. 벽돌 깨기
	private static void brickOut(int[][] map, int dropCol) {
		// 3-1. 구슬이 벽돌과 닿는 위치 구하기
		int dropRow;
		for(dropRow=0; dropRow<rowSize; dropRow++) {
			if(map[dropRow][dropCol] != 0) break;
		}
		
		// 3-1-1. 구슬과 닿는 벽돌이 없으면 종료
		if(dropRow == rowSize) return;
		
		// 3-2. 현재 구슬 위치와 벽돌 숫자를 큐에 삽입하고 벽돌 부시기
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {dropRow, dropCol, map[dropRow][dropCol]});
		map[dropRow][dropCol] = 0;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int power = poll[2] - 1;
			
			// 3-2-1. 가로 방향에 있는 벽돌 깨기
			for(int col=poll[1]-power; col<=poll[1]+power; col++) {
				// 3-2-1-1. 맵의 범위를 벗어나거나 벽돌이 없으면 제외
				if(col < 0 || col >= colSize || map[poll[0]][col] == 0) continue;
				// 3-2-1-2. 벽돌 숫자가 1보다 크면 주변 벽돌도 깨야하므로 큐에 삽입하고 벽돌 부수기
				if(map[poll[0]][col] > 1) {
					queue.add(new int[] {poll[0], col, map[poll[0]][col]});
				}
				map[poll[0]][col] = 0;
			}
			
			// 3-2-2. 세로 방향에 있는 벽돌 깨기
			for(int row=poll[0]-power; row<=poll[0]+power; row++) {
				// 3-2-2-1. 맵의 범위를 벗어나거나 벽돌이 없으면 제외
				if(row < 0 || row >= rowSize) continue;
				// 3-2-2-2. 벽돌 숫자가 1보다 크면 주변 벽돌도 깨야하므로 큐에 삽입하고 벽돌 부수기
				if(map[row][poll[1]] > 1) {
					queue.add(new int[] {row, poll[1], map[row][poll[1]]});
				}
				map[row][poll[1]] = 0;
			}
		}
	}

	// 4. 벽돌 밑으로 당기기
	private static void brickDown(int[][] map) {
		for(int col=0; col<colSize; col++) {
			// 4-1. 밑에있는 줄부터 벽돌이 있는 칸의 벽돌 숫자를 큐에 삽입 후 맵을 0으로 변경
			Queue<Integer> queue = new ArrayDeque<>();
			for(int row=rowSize-1; row>=0; row--) {
				if(map[row][col] != 0) {
					queue.add(map[row][col]);
					map[row][col] = 0;
				}
			}
			
			// 4-2. 밑에있는 줄부터 큐에서 poll한 값으로 채워주기
			for(int row=rowSize-1; row>=0; row--) {
				if(queue.isEmpty()) break;
				map[row][col] = queue.poll();
			}
		}
	}

	private static int[][] getCopyMap() {
		int[][] copyMap = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			copyMap[row] = map[row].clone();
		}
		return copyMap;
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
}