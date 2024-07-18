import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		long sum = 0;
		for(int i=1; i<=n.length(); i++) {
			sum += Math.pow(10, i-1) * i * 9;
		}
		sum -= n.length()*(Math.pow(10, n.length()) - Integer.parseInt(n) - 1);
		System.out.println(sum);
	}
}
