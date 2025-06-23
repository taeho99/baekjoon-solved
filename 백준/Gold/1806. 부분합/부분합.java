import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arrSize = Integer.parseInt(st.nextToken());
		int partialSum = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[arrSize+1];
		for(int idx=0; idx<arrSize; idx++) {
			arr[idx] = Integer.parseInt(st.nextToken());
		}

		int left = 0, right = 0, sum = 0;
		int resultMin = Integer.MAX_VALUE;
		while(left <= arrSize && right <= arrSize) {
			if (sum < partialSum) {
				sum += arr[right++];
			} else {
				resultMin = Math.min(resultMin, right - left);
				sum -= arr[left++];
			}
		}
		System.out.println(resultMin == Integer.MAX_VALUE ? "0" : resultMin);
	}
}