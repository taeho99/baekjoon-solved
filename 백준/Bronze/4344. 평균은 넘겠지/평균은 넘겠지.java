import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		int n, total, cnt;
		int score[] = new int[1000];
		double avg;
		for(int i=0; i<c; i++) {
			n = input.nextInt();
			total = 0;
			cnt = 0;
			for(int j=0; j<n; j++) {
				score[j] = input.nextInt();
				total += score[j];
			}
			avg = (double)total / n;
			for(int j=0; j<n; j++) {
				if(score[j] > avg)
					cnt++;
			}
			System.out.printf("%.3f", 100.0*cnt/n);
			System.out.println("%");
		}
		
	}
}