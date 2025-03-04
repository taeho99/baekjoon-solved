import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		if(t % 10 != 0) {
			System.out.println(-1);
			return;
		}
		int a, b, c;
		a = t/300;
		t %= 300;
		b = t/60;
		t %= 60;
		c = t/10;
		t %= 10;
		System.out.println(a + " " + b + " " + c);
	}

}