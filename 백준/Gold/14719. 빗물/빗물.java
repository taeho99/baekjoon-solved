import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[rowSize][colSize];
		st = new StringTokenizer(br.readLine());
		for(int col=0; col<colSize; col++) {
			int height = Integer.parseInt(st.nextToken());
			for(int row=rowSize-1; row>=rowSize-height; row--) {
				map[row][col] = true;
			}
		}

		int result = 0;
		for(int row=0; row<rowSize; row++) {
			int count =0;
			boolean existStartBlock = false;
			for(int col=0; col<colSize; col++) {
				if (map[row][col]) { // 블록이면
					if (existStartBlock)
						result += count;
					count = 0;
					existStartBlock = true;
				} else { // 빈 공간이면
					count++;
				}
			}
		}
		System.out.println(result);
	}
}