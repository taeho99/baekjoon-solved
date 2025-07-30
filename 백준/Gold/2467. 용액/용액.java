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

		int left = 0, right = size-1;
		int minDiff = Integer.MAX_VALUE;
		int resultLeft = 0, resultRight = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if (minDiff > Math.abs(sum)) {
				minDiff = Math.abs(sum);
				resultLeft = arr[left];
				resultRight = arr[right];
			}

			if(sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(resultLeft + " " + resultRight);
	}
}
