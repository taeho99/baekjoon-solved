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
		sortByMergeSort(arr);
		for (int i : arr) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);
	}

	private static void sortByMergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length-1);
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid+1, end);
			merge(arr, tmp, start, mid, end);
		}
	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		for(int i=start; i<=end; i++) {
			tmp[i] = arr[i];
		}

		int part1 = start;
		int part2 = mid+1;
		int index = start;

		while(part1 <= mid && part2 <= end) {
			if(tmp[part1] <= tmp[part2]) {
				arr[index++] = tmp[part1++];
			} else {
				arr[index++] = tmp[part2++];
			}
		}

		for(int i=0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
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
