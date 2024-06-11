import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if(n == 1) {
			System.out.println("1/1");
			return;
		}
		else if(n == 2) {
			System.out.println("1/2");
			return;
		} else if(n == 3) {
			System.out.println("2/1");
			return;
		}
		int ans = 1;
		int a = 3;
		boolean flag = true; //올라가는게 false 내려가는게 true
		while(true) {
			int n1, n2;
			if(flag) {
				n1 = 1;
				n2 = a - 1;
				for(int i=0; i<a-1; i++) {
					 
					 ans++;
					 if(ans == n) {
						 System.out.println(n1 + "/" + n2);
						 return;
					 }
					 n1++;
					 n2--;
				}
				flag = !flag;
			} else {
				n1 = a - 1;
				n2 = 1;
				for(int i=0; i<a-1; i++) {
					
					 ans++;
					 if(ans == n) {
						 System.out.println(n1 + "/" + n2);
						 return;
					 }
					 n1--;
					 n2++;
				}
				flag = !flag;
			}
			a++;
		}
	}
}