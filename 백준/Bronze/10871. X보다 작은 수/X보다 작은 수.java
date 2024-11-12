import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int x = input.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = input.nextInt();
		}
		for (int i = 0; i < a.length; i++) {
			if(x > a[i])
				System.out.print(a[i] + " ");
		}
	}

}
