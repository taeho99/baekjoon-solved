import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int rowSize, colSize, totalTime, airCleaner1=-1, airCleaner2=-1;
	static int[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		totalTime = Integer.parseInt(st.nextToken());
		
		map = new int[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0; col<colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == -1) {
					if(airCleaner1 == -1) airCleaner1 = row;
					else airCleaner2 = row;
				}
			}
		}
		
		while(totalTime-- > 0) {
			spread();
			upsideAirCleaner();
			downsideAirCleaner();
		}
		
		int result = 0;
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				result += map[row][col];
			}
		}
		System.out.println(result+2);
	}
	
	static void downsideAirCleaner() {
		for(int row=airCleaner2+1; row<rowSize-1; row++) {
			map[row][0] = map[row+1][0];
		}
		
		for(int col=0; col<colSize-1; col++) {
			map[rowSize-1][col] = map[rowSize-1][col+1];
		}
		
		for(int row=rowSize-1; row>=airCleaner2+1; row--) {
			map[row][colSize-1] = map[row-1][colSize-1];
		}
		
		for(int col=colSize-1; col>=1; col--) {
			map[airCleaner2][col] = map[airCleaner2][col-1];
		}
		
		map[airCleaner2][1] = 0;
	}

	static void upsideAirCleaner() {
		for(int row=airCleaner1-1; row>=1; row--) {
			map[row][0] = map[row-1][0];
		}
		
		for(int col=0; col<colSize-1; col++) {
			map[0][col] = map[0][col+1];
		}
		
		for(int row=0; row<airCleaner1; row++) {
			map[row][colSize-1] = map[row+1][colSize-1];
		}
		
		for(int col=colSize-1; col>=1; col--) {
			map[airCleaner1][col] = map[airCleaner1][col-1];
		}
		
		map[airCleaner1][1] = 0;
	}

	static void spread() {
		int[][] tmp = new int[rowSize][colSize];
		
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				if(map[row][col] == 0 || map[row][col] == -1) continue;
				
				for(int dir=0; dir<4; dir++) {
					int nRow = row + dRow[dir];
					int nCol = col + dCol[dir];
					
					if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || map[nRow][nCol] == -1)
						continue;
						
					int nQuantity = map[row][col]/5;
					tmp[nRow][nCol] += nQuantity;
					tmp[row][col] -= nQuantity;
				}
			}
		}
		
		for(int row=0; row<rowSize; row++) {
			for(int col=0; col<colSize; col++) {
				map[row][col] += tmp[row][col];
			}
		}
		
	}

}