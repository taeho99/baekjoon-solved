import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());

		char[][] map = new char[rowSize][colSize];
		for(int row=0; row<rowSize; row++) {
			map[row] = br.readLine().toCharArray();
		}

		int result = Integer.MAX_VALUE;
		for(int startRow=0; startRow<=rowSize-8; startRow++) {
			for(int startCol=0; startCol<=colSize-8; startCol++) {
				int sum1 = 0, sum2 = 0;
				for(int row=0; row<8; row++) {
					for(int col=0; col<8; col++) {
						if (row % 2 == 0) {
							if (col % 2 == 0) {
								if (map[row+startRow][col+startCol] != 'W')
									sum1++;
								else
									sum2++;
							} else {
								if (map[row+startRow][col+startCol] != 'B')
									sum1++;
								else
									sum2++;
							}
						} else {
							if (col % 2 == 0) {
								if (map[row+startRow][col+startCol] != 'B')
									sum1++;
								else
									sum2++;
							} else {
								if (map[row+startRow][col+startCol] != 'W')
									sum1++;
								else
									sum2++;
							}
						}
					}
				}

				result = Math.min(result, Math.min(sum1, sum2));
			}
		}
		System.out.println(result);
	}
}