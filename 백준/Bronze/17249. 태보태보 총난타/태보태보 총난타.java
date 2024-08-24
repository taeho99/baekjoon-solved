import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		int l = 0, r = 0;
		boolean a = false;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '0')
				a = true;
			if(str.charAt(i) == '@') {
				if(a)
					r++;
				else
					l++;
			}
		}
		System.out.println(l + " " + r);
	}

}