import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  BOJ.1992 쿼드트리
 *  
 * 	1. 영상의 크기와 영상 데이터를 입력받는다. 영상 데이터는 문자열 배열에 저장한다.
 * 	2. 영상을 사각형으로 나누어 확인한다.
 * 	3. 현재 영상이 쿼드트리이면 해당되는 0 또는 1을 출력하고 종료시킨다.
 * 	4. 쿼드트리 영상이 아니면 괄호를 열고 사각형 4개로 나누어 다시 쿼드트리 여부를 확인한다. 그리고 괄호를 닫는다.
 * 	5. 영상 압축 결과를 출력한다.
 */
public class Main {
	static String[] image;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 영상의 크기와 영상 데이터를 입력받는다. 영상 데이터는 문자열 배열에 저장한다.
		int size = Integer.parseInt(br.readLine());
		image = new String[size];
		for(int idx=0; idx<size; idx++) {
			image[idx] = br.readLine();
		}
		
		// 2. 영상을 사각형으로 나누어 확인한다.
		recur(size, 0, 0);
		
		// 5. 영상 압축 결과를 출력한다.
		System.out.print(sb);
	}
	
	static void recur(int size, int row, int col) {		
		// 3. 현재 영상이 쿼드트리이면 해당되는 0 또는 1을 출력하고 종료시킨다.
		if(isQuadTree(size, row, col, image[row].charAt(col))) {
			sb.append(image[row].charAt(col));
			return;
		}
		
		// 4. 쿼드트리 영상이 아니면 괄호를 열고 사각형 4개로 나누어 다시 쿼드트리 여부를 확인한다. 그리고 괄호를 닫는다.
		int half = size/2;
		sb.append('(');
		recur(half, row, col);
		recur(half, row, col+half);
		recur(half, row+half, col);
		recur(half, row+half, col+half);
		sb.append(')');
	}

	static boolean isQuadTree(int size, int row, int col, int startCh) {
		for(int r=row; r<row+size; r++) {
			for(int c=col; c<col+size; c++) {
				if(image[r].charAt(c) != startCh) return false;
			}
		}
		return true;
	}
}
