import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int a[] = new int[n];
		Integer[] b = new Integer[n];
		for(int i=0; i<n; i++) {
			a[i] = input.nextInt();
		}
		for(int i=0; i<n; i++) {
			b[i] = input.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += a[i]*b[i];
		}
		System.out.println(sum);
	}

}