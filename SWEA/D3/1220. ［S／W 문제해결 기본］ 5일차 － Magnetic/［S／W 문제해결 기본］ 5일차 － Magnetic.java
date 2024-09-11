import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			int size = Integer.parseInt(br.readLine());
			int[][] map = new int[size][size];
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int col=0; col<size; col++) {
				int lastValue = 0;
				for(int row=0; row<size; row++) {
					if(map[row][col] == 0) continue;
					if(lastValue == 1 && map[row][col] == 2) cnt++;
					lastValue = map[row][col];
				}
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}
}