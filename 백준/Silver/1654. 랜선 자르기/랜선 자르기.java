import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int lanCnt, requireLanCnt;
	static int[] lanArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		lanCnt = Integer.parseInt(st.nextToken());
		requireLanCnt = Integer.parseInt(st.nextToken());

		lanArr = new int[lanCnt];
		long lo = 1, hi = 0;
		for(int idx = 0; idx< lanCnt; idx++) {
			lanArr[idx] = Integer.parseInt(br.readLine());
			hi = Math.max(hi, lanArr[idx]);
		}

		hi++;
		while(lo + 1 < hi) {
			long mid = (lo+hi) / 2;
			if(isOk(mid)) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		System.out.println(lo);
	}

	private static boolean isOk(long mid) {
		if(mid == 0) return true;
		long sum = 0;
		for (int len : lanArr) {
			sum += len/mid;
			if(sum >= requireLanCnt) return true;
		}
		return sum >= requireLanCnt;
	}
}
