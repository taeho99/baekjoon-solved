import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		for(int i=0; i<c; i++) {
			String s= input.next();
			System.out.printf("%d\n", s.charAt(0)+s.charAt(2)-('0'*2));
		}
	}

}
