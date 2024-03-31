import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			
			for(int j=a; j<b+1; j++) {
				arr[j-1] = c;
			}
		}
		for(int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
	}

}