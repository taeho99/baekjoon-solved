import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[Integer.parseInt(br.readLine())];
		for(int idx=0; idx<arr.length; idx++) {
			arr[idx] = Integer.parseInt(br.readLine());
		}
		sortBySelectionSort(arr);
		for (int i : arr) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);
	}

	private static void sortBySelectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[minIdx] > arr[j]) minIdx = j;
			}
			swap(arr, i, minIdx);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
