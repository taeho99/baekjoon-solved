import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<size; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}

		int lo = 0, hi = size - 1;
		int minDiff = Integer.MAX_VALUE;
		int resultLo = -1, resultHi = -1;
		while(lo < hi) {
			int diff = arr[lo] + arr[hi];
			if(minDiff > Math.abs(diff)) {
				minDiff = Math.abs(diff);
				resultLo = lo;
				resultHi = hi;
			}
			if(diff < 0) {
				lo++;
			} else {
				hi--;
			}
		}
		System.out.println(arr[resultLo] + " " + arr[resultHi]);
	}
}
