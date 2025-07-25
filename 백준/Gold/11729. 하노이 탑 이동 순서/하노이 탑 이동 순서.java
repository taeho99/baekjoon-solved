import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		hanoi(1,3,2,n);
		System.out.println(sb.length() / 4);
		System.out.print(sb);
	}

	private static void hanoi(int start, int end, int temp, int n) {
		if (n <= 0) {
			return;
		}

		hanoi(start, temp, end, n-1);
		sb.append(start).append(' ').append(end).append('\n');
		hanoi(temp, end, start, n-1);
	}
}
