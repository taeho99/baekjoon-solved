import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int c = 1;
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			result += 5;
			if(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1))
				c = 0;
			else
				c = 1;
			if(c == 1)
				result += 5;
		}
		System.out.println(result);
	}

}
