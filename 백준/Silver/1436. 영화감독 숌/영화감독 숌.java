import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=666; i<1_000_000_000; i++) {
			if(isJongNum(i)) cnt++;
			if(cnt == num) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean isJongNum(int num) {
		return ("" + num).contains("666");
	}
}
