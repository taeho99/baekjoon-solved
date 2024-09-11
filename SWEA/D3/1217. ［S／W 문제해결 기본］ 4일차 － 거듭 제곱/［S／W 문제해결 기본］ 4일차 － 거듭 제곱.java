import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc=1; tc<=T; tc++) {
			sc.nextInt();
			int num = sc.nextInt();
			int exp = sc.nextInt();
			
			System.out.println("#" + tc + " " + pow(num, exp, 1));
		}
	}

	private static int pow(int num, int exp, int result) {
		if(exp == 0) {
			return result;
		}
		return pow(num, exp-1, result*num);
	}
}