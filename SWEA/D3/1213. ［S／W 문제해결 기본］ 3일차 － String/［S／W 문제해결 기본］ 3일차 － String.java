import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			br.readLine();
			String target = br.readLine();
			String str = br.readLine();
			
			int cnt = 0;
			for(int idx=0; idx<=str.length() - target.length(); idx++) {
				String compare = str.substring(idx, idx+target.length());
				if(target.equals(compare)) cnt++;
			}
			
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}
}