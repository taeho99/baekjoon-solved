import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	// 100,000,000,000
	static Map<Long, Long> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		init();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			long num = Long.parseLong(br.readLine());
			int cnt = 0;
			while(num != 2) {
				if(map.containsKey(num)) {
					num = map.get(num);
					cnt++;
				} else {
					long sqrt = (long)Math.sqrt(num);
					long tmp = (sqrt+1)*(sqrt+1) - num;
					num += tmp;
					cnt += tmp;
				}
			}
			sb.append('#').append(tc).append(' ').append(cnt).append('\n');
		}
		System.out.print(sb);
	}
	static void init() {
		map = new HashMap<>();
		for(long idx=1; idx<=1_000_000; idx++) {
			map.put(idx*idx, idx);
		}
	}
}
