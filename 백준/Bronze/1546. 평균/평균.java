import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		float score[] = new float[n];
		float max = 0;
		for(int i=0; i<n; i++) {
			score[i] = input.nextInt();
			if(max < score[i])
				max = score[i];
		}
		float result = 0;
		for(int i=0; i<n; i++) {
			score[i] = score[i]/max*100;
			result += score[i];
		}
		System.out.println(result/n);
	}

}