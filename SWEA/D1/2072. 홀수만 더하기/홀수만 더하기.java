import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int sum = 0;
			for(int idx=0; idx<10; idx++) {
				int tmp = sc.nextInt();
				if(tmp%2 == 1) sum += tmp;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}