import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] map = new boolean[101][101];
		for(int t=0; t<4; t++) {
			st = new StringTokenizer(br.readLine());
			int col1 = Integer.parseInt(st.nextToken());
			int row1 = Integer.parseInt(st.nextToken());
			int col2 = Integer.parseInt(st.nextToken());
			int row2 = Integer.parseInt(st.nextToken());

			for(int row=row1; row<row2; row++) {
				for(int col=col1; col<col2; col++) {
					map[row][col] = true;
				}
			}
		}

		int cnt = 0;
		for(int row=1; row<=100; row++) {
			for(int col=1; col<=100; col++) {
				if(map[row][col]) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
