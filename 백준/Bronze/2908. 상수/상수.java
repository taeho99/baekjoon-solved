import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] n = new int[2];
		int[] d = new int[2];
		for(int i=0; i<2; i++) {
			n[i] = input.nextInt();
			int a = n[i] / 100;
			int b = n[i] % 100 / 10;
			int c = n[i] % 10;
			d[i] = a + b*10 + c*100;
		}
		System.out.println(d[0]>d[1] ? d[0] : d[1]);
	}

} 
