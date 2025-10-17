import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int homeCnt = Integer.parseInt(st.nextToken());
		int routerCnt = Integer.parseInt(st.nextToken());

		List<Integer> home = new ArrayList<>();
		while(homeCnt-- > 0) {
			home.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(home);
		int lo = 1, hi = home.get(home.size()-1) - home.get(0) + 1;

		while(lo+1 < hi) {
			int mid = (lo+hi) / 2;
			if(check(home, routerCnt, mid)) hi = mid;
			else lo = mid;
		}
		System.out.println(lo);
	}

	private static boolean check(List<Integer> home, int routerCnt, int mid) {
		int cnt = 1;
		int last = home.get(0);
		for (Integer pos : home) {
			if(pos - last >= mid) {
				cnt++;
				last = pos;
			}
		}
		return cnt < routerCnt;
	}
}
