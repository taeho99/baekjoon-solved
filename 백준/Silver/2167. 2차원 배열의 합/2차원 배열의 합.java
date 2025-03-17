import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] matrix = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
		int c = input.nextInt();
		for(int i=0; i<c; i++) {
			int sum = 0;
			int a = input.nextInt();
			int b = input.nextInt();
			int x = input.nextInt();
			int y = input.nextInt();
			for(int j = a; j<=x; j++) {
				for(int k=b; k<=y; k++) {
					sum += matrix[j-1][k-1];
				}
			}
			System.out.println(sum);
		}
		
	}

}