import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			boolean[] room = new boolean[num + 1];

			for(int round=1; round<=num; round++) {
				for(int idx=round; idx<=num; idx+=round) {
					room[idx] = !room[idx];
				}
			}

			int cnt = 0;
			for(int idx=1; idx<=num; idx++) {
				if(room[idx]) cnt++;
			}
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}
}
