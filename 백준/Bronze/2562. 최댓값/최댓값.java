import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n[] = new int[9];
		n[0] = input.nextInt();
		int min = n[0];
		for(int i=1; i<n.length; i++) {
			n[i] = input.nextInt();
			if(n[i] > min)
				min = n[i];
		}
		System.out.print(min + " ");
		for(int i=0; i<n.length; i++) {
			if(min == n[i])
				System.out.println(i + 1);
		}
		
	}

}