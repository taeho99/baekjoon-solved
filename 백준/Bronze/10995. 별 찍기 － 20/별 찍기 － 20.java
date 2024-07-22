import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		for(int i=0; i<n; i++) {
			if(i % 2 == 0) {
				System.out.println("* ".repeat(n));
			} else {
				System.out.println(" *".repeat(n));
			}
		}
	}
}