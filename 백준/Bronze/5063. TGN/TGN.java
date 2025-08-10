import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] a = new int[3];
		int c = input.nextInt();
		for(int i=0; i<c; i++) {
			a[0] = input.nextInt();
			a[1] = input.nextInt();
			a[2] = input.nextInt();
			if(a[0] + a[2] > a[1])
				System.out.println("do not advertise");
			else if(a[0] + a[2] == a[1])
				System.out.println("does not matter");
			else
				System.out.println("advertise");
		}
	}

}
