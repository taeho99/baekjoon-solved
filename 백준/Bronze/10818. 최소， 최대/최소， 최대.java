import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = input.nextInt();
		}
		Arrays.sort(a);
		System.out.println(a[0] + " " + a[a.length - 1]);
	}
}
