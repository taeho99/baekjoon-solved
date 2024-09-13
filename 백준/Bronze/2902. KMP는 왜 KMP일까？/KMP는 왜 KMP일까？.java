import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				System.out.print(s.charAt(i));
		}
	}

}
