import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int lo = 1, hi = 0, sum = 0;
		int[] arr = new int[size];
		for(int idx=0; idx<size; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
			hi = Math.max(arr[idx], hi);
			sum += arr[idx];
		}

		int budget = Integer.parseInt(br.readLine());

		if(sum <= budget) {
			System.out.println(hi);
			return;
		}

		while(lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if(isOk(arr, mid, budget)) lo = mid;
			else hi = mid;
		}
		System.out.println(lo);
	}

	private static boolean isOk(int[] arr, int mid, int budget) {
		int sum = 0;
		for (int i : arr) {
			sum += Math.min(i, mid);
		}
		return sum <= budget;
	}
}
