import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	BOJ.16935 배열돌리기3
 * 
 *	1. 맵의 크기와 연산 횟수, 맵 데이터, 연산 종류를 입력받는다.
 *	2. 연산 횟수만큼 연산을 한다. 입력된 연산 종류에 따라 각 메서드를 실행한다. 5,6번 연산을 위해 rowHalf, colHalf는 미리 저장해놓는다.
 *	3. 연산 하기 (연산 결과는 tmp 배열이 임시로 넣고 다시 map과 연결해준다.)
 *		3-1. 상하반전: col은 유지하고 row를 반대로 탐색한다. col 데이터는 변하지 않기 때문에 단일 for문으로 가능하다.
 *		3-2. 좌우반전: row는 유지하고 col을 반대로 탐색한다.
 *		3-3. 90도회전: row와 col이 바뀌기 때문에 rowSize와 colSize를 서로 바꿔 tmp 배열을 만든다.
 *			3-3-1. row와 col을 반대로 하여 tmp 배열을 채워준다.
 *		3-4. 270도회전: row와 col이 바뀌기 때문에 rowSize와 colSize를 서로 바꿔 tmp 배열을 만든다.
 *			3-4-1. row와 col을 반대로 하여 tmp 배열을 채워준다.
 *		3-5. 시계방향 그룹옮기기: moveGroup(fromRow, fromCol, toRow, toCol) 4번 이용하여 tmp 배열로 halfSize만큼 옮겨준다.
 *		3-6. 반시계방향 그룹옮기기: moveGroup(fromRow, fromCol, toRow, toCol) 4번 이용하여 tmp 배열로 halfSize만큼 옮겨준다.
 *	4. 모든 연산이 끝났으면 맵 출력하기
 */
public class Main {
	static int rowSize, colSize, rowHalf, colHalf;
	static int[][] map, tmp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 맵의 크기와 연산 횟수, 맵 데이터, 연산 종류를 입력받는다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		int cmdCnt = Integer.parseInt(st.nextToken());
		map = new int[rowSize][colSize];
		
		for(int row=0; row<rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2. 연산 횟수만큼 연산을 한다. 입력된 연산 종류에 따라 각 메서드를 실행한다. 5,6번 연산을 위해 rowHalf, colHalf는 미리 저장해놓는다.
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<cmdCnt; idx++) {
			int cmd = Integer.parseInt(st.nextToken());
			rowHalf = rowSize/2;
			colHalf = colSize/2;
			
			// 3. 연산 하기 (연산 결과는 tmp 배열이 임시로 넣고 다시 map과 연결해준다.)
			switch(cmd) {
				case 1:
					flipVertical();
				break;
				case 2:
					flipHorizontal();
				break;
				case 3:
					rotate90();
				break;
				case 4:
					rotate270();
				break;
				case 5:
					command5();
				break;
				case 6:
					command6();
				break;
			}
		}
		// 4. 모든 연산이 끝났으면 맵 출력하기
		printMap();
		System.out.print(sb);
	}

	// 3-1. 상하반전: col은 유지하고 row를 반대로 탐색한다. col 데이터는 변하지 않기 때문에 단일 for문으로 가능하다.
	private static void flipVertical() {
		tmp = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			// 3-3-1. row와 col을 반대로 하여 tmp 배열을 채워준다.
			tmp[rowSize-1-row] = map[row];
		}
		map = tmp;
	}
	
	// 3-2. 좌우반전: row는 유지하고 col을 반대로 탐색한다.
	private static void flipHorizontal() {
		tmp = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				tmp[row][colSize-1-col] = map[row][col];
			}
		}
		map = tmp;
	}
	
	// 3-3. 90도회전: row와 col이 바뀌기 때문에 rowSize와 colSize를 서로 바꿔 tmp 배열을 만든다.
	private static void rotate90() {
		tmp = new int[colSize][rowSize];
    	for(int row=0; row<rowSize; row++){
    		for(int col=0; col<colSize; col++) {
    			tmp[col][rowSize-1-row] = map[row][col];
    		}
    	}
    	map = tmp;
    	// 전역변수 rowSize, colSize 서로 바꿔주기
    	swapRowColSize();
	}
	
	// 3-4. 270도회전: row와 col이 바뀌기 때문에 rowSize와 colSize를 서로 바꿔 tmp 배열을 만든다.
	private static void rotate270() {
		tmp = new int[colSize][rowSize];
    	for(int row=0; row<rowSize; row++){
    		for(int col=0; col<colSize; col++) {
    			// 3-4-1. row와 col을 반대로 하여 tmp 배열을 채워준다.
    			tmp[colSize-1-col][row] = map[row][col];
    		}
    	}
    	map = tmp;
    	// 전역변수 rowSize, colSize 서로 바꿔주기
    	swapRowColSize();
	}

	// 3-5. 시계방향 그룹옮기기: moveGroup(fromRow, fromCol, toRow, toCol) 4번 이용하여 tmp 배열로 halfSize만큼 옮겨준다.
	private static void command5() {
		tmp = new int[rowSize][colSize];
		moveGroup(0, 0, 0, colHalf);
		moveGroup(0, colHalf, rowHalf, colHalf);
		moveGroup(rowHalf, colHalf, rowHalf, 0);
		moveGroup(rowHalf, 0, 0, 0);
		map = tmp;
	}

	// 3-6. 반시계방향 그룹옮기기: moveGroup(fromRow, fromCol, toRow, toCol) 4번 이용하여 tmp 배열로 halfSize만큼 옮겨준다.
	private static void command6() {
		tmp = new int[rowSize][colSize];
		moveGroup(0, 0, rowHalf, 0);
		moveGroup(rowHalf, 0, rowHalf, colHalf);
		moveGroup(rowHalf, colHalf, 0, colHalf);
		moveGroup(0, colHalf, 0, 0);
		map = tmp;
	}
	
	private static void moveGroup(int fromRow, int fromCol, 
								  int toRow, int toCol) {
		for(int row=0; row<rowHalf; row++) {
			for(int col=0; col<colHalf; col++) {
				tmp[toRow+row][toCol+col] = map[fromRow+row][fromCol+col];
			}
		}
	}

	private static void swapRowColSize() {
		int temp = rowSize;
    	rowSize = colSize;
    	colSize = temp;
	}
	
	private static void printMap() {
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				sb.append(map[row][col]).append(' ');
			}
			sb.append('\n');
		}
	}
}
