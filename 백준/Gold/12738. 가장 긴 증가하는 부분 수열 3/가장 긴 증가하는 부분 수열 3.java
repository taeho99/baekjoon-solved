import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int[] seq = new int[size];
		int[] LIS = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<size; idx++) {
			seq[idx] = Integer.parseInt(st.nextToken());
		}

		LIS[0] = seq[0];
		int length = 1;

		for(int idx=1; idx<size; idx++) {
			int key = seq[idx];

			if (LIS[length-1] < key) {
				LIS[length++] = key;
			} else {
				int lo = 0, hi = length;
				while(lo < hi) {
					int mid = (lo+hi) >>> 1;
					if(LIS[mid] < key) {
						lo = mid+1;
					} else {
						hi = mid;
					}
				}
				LIS[lo] = key;
			}
		}
		System.out.println(length);
	}
}
