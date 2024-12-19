import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(fact(input.nextInt()));
	}
	static int fact(int n) {
		if(n == 1 || n == 0)
			return 1;
		return n * fact(n-1);
	}
}
