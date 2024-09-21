import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int change = 1000 - n;
		int result = 0;
		result += change / 500;
		change %= 500;
		result += change / 100;
		change %= 100;
		result += change / 50;
		change %= 50;
		result += change / 10;
		change %= 10;
		result += change / 5;
		change %= 5;
		result += change / 1;
		change %= 1;
		System.out.println(result);
	}

}