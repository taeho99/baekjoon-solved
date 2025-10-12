import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int size, minResult = Integer.MAX_VALUE;
	static int[] sourArr, bitterArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		size = Integer.parseInt(br.readLine());
		sourArr = new int[size];
		bitterArr = new int[size];

		for(int idx=0; idx<size; idx++) {
			st = new StringTokenizer(br.readLine());
			sourArr[idx] = Integer.parseInt(st.nextToken());
			bitterArr[idx] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 1, 0);
		System.out.println(minResult);
	}

	private static void powerSet(int depth, int sour, int bitter) {
		if(depth == size) {
			if(bitter == 0) return;
			minResult = Math.min(minResult, Math.abs(sour - bitter));
			return;
		}

		powerSet(depth+1, sour, bitter);
		powerSet(depth+1, sour*sourArr[depth], bitter+bitterArr[depth]);
	}
}
