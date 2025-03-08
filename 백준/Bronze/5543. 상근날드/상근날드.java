import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] a = new int[3];
		int[] b = new int[2];
		for(int i=0; i<3; i++)
			a[i] = input.nextInt();
		for(int i=0; i<2; i++)
			b[i] = input.nextInt();
		int sum = 0;
		int min1 = a[0];
		for(int i=1; i<3; i++) {
			if(min1 > a[i])
				min1 = a[i];
		}
		int min2 = b[0];
		for(int i=1; i<2; i++) {
			if(min2 > b[i])
				min2 = b[i];
		}
		sum = min1 + min2 - 50;
		System.out.println(sum);
	}

}