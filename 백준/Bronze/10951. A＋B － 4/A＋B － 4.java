import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()) {
			System.out.println(input.nextInt() + input.nextInt());
		}
	}
}
