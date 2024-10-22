import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a, b;
		do {
			a = input.nextInt();
			b = input.nextInt();
			if(a>b)
				System.out.println("Yes");
			else if(a == 0 && b == 0)
				break;
			else
				System.out.println("No");
		} while(true);
	}

}