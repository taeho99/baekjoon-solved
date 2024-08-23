import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  SWEA.1873 상호의배틀필드
 *  
 *  1. 맵의 크기와 맵 데이터를 입력받는다.
 *  	1-1. 현재 탱크 위치와 방향을 저장한다.
 *  2. 사용자가 입력에 따라 동작을 실행한다.
 *  	2-1. U,D,L,R: move()를 실행한다. 파라미터로 방향 인덱스를 넣어준다.
 *  	2-2. S: shoot()를 실행한다.
 *  3. 탱크의 방향을 바꾸고 이동할 수 있으면 그 방향으로 한 칸 이동한다. 
 *  	3-1. 현재 탱크의 방향과 맵에서의 방향을 업데이트 해준다.
 *  	3-2. 맵의 범위 내에 있으면서 평지이면 맵에서 탱크를 이동시키고 현재 탱크 위치를 업데이트한다.
 *  4. 포탄을 발사한다.
 *  	4-1. 탱크의 방향으로 포탄을 한 칸 발사한다.
 *  	4-2. 포탄이 맵의 범위 내에 있으면 한 칸씩 계속 이동시키며 발사한다.
 *  		4-2-1. 벽돌 벽을 만나면 맵에서 벽을 평지로 바꾸고 중지한다.
 *  		4-2-2. 강철 벽을 만나면 중지한다.
 *  5. 최종 맵을 출력한다.
 */
public class Solution {
	static int rowSize, colSize;
	static char[][] map;
	static int[] tank;
	static char[] direction = {'^','v','<','>'};
	//                    U  D  L  R
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 맵의 크기와 맵 데이터를 입력받는다.
			st = new StringTokenizer(br.readLine());
			rowSize = Integer.parseInt(st.nextToken());
			colSize = Integer.parseInt(st.nextToken());
			
			tank = new int[3]; // {row, col, dir}
			map = new char[rowSize][colSize];
			for(int row=0; row<rowSize; row++) {
				String tmp = br.readLine();
				for(int col=0; col<colSize; col++) {
					map[row][col] = tmp.charAt(col);
					
					// 1-1. 현재 탱크 위치와 방향을 저장한다.
					for(int dir=0; dir<4; dir++) {
						if(map[row][col] == direction[dir]) {
							tank[0] = row;
							tank[1] = col;
							tank[2] = dir;
						}
					}
				}
			}
			
			// 2. 사용자가 입력에 따라 동작을 실행한다.
			int cmdCnt = Integer.parseInt(br.readLine());
			String commands = br.readLine();
			for (char cmd : commands.toCharArray()) {
				switch(cmd) {
					// 2-1. U,D,L,R: move()를 실행한다. 파라미터로 방향 인덱스를 넣어준다.
					case 'U':
						move(0);
						break;
					case 'D':
						move(1);
						break;
					case 'L':
						move(2);
						break;
					case 'R':
						move(3);
						break;
					// 2-2. S: shoot()를 실행한다.
					case 'S':
						shoot();
						break;
				}
			}
			
			// 5. 최종 맵을 출력한다.
			printMap();
		}
		System.out.print(sb);
	}

	// 3. 탱크의 방향을 바꾸고 이동할 수 있으면 그 방향으로 한 칸 이동한다. 
	static void move(int dir) {
		// 3-1. 현재 탱크의 방향과 맵에서의 방향을 업데이트 해준다.
		map[tank[0]][tank[1]] = direction[dir];
		tank[2] = dir;
		
		int nextRow = tank[0] + dRow[dir];
		int nextCol = tank[1] + dCol[dir];
		
		// 다음 위치가 범위를 벗어나거나 평지(.)가 아닌 경우 return
		if(nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize 
				|| map[nextRow][nextCol] != '.') return;
		
		// 3-2. 맵의 범위 내에 있으면서 평지이면 맵에서 탱크를 이동시키고 현재 탱크 위치를 업데이트한다.
		map[tank[0]][tank[1]] = '.'; // 기존 자리를 평지로
		map[nextRow][nextCol] = direction[dir]; // 다음 위치를 탱크로
		tank[0] = nextRow;
		tank[1] = nextCol;
	}
	
	// 4. 포탄을 발사한다.
	static void shoot() {
		int dir = tank[2];
		// 4-1. 탱크의 방향으로 포탄을 한 칸 발사한다.
		int[] bullet = {tank[0] + dRow[dir], tank[1] + dCol[dir]};
		
		// 4-2. 포탄이 맵의 범위 내에 있으면 한 칸씩 계속 이동시키며 발사한다.
		while(0 <= bullet[0] && bullet[0] < rowSize && 0 <= bullet[1] && bullet[1] < colSize) {
			// 4-2-1. 벽돌 벽을 만나면 맵에서 벽을 평지로 바꾸고 중지한다.
			if(map[bullet[0]][bullet[1]] == '*') {
				map[bullet[0]][bullet[1]] = '.';
				return;
			} 
			// 4-2-2. 강철 벽을 만나면 중지한다.
			else if(map[bullet[0]][bullet[1]] == '#') {
				return;
			}
			bullet[0] += dRow[dir];
			bullet[1] += dCol[dir];
		}
	}

	static void printMap() {
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				sb.append(map[row][col]);
			}
			sb.append('\n');
		}
	}
}