import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp1 = new int[n];
		Arrays.fill(dp1, 1);
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i-1; j++) {
				if(arr[i] > arr[j]) {
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
				}
			}
		}

		int[] dp2 = new int[n];
		Arrays.fill(dp2, 1);
		int result = 0;
		for(int i=n-1; i>=0; i--) {
			for(int j=n-1; j>=i; j--) {
				if(arr[i] > arr[j]) {
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
				}
			}
			result = Math.max(result, dp1[i] + dp2[i]);
		}

		System.out.println(result - 1);
	}
}
