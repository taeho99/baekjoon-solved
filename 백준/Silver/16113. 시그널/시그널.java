import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int size;
	static char[] signal;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		size = Integer.parseInt(br.readLine());
		signal = br.readLine().toCharArray();
		map = new char[5][size/5];

		if (size == 5) {
			System.out.print(1);
			return;
		}

		for(int row=0; row<5; row++) {
			for(int col=0; col<size/5; col++) {
				int idx = row * (size/5) + col;
				map[row][col] = signal[idx];
			}
		}

		if (isFirstOne()) {
			sb.append(1);
		}

		for(int c=0; c<size/5 - 2; c++) {
			for(int num=0; num<=9; num++) {
				if (isNumber(c, num)) {
					c += (num == 1 ? 1 : 2);
					sb.append(num);
					break;
				}
			}
		}

		if (isLastOne()) {
			sb.append(1);
		}

		System.out.print(sb);
	}

	static boolean isFirstOne() {
		for(int row=0; row<5; row++) {
			for(int col=0; col<=1; col++) {
				if (map[row][col] != pattern[1][row][col + 1]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isLastOne() {
		for(int row=0; row<5; row++) {
			for(int col=size/5 - 1; col>=size/5 - 2; col--) {
				int colIdx = (col - size/5) * (-1);
				if (map[row][col] != pattern[1][row][colIdx]) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean isNumber(int c, int num) {
		for(int row=0; row<5; row++) {
			for(int col=c; col<c+3; col++) {
				if (map[row][col] != pattern[num][row][col-c]) {
					return false;
				}
			}
		}
		return true;
	}

	static char[][][] pattern = {
		{   // 0
			{'#', '#', '#'},
			{'#', '.', '#'},
			{'#', '.', '#'},
			{'#', '.', '#'},
			{'#', '#', '#'}
		},
		{   // 1
			{'.', '#', '.'},
			{'.', '#', '.'},
			{'.', '#', '.'},
			{'.', '#', '.'},
			{'.', '#', '.'}
		},
		{   // 2
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'#', '#', '#'},
			{'#', '.', '.'},
			{'#', '#', '#'}
		},
		{   // 3
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'#', '#', '#'}
		},
		{   // 4
			{'#', '.', '#'},
			{'#', '.', '#'},
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'.', '.', '#'}
		},
		{   // 5
			{'#', '#', '#'},
			{'#', '.', '.'},
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'#', '#', '#'}
		},
		{   // 6
			{'#', '#', '#'},
			{'#', '.', '.'},
			{'#', '#', '#'},
			{'#', '.', '#'},
			{'#', '#', '#'}
		},
		{   // 7
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'.', '.', '#'},
			{'.', '.', '#'},
			{'.', '.', '#'}
		},
		{   // 8
			{'#', '#', '#'},
			{'#', '.', '#'},
			{'#', '#', '#'},
			{'#', '.', '#'},
			{'#', '#', '#'}
		},
		{   // 9
			{'#', '#', '#'},
			{'#', '.', '#'},
			{'#', '#', '#'},
			{'.', '.', '#'},
			{'#', '#', '#'}
		}
	};
}
