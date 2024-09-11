import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int tc = Integer.parseInt(st.nextToken());
			
			int result = 0;
			int[] heights = new int[20];
			for(int idx=0; idx<20; idx++) {
				int nowHeight = Integer.parseInt(st.nextToken());
				
				int tallIdx;
				for(tallIdx=0; tallIdx<idx; tallIdx++) {
					if(nowHeight < heights[tallIdx]) {
						break;
					}
				}
				
				if(tallIdx == idx) {
					heights[idx] = nowHeight;
				} else {
					for(int newIdx=idx; newIdx>tallIdx; newIdx--) {
						heights[newIdx] = heights[newIdx-1];
						result++;
					}
					heights[tallIdx] = nowHeight;
				}
			}
			sb.append(tc).append(' ').append(result).append('\n');
		}
		System.out.print(sb);
	}
}