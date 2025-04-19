import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int idx=0; idx<n; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, total = 0, result = Integer.MAX_VALUE;

		while(left <= n && right <= n) {
			if(total >= s) {
				result = Math.min(result, right - left);
			}
			if (total < s) {
				total += arr[right++];
			} else {
				total -= arr[left++];
			}
		}
		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
	}
}