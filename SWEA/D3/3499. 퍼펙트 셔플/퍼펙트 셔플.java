import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			sb.append('#').append(t).append(' ');
			int size = Integer.parseInt(br.readLine());
			String[] strArr = new String[size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<size; idx++) {
				strArr[idx] = st.nextToken();
			}
			
			int halfSize = (size+1)/2;
			for(int idx=0; idx<halfSize - 1; idx++) {
				sb.append(strArr[idx]).append(' ');
				sb.append(strArr[idx + halfSize]).append(' ');
			}

			sb.append(strArr[halfSize-1]).append(' ');
			if(size%2 == 0)
				sb.append(strArr[size-1]);
			
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
