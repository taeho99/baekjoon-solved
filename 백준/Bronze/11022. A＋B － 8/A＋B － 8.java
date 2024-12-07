import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		for(int i=0; i<row; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int tmp = i+1;
			System.out.printf("Case #%d: %d + %d = %d\n", tmp, a, b, a+b);
		}
		
	}

}
