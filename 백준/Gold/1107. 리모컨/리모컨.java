import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String target = br.readLine();
		int targetNumber = Integer.parseInt(target);
		int result = Integer.MAX_VALUE;

		int brokenCnt = Integer.parseInt(br.readLine());
		if(brokenCnt == 0) {
			System.out.println(Math.min(target.length(), Math.abs(100 - targetNumber)));
			return;
		}
		boolean[] broken = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<brokenCnt; idx++) {
			broken[st.nextToken().charAt(0) - '0'] = true;
		}

		for(int idx=0; idx<=1_000_000; idx++) {
			if(isOk(idx, broken)) {
				result = Math.min(result, String.valueOf(idx).length() + Math.abs(idx - targetNumber));
			}
		}
		System.out.println(Math.min(result, Math.abs(100 - targetNumber)));
	}

	private static boolean isOk(int num, boolean[] broken) {
		if (num == 0) return !broken[0];
		while (num > 0) {
			if (broken[num % 10]) return false;
			num /= 10;
		}
		return true;
	}
}
