import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, rowHalf, colHalf;
	static int[][] map, tmp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
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
		
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<cmdCnt; idx++) {
			int cmd = Integer.parseInt(st.nextToken());
			rowHalf = rowSize/2;
			colHalf = colSize/2;
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
		printMap();
		System.out.print(sb);
	}

	private static void flipVertical() {
		tmp = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			tmp[rowSize-1-row] = map[row];
		}
		map = tmp;
	}
	
	private static void flipHorizontal() {
		tmp = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				tmp[row][colSize-1-col] = map[row][col];
			}
		}
		map = tmp;
	}
	
	private static void rotate90() {
		tmp = new int[colSize][rowSize];
    	for(int row=0; row<rowSize; row++){
    		for(int col=0; col<colSize; col++) {
    			tmp[col][rowSize-1-row] = map[row][col];
    		}
    	}
    	map = tmp;
    	swapRowColSize();
	}
	
	private static void rotate270() {
		tmp = new int[colSize][rowSize];
    	for(int row=0; row<rowSize; row++){
    		for(int col=0; col<colSize; col++) {
    			tmp[colSize-1-col][row] = map[row][col];
    		}
    	}
    	map = tmp;
    	swapRowColSize();
	}

	private static void command5() {
		tmp = new int[rowSize][colSize];
		moveGroup(0, 0, 0, colHalf);
		moveGroup(0, colHalf, rowHalf, colHalf);
		moveGroup(rowHalf, colHalf, rowHalf, 0);
		moveGroup(rowHalf, 0, 0, 0);
		map = tmp;
	}

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