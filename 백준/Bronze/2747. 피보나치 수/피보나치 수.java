import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n == 0 || n == 1) {
			System.out.println(n);
			return;
		}
		int[] a = new int[n + 1];
		a[0] = 0;
		a[1] = 1;
		for(int i=0; i<n - 1; i++) {
			a[i+2] = a[i] + a[i+1];
		}
		System.out.println(a[n]);
	}

}
