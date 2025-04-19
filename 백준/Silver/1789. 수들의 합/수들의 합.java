import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());

		long sum = 0;
		for(int i=1; ; i++) {
			if(sum > s) {
				System.out.println(i-2);
				return;
			}
			sum += i;
		}
	}
}