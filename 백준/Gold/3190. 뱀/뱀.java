import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author SSAFY
 *
 * 1. N*N 정사각 보드 위에 사과를 먹으면 길이가 늘어나는 뱀이 있다.
 * 2. 처음 뱀의 길이는 1이며 오른쪽을 향해 1초에 1씩 움직인다.
 * 3-1. 뱀 길이가 늘어나면 꼬리는 그대로, 머리가 다음칸으로 이동함
 * 3-2. 벽이나 자기 자신과 부딪히면 게임 끝
 * 3-3. 칸에 사과가 있다면, 그 칸의 사과가 없어지고 길이가 1 늘어남
 * 3-4. 칸에 사과가 없다면, 꼬리 위치한 칸을 비우고 이동한 칸에 머리를 둠
 * 4. 몇초에 게임이 끝날 것인가?
 */

public class Main {
	static int size, appleCount, directionCount;
	static int[][] appleMap;
	static HashMap<Integer, Character> direction;
	static int[] dRow = {0, 1, 0, -1};
	static int[] dCol = {1, 0, -1, 0};
	static ArrayDeque<int[]> snake;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//[입력] 보드 크기
		size = Integer.parseInt(br.readLine());
		appleMap = new int[size][size];
		
		//[입력] 사과 위치
		appleCount = Integer.parseInt(br.readLine());
		for(int idx=0; idx<appleCount; idx++) {
			st = new StringTokenizer(br.readLine());
			int curRow = Integer.parseInt(st.nextToken()) - 1;
			int curCol = Integer.parseInt(st.nextToken()) - 1;
			appleMap[curRow][curCol] = 1;
		}
		
		//[입력] 방향 변환 정보
		direction = new HashMap<>();
		directionCount = Integer.parseInt(br.readLine());
		for(int idx=0; idx<directionCount; idx++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			direction.put(sec, dir);
		}
		
		//뱀은 앞뒤가 길어지고 짧아지고 하므로 Deque 사용
		snake = new ArrayDeque<>();
		//경과 시간, 현재 방향, 현재 행, 현재 열
		int time = 0, curDir = 0, curRow = 0, curCol = 0;
		//뱀의 첫 위치(왼쪽 상단)을 Deque의 첫 위치(머리)에 넣음
		snake.addFirst(new int[] {curRow, curCol});
		
		while(true) {
			time++;
			int nextRow = curRow + dRow[curDir];
			int nextCol = curCol + dCol[curDir];
			
			//다음 위치가 종료 조건이라면 while 탈출
			if(isFinish(nextRow, nextCol)) {
				break;
			}
			
			//if. 다음 위치에 사과가 있다면, 뱀의 머리를 증가시키고 appleMap에서 사과를 없앰
			//else. 다음 위치에 사과가 없다면, 뱀의 머리를 증가시키고 꼬리를 제거함
			if(appleMap[nextRow][nextCol] == 1) {
				snake.addFirst(new int[] {nextRow, nextCol});
				appleMap[nextRow][nextCol] = 0;
			} else {
				snake.addFirst(new int[] {nextRow, nextCol});
				snake.removeLast();
			}
			
			//현재 위치 업데이트
			curRow = nextRow;
			curCol = nextCol;
			
			//방향 전환할 시점이면 방향 변환
			if(direction.containsKey(time)) {
				if(direction.get(time) == 'L') {
					curDir = (curDir + 3) % 4;
				} else {
					curDir = (curDir + 1) % 4;
				}
			}
		}
		System.out.println(time);
	}

	static boolean isFinish(int nextRow, int nextCol) {
		// 벽에 부딪힌 경우 게임 종료
		if(nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size) {
			return true;
		}
		
		//Deque에 다음 위치와 겹친다면 뱀의 머리가 몸에 닿은 경우이므로 게임 종료
		for(int[] pos : snake) {
			if(nextRow == pos[0] && nextCol == pos[1])
				return true;
		}
		
		return false;
	}

}
