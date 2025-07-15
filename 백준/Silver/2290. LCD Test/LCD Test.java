import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(st.nextToken());
		String nums = st.nextToken();

		boolean[][] width = {
			{true, false, true},
			{false, false, false},
			{true, true, true},
			{true, true, true},
			{false, true, false},
			{true, true, true},
			{true, true, true},
			{true, false, false},
			{true, true, true},
			{true, true, true},
		};

		boolean[][] height = {
			{true, true, true, true},
			{false, true, false, true},
			{false, true, true, false},
			{false, true, false, true},
			{true, true, false, true},
			{true, false, false, true},
			{true, false, true, true},
			{false, true, false, true},
			{true, true, true, true},
			{true, true, false, true},
		};

		for(int row=0; row<2*size+3; row++) {
			for (char num : nums.toCharArray()) {
				if (row % (size+1) == 0) { // 가로
					sb.append(' ');
					if (width[num - '0'][row / (size+1)]) {
						for (int idx = 0; idx < size; idx++) {
							sb.append('-');
						}
					} else {
						for (int idx = 0; idx < size; idx++) {
							sb.append(' ');
						}
					}
					sb.append("  ");
				} else {
					sb.append(height[num - '0'][(row / (size+1))*2] ? '|' : ' ');
					for (int idx=0; idx<size; idx++) {
						sb.append(' ');
					}
					sb.append(height[num - '0'][(row / (size+1))*2 + 1] ? '|' : ' ').append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
