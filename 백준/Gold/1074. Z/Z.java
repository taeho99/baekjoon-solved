import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ.1074 Z 
 *
 * 1. 배열의 크기와 row 인덱스, col 인덱스를 입력받는다.
 * 2. 크기를 절반으로 줄이고 row와 col을 사각형의 왼쪽 위 인덱스로 하여 재귀호출 한다.
 * 		2-1. 사각형 크기가 1일 때를 기저조건으로 설정한다.
 * 		2-2. 목표 r행 c열이 현재 사각형에서 어느 사분면인지에 따라 다른 로직 실행
 * 			2-2-1. 1사분면일 경우 추가되는 cnt 없음
 * 			2-2-2. 2사분면일 경우
 * 			2-2-3. 3사분면일 경우
 * 			2-2-4. 4사분면일 경우
 * 3. cnt를 출력한다.
 */
public class Main {
	static int rowIdx, colIdx, cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. 배열의 크기와 row 인덱스, col 인덱스를 입력받는다.
		int SIZE = (int)(Math.pow(2, Integer.parseInt(st.nextToken())));
		 rowIdx = Integer.parseInt(st.nextToken());
		 colIdx = Integer.parseInt(st.nextToken());
		
		// 2. 크기를 절반으로 줄이고 row와 col을 사각형의 왼쪽 위 인덱스로 하여 재귀호출 한다.
		recur(SIZE, 0, 0);
		// 3. cnt를 출력한다.
		System.out.println(cnt);
	}
	static void recur(int size, int row, int col) {
		// 2-1. 사각형 크기가 1일 때를 기저조건으로 설정한다.
		if(size == 1)
			return;
		int half = size/2;
		// 2-2. 목표 r행 c열이 현재 사각형에서 어느 사분면인지에 따라 다른 로직 실행
		// 2-2-1. 1사분면일 경우 추가되는 cnt 없음
		if(rowIdx < row+half && colIdx < col+half)
			recur(half, row, col);
		// 2-2-2. 2사분면일 경우
		else if(rowIdx < row+half && colIdx >= col+half) {
			cnt += size*size/4;
			recur(half, row, col+half);
		}
		// 2-2-3. 3사분면일 경우
		else if(rowIdx >= row+half && colIdx < col+half) {
			cnt += size*size/4*2;
			recur(half, row+half, col);
		}
		// 2-2-4. 4사분면일 경우
		else {
			cnt += size*size/4*3;
			recur(half, row+half, col+half);
		}
		
	}

}
