import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int elementSize, target, result = 0;
	static int[] elementList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		elementSize = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		elementList = new int[elementSize];
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<elementSize; idx++) {
			elementList[idx] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 0);
		System.out.println(target == 0 ? result - 1 : result);
	}

	static void powerSet(int depth, int sum) {
		if(depth == elementSize) {
			if(sum == target) {
				result++;
			}
			return;
		}

		powerSet(depth+1, sum + elementList[depth]);
		powerSet(depth+1, sum);
	}
}
