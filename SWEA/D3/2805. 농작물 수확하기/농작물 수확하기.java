import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			
			for(int row=0; row<size; row++) {
				String input = br.readLine();
				for(int col=0; col<size; col++) {
					char ch = input.charAt(col);
					map[row][col] = ch - '0';
				}
			}
			
			int sum = 0;
			for(int row=0; row<size; row++) {
				if(row <= size/2) {
					for(int col=(size/2) - row; col<=(size/2) + row; col++) {
						sum += map[row][col];
					}
				} else {
					for(int col=(size/2) - (size-row-1); col<=(size/2) + (size-row-1); col++) {
						sum += map[row][col];
					}
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}

}
