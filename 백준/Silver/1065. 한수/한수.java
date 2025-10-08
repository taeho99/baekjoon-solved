import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=1; i<=n; i++) {
			if(isHanNumber(i)) result++;
		}
		System.out.println(result);
	}

	private static boolean isHanNumber(int n) {
		if(n < 100) return true;
		int a = n / 100;
		int b = n % 100 / 10;
		int c = n % 10;
		return (a - b) == (b - c);
	}
}
