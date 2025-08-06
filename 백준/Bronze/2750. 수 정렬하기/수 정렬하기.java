import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];

		for(int idx=0; idx<size; idx++) {
			arr[idx] = Integer.parseInt(br.readLine());
		}

		for(int i=size-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}

		for (int i : arr) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);
	}
}
