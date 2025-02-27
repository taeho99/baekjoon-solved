import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	static int[] numList, opList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numList = new int[n];
		opList = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<n; idx++) {
			numList[idx] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<4; idx++) {
			opList[idx] = Integer.parseInt(st.nextToken());
		}

		calc(numList[0], 0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void calc(int sum, int selectIdx) {
		if(selectIdx == n - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for(int opIdx=0; opIdx<4; opIdx++) {
			if(opList[opIdx] == 0) continue;
			opList[opIdx]--;
			switch(opIdx) {
				case 0:
					calc(sum + numList[selectIdx + 1], selectIdx + 1);
					break;
				case 1:
					calc(sum - numList[selectIdx + 1], selectIdx + 1);
					break;
				case 2:
					calc(sum * numList[selectIdx + 1], selectIdx + 1);
					break;
				case 3:
					calc(sum / numList[selectIdx + 1], selectIdx + 1);
					break;
			}
			opList[opIdx]++;
		}
	}
}