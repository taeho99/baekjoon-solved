import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String x = input.next();
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += Integer.parseInt("" + x.charAt(i));
		}
		System.out.println(sum);
	}

}
