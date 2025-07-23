import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		if (size == 1) {
			System.out.print("*");
			return;
		}
		for(int row=0; row<size*2; row++) {
			for(int col=0; col<size; col++) {
				if((row%2 == 0 && col%2 == 0) || (row%2 == 1 && col%2 == 1)) {
					sb.append('*');
				} else {
					sb.append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
